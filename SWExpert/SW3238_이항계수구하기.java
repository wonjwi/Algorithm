package ssafy.homework;

import java.io.*;
import java.util.StringTokenizer;

// * N combination R
//N! / R!*(N-R)! = N! * (R!*(N-R)!)^(-1)
//
// * 모듈러 산술
//(a mod n * b mod n) mod n = (a * b) mod n
//
// * 페르마의 소정리
//소수 p, a는 p의 배수가 아닐 때
//a^p = a (mod p)
//a^(p-1) = 1 (mod p)
//a^(p-2) = a^(-1) (mod p)
//
// * 뤼카의 정리
//음이 아닌 정수 m, n, 소수 p에 대해
//m combination n = 모든 mi combination ni의 곱 (0<=i<=k) (mod p)
//만약 mi<ni라면 mi combination ni가 0이므로 m combination n도 0
//이를 이용해 m과 n을 p진법으로 표현
public class SW3238_이항계수구하기 {
	
	static int P;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			
//			N combination R의 값을 소수 P로 나눈 나머지
//			(N! * (R!*(N-R)!)^(-1)) mod P
			long[] factorial = new long[P+1]; // P!
			factorial[0] = 1;
			for (int i = 1; i <= P; i++) {
				factorial[i] = (factorial[i-1]*i) % P;
			}
			long ans = 1;
			while (N != 0 || R != 0) {
				long a = N % P;
				long b = R % P;
				if (a < b) ans = 0;
				if (ans == 0) break;
				ans *= factorial[(int) a];
				ans %= P;
				ans *= fermat((factorial[(int) b]*factorial[(int) (a-b)]), P-2);
				ans %= P;
				N /= P; R /= P;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static long fermat(long a, int b) {
		if (b == 0) return 1;
		long tmp = fermat(a, b/2);
		long ret = (tmp*tmp) % P;
		if (b%2 == 0) return ret;
		else return (ret*a) % P;
	}

}
