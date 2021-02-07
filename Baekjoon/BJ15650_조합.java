package com.ssafy.nm;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 15650. N과 M (2) - 중복되지 않은 조합
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하시오.
 * 조건 : 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 		: 고른 수열은 오름차순이어야 한다.
 */
public class BJ15650_조합 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		combination(new int[M], N, M, 0, 1);
	}

	private static void combination(int[] numbers, int N, int M, int cnt, int start) {
		// 수열을 완성하면 출력
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			combination(numbers, N, M, cnt+1, i+1);
		}
	}
}