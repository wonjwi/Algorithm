package algorithm;

import java.io.*;

public class Main {

	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		int map[][] = new int[N + 1][N + 1];
		int r = 1, c = 1, idx = 0, answer[] = new int[2];

		for (int i = N * N; i >= 1; i--) {
			map[r][c] = i;

			if (i == K) {
				answer[0] = r;
				answer[1] = c;
			}

			int tr = r + dr[idx];
			int tc = c + dc[idx];

			if (tr <= 0 || tr > N || tc <= 0 || tc > N || map[tr][tc] != 0) {
				idx = (idx + 1) % 4;
			}

			r += dr[idx];
			c += dc[idx];
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(answer[0]).append(" ").append(answer[1]);

		System.out.println(sb.toString());
	}

}