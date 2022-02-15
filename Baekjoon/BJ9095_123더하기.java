package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(in.readLine());

			int dp[] = new int[11];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;

			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}

			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb.toString());
	}

}