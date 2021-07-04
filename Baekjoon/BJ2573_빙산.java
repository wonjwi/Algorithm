package week20;

import java.io.*;
import java.util.*;

public class BJ2573_빙산 {

	static int N, M, map[][], temp[][];
	static boolean visited[][];
	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp = new int[N][M];

		// 빙산의 초기 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0, iceCnt = 0;

		while (true) {
			// 빙산이 녹는다
			melt();
			answer++; // 1년 증가

			// 빙산이 하나도 안 남았을 경우
			iceCnt = getIceCnt();
			if (iceCnt == 0) {
				answer = 0;
				break;
			}

			// 빙산이 두 덩어리 이상인지 검사
			visited = new boolean[N][M];
			if (check()) {
				break;
			}
		}

		// 빙산이 분리되는 최초의 시간 출력
		System.out.println(answer);
	}

	private static int getIceCnt() {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) { // 빙산이면
					cnt++;
				}
			}
		}

		return cnt;
	}

	private static void melt() {
		int cnt = 0, r, c;

		// 다음에 녹을 양 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) { // 빙산이면
					cnt = 0;
					for (int d = 0; d < 4; d++) {
						r = i + dr[d];
						c = j + dc[d];
						if (map[r][c] <= 0)
							cnt++;
					}
					temp[i][j] = cnt;
				}
			}
		}

		// 빙산의 1년 후 상태 적용
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) { // 빙산이면
					map[i][j] -= temp[i][j];
				}
			}
		}
	}

	private static boolean check() {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] > 0) {
					// 두 덩어리 이상이면 종료
					if (++cnt >= 2) {
						return true;
					}
					DFS(i, j);
				}
			}
		}

		return false;
	}

	private static void DFS(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int row = r + dr[d];
			int col = c + dc[d];

			// 이어진 곳이 있으면 계속 탐색
			if (!visited[row][col] && map[row][col] > 0) {
				DFS(row, col);
			}
		}
	}

}
