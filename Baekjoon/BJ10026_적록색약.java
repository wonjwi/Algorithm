package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static char map[][];
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int ordinaryCnt = 0, colorBlindCnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) {
					continue;
				}
				searchMap(i, j, map[i][j], false);
				ordinaryCnt++;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) {
					continue;
				}
				searchMap(i, j, map[i][j], true);
				colorBlindCnt++;
			}
		}

		System.out.println(ordinaryCnt + " " + colorBlindCnt);
	}

	private static void searchMap(int i, int j, char ch, boolean isColorBlind) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			int r = queue.peek()[0];
			int c = queue.poll()[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) {
					continue;
				}
				if (ch == map[nr][nc] || (isColorBlind && ch != 'B' && map[nr][nc] != 'B')) {
					queue.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
	}

}