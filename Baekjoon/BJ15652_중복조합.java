package com.ssafy.nm;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 15652. N과 M (4) - 중복을 허용하는 조합
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하시오.
 * 조건 : 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 		: 같은 수를 여러 번 골라도 된다.
 * 		: 고른 수열은 비내림차순이어야 한다.
 */
public class BJ15652_중복조합 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		combination(sb, new int[M], N, M, 0, 1);
		System.out.println(sb.toString());
	}

	private static void combination(StringBuilder sb, int[] numbers, int N, int M, int cnt, int start) {
		// 수열을 완성하면 출력
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			combination(sb, numbers, N, M, cnt+1, i);
		}
	}
}