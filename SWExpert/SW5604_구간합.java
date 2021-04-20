package ssafy.homework;

import java.io.*;
import java.util.StringTokenizer;

public class SW5604_구간합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			// [A, B]의 구간 합은 그 구간에 포함되는 모든 정수의 각 자리를 합한 값
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			long sum = 0;
			long mul = 1;
			while (true) {
				// 처음과 끝은 따로 계산
				while (A%10 != 0 && A <= B) {
					sum += getSum(A)*mul;
					A++;
				}
				while (B%10 != 9 && A <= B) {
					sum += getSum(B)*mul;
					B--;
				}
				if (A > B || (A == 0 && B == 0)) break;
				
				// 중간은 수식으로 계산
				A /= 10; B /= 10;
				sum += 45*(B-A+1)*mul; // 1+2+...+9 = 45
				mul *= 10;
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int getSum(long n) {
		int sum = 0;
		while (n != 0) {
			sum += n%10;
			n /= 10;
		}
		return sum;
	}

}
