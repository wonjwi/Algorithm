package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		boolean map[][] = new boolean[N][N];

		star(map, N, 0, 0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j] ? '*' : ' ');
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void star(boolean[][] map, int N, int i, int j) {
		if (N == 1) {
			map[i][j] = true;
			return;
		}

		for (int k = 0; k < 9; k++) {
			if (k == 4) {
				continue;
			}

			star(map, N / 3, i + (N / 3) * (k / 3), j + (N / 3) * (k % 3));
		}
	}

}