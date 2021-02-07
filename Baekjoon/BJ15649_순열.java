package com.ssafy.nm;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 15649. N과 M (1) - 중복되지 않은 순열
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하시오.
 * 조건 : 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 */
public class BJ15649_순열 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		permutation(new int[M], new boolean[N+1], N, M, 0);
	}

	private static void permutation(int[] numbers, boolean[] selected, int N, int M, int cnt) {
		// 수열을 완성하면 출력
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (selected[i]) continue;
			numbers[cnt] = i;
			selected[i] = true;
			permutation(numbers, selected, N, M, cnt+1);
			selected[i] = false;
		}
	}
}