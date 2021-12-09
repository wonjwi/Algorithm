package algorithm;

import java.io.*;
import java.util.*;

public class BJ2579_계단오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int score[] = new int[N + 1];

		// 각 계단의 점수 입력
		for (int i = 1; i <= N; i++) {
			score[i] = Integer.parseInt(in.readLine());
		}

		// 계단이 하나이거나 둘인 경우
		if (N <= 2) {
			System.out.println(N == 1 ? score[1] : score[1] + score[2]);
			return;
		}

		// 얻을 수 있는 총 점수의 최댓값 구하기
		int dp[][] = new int[N + 1][2];

		// 한 계단 올라왔을 때와 두 계단 올라왔을 때로 나누어 계산
		dp[1][0] = score[1];
		dp[2][0] = score[1] + score[2];
		dp[2][1] = score[2];

		for (int i = 3; i <= N; i++) {
			dp[i][0] = Math.max(dp[i - 3][0], dp[i - 3][1]) + score[i - 1] + score[i];
			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + score[i];
		}

		System.out.println(Math.max(dp[N][0], dp[N][1]));
	}

}