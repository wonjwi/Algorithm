package algorithm;

import java.io.*;

public class Main {

	static int people[][] = new int[15][15];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		int k, n;

		for (int i = 0; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				if (i == 0) {
					people[i][j] = j;
					continue;
				}
				people[i][j] = people[i][j - 1] + people[i - 1][j];
			}
		}

		for (int tc = 0; tc < T; tc++) {
			k = Integer.parseInt(in.readLine());
			n = Integer.parseInt(in.readLine());

			sb.append(people[k][n]).append("\n");
		}

		System.out.println(sb.toString());
	}

}