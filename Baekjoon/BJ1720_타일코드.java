package week21;

import java.io.*;

public class BJ1720_타일코드 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int dp[] = new int[31];
		
		// 초기 값 셋팅
		dp[0] = 1;
		dp[1] = 1;
		
		if (N == 1) {
			System.out.println(1);
		} 
		else {
			// 좌우 대칭을 제외하지 않은 전체 개수 구하기
			for (int i = 2; i <= N; i++) {
				// i-1에 2*1 타일 붙인 것 + i-2에 1*2 또는 2*2 타일 붙인 것
				dp[i] = dp[i-1] + dp[i-2] * 2;
			}
			// 좌우 대칭 제외 -> 좌우가 같은 경우를 더해서 2로 나누기
			// 홀수는 가운데 1*2를 두고 좌우가 같은 경우만 있음
			if (N % 2 == 1) {
				System.out.println((dp[N] + dp[N/2]) / 2);
			} 
			// 짝수는 가운데 2*1 또는 2*2 타일을 둔 경우도 좌우가 같음 
			else {
				System.out.println((dp[N] + dp[N/2] + dp[N/2 - 1] * 2) / 2);
			}
		}
		
	}

}
