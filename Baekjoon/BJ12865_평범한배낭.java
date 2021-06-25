package week19;

import java.io.*;
import java.util.*;

public class BJ12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int W[] = new int[N + 1];
		int V[] = new int[N + 1];
		int dp[][] = new int[N + 1][K + 1];

		// 각 물건의 무게와 해당 물건의 가치
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		// i번째 물건까지 무게마다 가치합의 최댓값
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i-1][j]; // 바로 전의 최댓값
				if (W[i] <= j) {
					// 현재 물건을 넣었을 때의 가치로 최댓값 갱신
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - W[i]] + V[i]);
				}
			}
		}
		
		// 배낭에 넣을 수 있는 물건들의 가치합의 최댓값
		System.out.println(dp[N][K]);
	}

}
