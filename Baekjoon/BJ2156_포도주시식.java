package week15;

import java.io.*;

public class BJ2156_포도주시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int dp[][] = new int[n][3]; // 최대로 마실 수 있는 포도주의 양
		int wine = Integer.parseInt(in.readLine()); // 잔에 들은 포도주의 양
		dp[0][0] = 0;
		dp[0][2] = dp[0][1] = wine;
		for (int i = 1; i < n; i++) {
			wine = Integer.parseInt(in.readLine());
			// i번째 포도주 잔을 선택하지 않았음
			dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
			// i번째 포도주 잔을 연속 첫번째 선택
			dp[i][1] = dp[i-1][0]+wine;
			// i번째 포도주 잔을 연속 두번째 선택
			dp[i][2] = dp[i-1][1]+wine;
		}
		System.out.println(Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
	}

}
