package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static int N, max, answer;
	static int map[][];
	static boolean checked[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];

		// 해당 지역의 높이 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		// 비의 양에 따른 모든 경우를 조사
		for (int h = max - 1; h >= 0; h--) {
			checked = new boolean[N][N];
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= h || checked[i][j])
						continue;

					cnt++;
					find(i, j, h);
				}
			}

			answer = Math.max(answer, cnt);
		}

		// 안전 영역의 최대 개수 출력
		System.out.println(answer);
	}

	private static void find(int i, int j, int h) {
		Queue<int[]> safe = new LinkedList<>();
		safe.add(new int[] { i, j });
		checked[i][j] = true;

		while (!safe.isEmpty()) {
			int tmp[] = safe.poll();

			for (int d = 0; d < 4; d++) {
				int r = tmp[0] + dr[d];
				int c = tmp[1] + dc[d];

				if (r < 0 || r >= N || c < 0 || c >= N)
					continue;

				if (checked[r][c] || map[r][c] <= h)
					continue;

				safe.add(new int[] { r, c });
				checked[r][c] = true;
			}
		}
	}

}