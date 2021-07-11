package week21;

import java.io.*;

public class BJ2482_색상환 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		int dp[][] = new int[N+1][K+1];
		
		// K = 1일 때 경우의 수는 N개
		for (int i = 1; i <= N; i++) {
			dp[i][1] = i;
		}
		
		for (int n = 4; n <= N; n++) {
			for (int k = 2; k <= K; k++) {
				// N < 2*K이면 경우의 수는 없음
				if (N < 2*K) break;
				dp[n][k] = dp[n-1][k] + dp[n-2][k-1];
				dp[n][k] %= 1000000003;
			}
		}
		
		// 경우의 수를 10억 3으로 나눈 나머지
		System.out.println(dp[N][K]);
	}
	
}

/*
// 점화식을 찾기 위해서 완전탐색으로 경우의 수를 구해봄
static int N, K, cCount;

private static void makeCombination(int[] result, int cnt, int start) {
	if (cnt == K) {
		System.out.println(Arrays.toString(result));
		cCount++;
		return;
	}
	for (int i = start; i < N; i++) {
		if (result[0] == 0 && i == N - 1) continue;
		result[cnt] = i;
		makeCombination(result, cnt + 1, i + 2);
	}
}
 */
