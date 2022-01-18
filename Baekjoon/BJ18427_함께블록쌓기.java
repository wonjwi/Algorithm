package week28;

import java.io.*;
import java.util.*;

public class BJ18427_함께블록쌓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int block[][] = new int[51][1001];
		int dp[][] = new int[51][1001];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());

			// i번째 학생이 가진 블록 개수
			block[i][0] = st.countTokens();

			for (int j = 1; j <= block[i][0]; j++) {
				block[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		// 높이 0을 만드는 경우의 수
		for (int i = 0; i <= 50; i++) {
			dp[i][0] = 1;
		}

		// 높이 j를 만드는 경우의 수
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= H; j++) {
				// i번째 학생이 블록을 놓는 경우
				for (int k = 1; k <= block[i][0]; k++) {
					if (j - block[i][k] >= 0) {
						dp[i][j] += dp[i - 1][j - block[i][k]];
						dp[i][j] %= 10007;
					}
				}

				// i번째 학생이 블록을 놓지 않는 경우
				dp[i][j] += dp[i - 1][j];
				dp[i][j] %= 10007;
			}
		}

		// 높이 H를 만드는 경우의 수
		System.out.println(dp[N][H]);
	}

}