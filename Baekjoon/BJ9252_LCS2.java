package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String str1 = in.readLine();
		String str2 = in.readLine();
		int len1 = str1.length(), len2 = str2.length();
		int dp[][] = new int[len1 + 1][len2 + 1];

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				dp[i][j] = str1.charAt(i - 1) == str2.charAt(j - 1) ? dp[i - 1][j - 1] + 1
						: Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		System.out.println(dp[len1][len2]);

		if (dp[len1][len2] == 0) {
			return;
		}

		StringBuilder sb = new StringBuilder();
		int r = len1, c = len2;

		while (true) {
			if (dp[r][c] == dp[r - 1][c]) {
				r--;
			} else if (dp[r][c] == dp[r][c - 1]) {
				c--;
			} else {
				sb.append(str2.charAt(c - 1));
				r--;
				c--;
			}
			if (dp[r][c] == 0)
				break;
		}
		System.out.println(sb.reverse().toString());
	}

}