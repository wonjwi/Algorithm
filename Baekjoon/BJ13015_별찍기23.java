package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		for (int i = 1; i < N * 2; i++) {
			int space = i < N ? i - 1 : N * 2 - i - 1;
			for (int j = 0; j < space; j++) {
				sb.append(" ");
			}

			sb.append("*");
			for (int j = 1; j < N - 1; j++) {
				sb.append(i == 1 || i == N * 2 - 1 ? "*" : " ");
			}
			sb.append("*");

			space = i < N ? (N - i) * 2 - 1 : (i - N) * 2 - 1;
			for (int j = 0; j < space; j++) {
				sb.append(" ");
			}

			sb.append(i == N ? "" : "*");
			for (int j = 1; j < N - 1; j++) {
				sb.append(i == 1 || i == N * 2 - 1 ? "*" : " ");
			}
			sb.append("*\n");
		}

		System.out.println(sb.toString());
	}

}