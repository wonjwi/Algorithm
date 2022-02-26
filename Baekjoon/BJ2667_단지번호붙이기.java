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
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}

		Queue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1' && !visited[i][j]) {
					pq.add(check(i, j));
				}
			}
		}

		sb.append(pq.size()).append("\n");

		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static int check(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;
		int cnt = 1;

		while (!queue.isEmpty()) {
			int tmp[] = queue.poll();

			for (int d = 0; d < 4; d++) {
				int r = tmp[0] + dr[d];
				int c = tmp[1] + dc[d];

				if (r < 0 || r >= N || c < 0 || c >= N)
					continue;

				if (map[r][c] == '1' && !visited[r][c]) {
					queue.add(new int[] { r, c });
					visited[r][c] = true;
					cnt++;
				}
			}
		}

		return cnt;
	}

}