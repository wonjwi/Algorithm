package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str1 = in.readLine();
		String str2 = in.readLine();
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				dp[i][j] = str1.charAt(i - 1) == str2.charAt(j - 1) ? dp[i - 1][j - 1] + 1
						: Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		System.out.println(dp[str1.length()][str2.length()]);
	}

}