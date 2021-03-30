package week09;

import java.io.*;

public class BJ10422_괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 괄호 문자열의 길이 미리 구하기
		long[] ans = new long[2501];
		ans[0] = 1;
		ans[1] = 1;
		ans[2] = 2;
		for (int n = 3; n <= 2500; n++) {
			for (int i = 0; i < n; i++) {
				ans[n] += ans[i]*ans[n-1-i];
				ans[n] %= 1000000007;
			}
		}
		// 테스트케이스 실행
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int L = Integer.parseInt(in.readLine());
			if (L%2 != 0) sb.append("0\n");
			else sb.append(ans[L/2]).append("\n");
		}
		System.out.println(sb.toString());
	}

}