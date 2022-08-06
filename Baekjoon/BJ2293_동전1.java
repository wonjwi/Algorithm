package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coin[] = new int[n + 1];
		int dp[] = new int[k + 1];

		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}

		// 합이 0이 되는 경우의 수
		dp[0] = 1;

		// 합이 k가 되는 경우의 수
		for (int i = 1; i <= n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		System.out.println(dp[k]);
	}

}