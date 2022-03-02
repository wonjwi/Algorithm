package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static class Knight {
		int r, c, cnt;

		public Knight(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int dr[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int dc[] = { -2, -1, 1, 2, -2, -1, 1, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			int I = Integer.parseInt(in.readLine());
			boolean visited[][] = new boolean[I][I];

			Queue<Knight> queue = new LinkedList<>();
			st = new StringTokenizer(in.readLine());
			int start[] = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			queue.add(new Knight(start[0], start[1], 0));
			visited[start[0]][start[1]] = true;

			st = new StringTokenizer(in.readLine());
			int target[] = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			while (!queue.isEmpty()) {
				Knight tmp = queue.poll();
				int r = tmp.r;
				int c = tmp.c;
				int cnt = tmp.cnt;

				if (r == target[0] && c == target[1]) {
					sb.append(cnt).append("\n");
					break;
				}

				for (int d = 0; d < 8; d++) {
					int row = r + dr[d];
					int col = c + dc[d];

					if (row < 0 || row >= I || col < 0 || col >= I || visited[row][col])
						continue;

					queue.add(new Knight(row, col, cnt + 1));
					visited[row][col] = true;
				}
			}
		}

		System.out.println(sb.toString());
	}

}