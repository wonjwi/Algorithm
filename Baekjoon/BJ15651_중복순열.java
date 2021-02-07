package com.ssafy.nm;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 15651. N과 M (3) - 중복을 허용하는 순열
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하시오.
 * 조건 : 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 		: 같은 수를 여러 번 골라도 된다.
 */
public class BJ15651_중복순열 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		permutation(sb, new int[M], N, M, 0);
		System.out.println(sb.toString());
	}

	private static void permutation(StringBuilder sb, int[] numbers, int N, int M, int cnt) {
		// 수열을 완성하면 출력
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			numbers[cnt] = i;
			permutation(sb, numbers, N, M, cnt+1);
		}
	}
}