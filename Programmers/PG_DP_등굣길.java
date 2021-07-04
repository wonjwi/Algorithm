package week20;

public class PG_DP_등굣길 {

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int puddles[][] = { { 2, 2 } };

		System.out.println(solution(m, n, puddles));
	}

	static public int solution(int m, int n, int[][] puddles) {
		boolean map[][] = new boolean[m + 1][n + 1];
		int dp[][] = new int[m + 1][n + 1];

		// 물에 잠긴 지역 입력
		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][0]][puddles[i][1]] = true;
		}

		// 집에서 학교까지 갈 수 있는 최단경로의 개수
		for (int i = 1; i <= m; i++) {
			// 물에 잠긴 곳은 지나갈 수 없음
			if (map[i][1]) {
				break;
			}
			dp[i][1] = 1;
		}
		for (int j = 1; j <= n; j++) {
			// 물에 잠긴 곳은 지나갈 수 없음
			if (map[1][j]) {
				break;
			}
			dp[1][j] = 1;
		}
		for (int i = 2; i <= m; i++) {
			for (int j = 2; j <= n; j++) {
				if (map[i][j]) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
				}
			}
		}

		return dp[m][n];
	}

}
