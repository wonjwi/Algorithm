package week13;

import java.io.*;
import java.util.*;

public class BJ1932_정수삼각형 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(in.readLine());
		int map[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 가장자리의 값 미리 구하기
		int dp[][] = new int[n][n];
		dp[0][0] = map[0][0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = map[i][0] + dp[i-1][0];
			dp[i][i] = map[i][i] + dp[i-1][i-1];
		}
		// 현재 선택된 수의 대각선 왼쪽/오른쪽에서 선택
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				dp[i][j] = map[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		// 합이 최대가 되는 경로의 합
		Arrays.sort(dp[n-1]);
		System.out.println(dp[n-1][n-1]);
	}

}
