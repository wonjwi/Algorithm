package week20;

import java.io.*;
import java.util.StringTokenizer;

public class BJ11062_카드게임 {

	static int num[], dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(in.readLine());

			num = new int[N];
			dp = new int[N][N];

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			game(0, N - 1, true);

			sb.append(dp[0][N - 1]).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static int game(int left, int right, boolean turn) {
		// 더 가져갈 카드가 없을 때
		if (left > right)
			return 0;

		// 이미 구한 값이 있을 때
		if (dp[left][right] > 0)
			return dp[left][right];

		// 근우 차례: 점수를 최대로 가져가야 함
		if (turn) {
			return dp[left][right] = Math.max(num[left] + game(left + 1, right, !turn),
					num[right] + game(left, right - 1, !turn));
		}
		// 명우 차례: 근우의 점수를 최소화해야 함
		else {
			return dp[left][right] = Math.min(game(left + 1, right, !turn), game(left, right - 1, !turn));
		}
	}

}
