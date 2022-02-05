package algorithm;

import java.io.*;
import java.util.*;

public class BJ12100_2048 {

	static int N, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		int map[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		play(map, 0);

		System.out.println(answer);
	}

	private static void play(int[][] map, int cnt) {
		if (cnt == 5) {
			answer = Math.max(answer, max(map));
			return;
		}

		int originMap[][] = new int[N][N];
		copy(originMap, map);

		// 왼쪽으로 이동
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			int idx = -1;
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;

				if (!flag && idx >= 0 && map[i][idx] == map[i][j]) {
					map[i][idx] *= 2;
					flag = true;
				} else {
					map[i][++idx] = map[i][j];
					flag = false;
				}
				if (idx != j)
					map[i][j] = 0;
			}
		}
		play(map, cnt + 1);
		copy(map, originMap);

		// 오른쪽으로 이동
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			int idx = N;
			for (int j = N - 1; j >= 0; j--) {
				if (map[i][j] == 0)
					continue;

				if (!flag && idx < N && map[i][idx] == map[i][j]) {
					map[i][idx] *= 2;
					flag = true;
				} else {
					map[i][--idx] = map[i][j];
					flag = false;
				}
				if (idx != j)
					map[i][j] = 0;
			}
		}
		play(map, cnt + 1);
		copy(map, originMap);

		// 위쪽으로 이동
		for (int j = 0; j < N; j++) {
			boolean flag = false;
			int idx = -1;
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 0)
					continue;

				if (!flag && idx >= 0 && map[idx][j] == map[i][j]) {
					map[idx][j] *= 2;
					flag = true;
				} else {
					map[++idx][j] = map[i][j];
					flag = false;
				}
				if (idx != i)
					map[i][j] = 0;
			}
		}
		play(map, cnt + 1);
		copy(map, originMap);

		// 아래쪽으로 이동
		for (int j = 0; j < N; j++) {
			boolean flag = false;
			int idx = N;
			for (int i = N - 1; i >= 0; i--) {
				if (map[i][j] == 0)
					continue;

				if (!flag && idx < N && map[idx][j] == map[i][j]) {
					map[idx][j] *= 2;
					flag = true;
				} else {
					map[--idx][j] = map[i][j];
					flag = false;
				}
				if (idx != i)
					map[i][j] = 0;
			}
		}
		play(map, cnt + 1);
		copy(map, originMap);
	}

	private static void copy(int[][] copyMap, int[][] originMap) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = originMap[i][j];
			}
		}
	}

	private static int max(int[][] map) {
		StringBuilder sb = new StringBuilder();
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, map[i][j]);
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		if (max == 128) {
			System.out.println(sb.toString());
		}

		return max;
	}

}