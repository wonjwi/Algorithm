package ssafy.homework;

import java.io.*;
import java.util.StringTokenizer;

//* N combination R
//N! / R!*(N-R)!
//= N! * (R!*(N-R)!)^(-1)
//
//* 모듈러 산술
//(a mod n * b mod n) mod n = (a * b) mod n
//
//* 페르마의 소정리
//소수 p, a는 p의 배수가 아닐 때
//a^p = a (mod p)
//a^(p-1) = 1 (mod p)
//a^(p-2) = a^(-1) (mod p)
public class SW5607_조합 {
	
	static int P = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
//			N combination R의 값을 1234567891로 나눈 나머지
//			(N! * (R!*(N-R)!)^(-1)) mod 1234567891
//			= (N! mod 1234567891 * (R!*(N-R)!)^(-1) mod 1234567891) mod 1234567891
//			(R!*(N-R)!)^(-1) mod 1234567891
//			= (R!*(N-R)!)^(1234567891-2) mod 1234567891
			long top = 1;
			long bottom = 1;
			for (int i = 1; i <= R; i++) {
				top *= (N-i+1);
				top %= P;
				bottom *= i;
				bottom %= P;
			}
			bottom = fermat(bottom, P-2);
			
			sb.append("#").append(tc).append(" ").append((top*bottom) % P).append("\n");
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
