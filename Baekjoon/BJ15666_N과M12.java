package com.ssafy.nm;

import java.io.*;
import java.util.*;

/**
 * 15666. N과 M (12)
 * N개의 자연수와 자연수 M이 주어졌을 때, 길이가 M인 수열을 모두 구하시오.
 * 조건 : N개의 자연수 중에서 M개를 고른 비내림차 수열 (같은 수 여러 번 사용 가능)
 * 		: 수열은 사전 순으로 증가하는 순서로 중복되지 않게 출력해야 한다.
 */
public class BJ15666_N과M12 {
	private static StringBuilder result = new StringBuilder();
	private static int N;
	private static int M;	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		combination(input, new int[M], 0, 0);
		System.out.println(result);
	}

	private static void combination(int[] input, int[] output, int count, int start) {
		// 수열을 완성하면 출력
		if (count == M) {
			for (int i = 0; i < M; i++) {
				result.append(output[i]).append(" ");
			}
			result.append("\n");
			return;
		}
		int used = -1;
		for (int i = start; i < N; i++) {
			// 중복된 숫자는 지나친다.
			if (used == input[i]) continue;
			output[count] = input[i];
			used = input[i];
			combination(input, output, count+1, i);
		}
	}
}