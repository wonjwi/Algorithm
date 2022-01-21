package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		int dp[][] = new int[N + 1][2];

		for (int i = 2; i <= N; i++) {
			dp[i][0] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < N; i++) {
			if (i * 3 <= N && dp[i * 3][0] > dp[i][0] + 1) {
				dp[i * 3][0] = dp[i][0] + 1;
				dp[i * 3][1] = i;
			}

			if (i * 2 <= N && dp[i * 2][0] > dp[i][0] + 1) {
				dp[i * 2][0] = dp[i][0] + 1;
				dp[i * 2][1] = i;
			}

			if (dp[i + 1][0] > dp[i][0] + 1) {
				dp[i + 1][0] = dp[i][0] + 1;
				dp[i + 1][1] = i;
			}
		}

		sb.append(dp[N][0]).append("\n").append(N);

		while (dp[N][0] > 0) {
			sb.append(" ").append(dp[N][1]);
			N = dp[N][1];
		}

		System.out.println(sb.toString());
	}

}