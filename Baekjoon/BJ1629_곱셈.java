package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());

		System.out.println(pow(A, B, C));
	}

	private static long pow(long A, long exp, long C) {
		// 지수가 1일 경우
		if (exp == 1) {
			return A % C;
		}

		// 지수의 절반에 해당하는 값
		long tmp = pow(A, exp / 2, C);

		// 지수가 홀수일 때
		if (exp % 2 == 1) {
			return (tmp * tmp % C) * A % C;
		}
		// 지수가 짝수일 때
		else {
			return tmp * tmp % C;
		}
	}

}