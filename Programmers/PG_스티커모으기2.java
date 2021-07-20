package week23;

public class PG_스티커모으기2 {

	public static void main(String[] args) {
		// 원형으로 연결된 스티커의 각 칸의 숫자
		int sticker[] = { 14, 6, 5, 11, 3, 9, 2, 10 };
		
		// 스티커를 뜯어내어 얻을 수 있는 최댓값
		System.out.println(solution(sticker));
	}

	static public int solution(int sticker[]) {
		int answer = sticker[0];
		int n = sticker.length;

		if (n > 1) {
			// 0번 or 1번에서 스티커를 뜯기 시작 했을 때
			int dp[][] = new int[n][2];
			dp[1][0] = dp[0][0] = sticker[0];
			dp[1][1] = sticker[1];
			
			for (int i = 2; i < n-1; i++) {
				dp[i][0] = Math.max(dp[i-1][0], dp[i-2][0] + sticker[i]);
				dp[i][1] = Math.max(dp[i-1][1], dp[i-2][1] + sticker[i]);
			}
			if (n > 2) {
				dp[n-1][1] = Math.max(dp[n-2][1], dp[n-3][1] + sticker[n-1]);
			}
			
			answer = Math.max(dp[n-2][0], dp[n-1][1]);
		}
		
		return answer;
	}

}
