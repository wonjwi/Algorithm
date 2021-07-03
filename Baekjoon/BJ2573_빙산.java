package week20;

import java.io.*;
import java.util.*;

public class BJ2573_빙산 {

	static int N, M, map[][], answer;
	static Queue<int[]> ice;
	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ice = new LinkedList<int[]>();

		// 빙산의 초기 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					ice.add(new int[] { i, j });
				}
			}
		}

		// 빙산이 녹기 시작
		melt();

		// 빙산이 분리되는 최초의 시간 출력
		System.out.println(answer);
	}

	private static void melt() {
		while (true) {
			int size = ice.size(), tmp[], cnt, r, c;

			// 얼음이 다음에 녹을 양 구하기
			for (int i = 0; i < size; i++) {
				tmp = ice.poll();
				cnt = 0;
				for (int d = 0; d < 4; d++) {
					r = tmp[0] + dr[d];
					c = tmp[1] + dc[d];
					if (map[r][c] == 0) cnt++;
				}
				ice.add(new int[] { tmp[0], tmp[1], cnt });
			}
			answer++; // 1년 증가

			// 빙산의 1년 후 상태 구하기
			for (int i = 0; i < size; i++) {
				tmp = ice.poll();
				r = tmp[0];
				c = tmp[1];
				cnt = tmp[2];

				map[r][c] -= cnt;
				if (map[r][c] <= 0) {
					map[r][c] = 0;
				} else {
					ice.add(new int[] { r, c });
				}
			}

			// 빙산이 두 덩어리 이상인지 검사
			if (check()) break;
		}
	}

	private static boolean check() {
		boolean visited[][] = new boolean[N][M];
		int size = ice.size(), tmp[], tr, tc, r, c;

		Queue<int[]> queue = new LinkedList<int[]>();
		// 빙산이 이미 다 녹았으면 0 출력
		if (ice.isEmpty()) {
			answer = 0;
			return true;
		} else {
			queue.add(ice.peek());
		}

		while (!queue.isEmpty()) {
			tmp = queue.poll();
			tr = tmp[0];
			tc = tmp[1];
			visited[tr][tc] = true;
			size--;

			for (int d = 0; d < 4; d++) {
				r = tr + dr[d];
				c = tc + dc[d];
				if (!visited[r][c] && map[r][c] > 0) {
					visited[r][c] = true;
					queue.add(new int[] { r, c });
				}
			}
		}

		return size == 0 ? false : true;
	}

}
