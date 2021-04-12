package week11;

import java.io.*;
import java.util.StringTokenizer;

public class BJ9465_스티커 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		int[][] sticker = new int[2][100001];
		int[][] dp = new int[3][100001];
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(in.readLine());
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 해당 위치의 점수 최대 합
			// 0번줄 선택, 1번줄 선택, 둘 다 선택X
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			dp[2][0] = 0;
			for (int j = 1; j < n; j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[2][j-1])+sticker[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[2][j-1])+sticker[1][j];
				dp[2][j] = Math.max(dp[0][j-1], dp[1][j-1]);
			}
			sb.append(Math.max(Math.max(dp[0][n-1], dp[1][n-1]), dp[2][n-1])).append("\n");
		}
		System.out.println(sb.toString());
	}

}
