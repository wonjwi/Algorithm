package com.ssafy.nm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 15654. N과 M (5) - 중복되지 않은 순열 (사용자 입력)
 * 모두 다른 N개의 자연수와 M이 주어졌을 때, 길이가 M인 수열을 모두 구하시오.
 * 조건 : N개의 자연수 중에서 M개를 고른 수열
 * 		: 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class BJ15654_입력값순열 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		// N개의 자연수를 입력 후 오름차순 정렬
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		StringBuilder sb = new StringBuilder();
		combination(sb, input, new int[M], new boolean[N], N, M, 0);
		System.out.println(sb.toString());
	}

	private static void combination(StringBuilder sb, int[] input, int[] output, boolean[] selected, int N, int M, int cnt) {
		// 수열을 완성하면 출력
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(output[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (selected[i]) continue;
			output[cnt] = input[i];
			selected[i] = true;
			combination(sb, input, output, selected, N, M, cnt+1);
			selected[i] = false;
		}
	}
}