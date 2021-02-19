package com.ssafy.algo;

import java.io.*;
import java.util.*;

/** 4012. 요리사
 * N개의 식재료들을 각각 N/2개씩 나누어 두 개의 요리를 하려고 한다.
 * A음식과 B음식의 맛의 차이가 최소가 되도록 재료를 배분해야 한다.
 * 음식의 맛은 음식을 구성하는 식재료들로부터 발생하는 시너지 Sij들의 합이다.
 */
public class SW4012_요리사 {
	private static int min, N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine()); // 식재료의 수
			int[][] synergy = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			cook(synergy, new int[N/2], N/2, 0, 0);
			System.out.println("#"+tc+" "+min);
		}
	}
	private static void cook(int[][] synergy, int[] foodA, int K, int start, int cnt) {
		if (cnt == K) {
			// 나머지 식재료 N/2개로 음식B 만듦
			boolean[] selectA = new boolean[N];
			for (int i = 0; i < K; i++) {
				selectA[foodA[i]] = true;
			}
			int[] foodB = new int[K];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (!selectA[i]) foodB[idx++] = i;
			}
			// 각 음식의 맛을 계산
			int taste = 0;
			for (int i = 0; i < K; i++) {
				for (int j = 0; j < K; j++) {
					taste += synergy[foodA[i]][foodA[j]];
					taste -= synergy[foodB[i]][foodB[j]];
				}
			}
			// A음식과 B음식의 맛의 차이의 최솟값 저장
			min = Math.min(min, Math.abs(taste));
			return;
		}
		// 식재료 중 N/2개 선택해 음식A 만듦
		for (int i = start; i < N; i++) {
			foodA[cnt] = i;
			cook(synergy, foodA, K, i+1, cnt+1);
		}
	}
}
