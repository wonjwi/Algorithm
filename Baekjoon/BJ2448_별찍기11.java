package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		char map[][] = new char[N][2 * N - 1];

		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}

		star(map, N, 0, 0);

		for (int i = 0; i < N; i++) {
			sb.append(map[i]).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void star(char[][] map, int N, int i, int j) {
		if (N == 3) {
			map[i][j + 2] = '*';
			map[i + 1][j + 1] = map[i + 1][j + 3] = '*';
			map[i + 2][j] = map[i + 2][j + 1] = map[i + 2][j + 2] = map[i + 2][j + 3] = map[i + 2][j + 4] = '*';
			return;
		}

		star(map, N / 2, i, j + N / 2);
		star(map, N / 2, i + N / 2, j);
		star(map, N / 2, i + N / 2, j + N);
	}

}