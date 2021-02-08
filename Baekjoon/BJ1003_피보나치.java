package algopractice;

import java.io.*;

// 1003. 피보나치 함수
// 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력
public class BJ1003_피보나치 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			// 0과 1이 출력되는 횟수 구하기
			int[] fibo = new int[N+1];
			int oneCnt = fibonacci(N, fibo);
			int zeroCnt = N > 0 ? fibonacci(N-1, fibo) : 1;
			sb.append(zeroCnt).append(" ").append(oneCnt).append("\n");
		}
		System.out.println(sb);
	}
	private static int fibonacci(int n, int[] fibo) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		else if (fibo[n] != 0) {			
			return fibo[n];
		}
		return fibo[n] = fibonacci(n-1, fibo) + fibonacci(n-2, fibo);
	}
	
}