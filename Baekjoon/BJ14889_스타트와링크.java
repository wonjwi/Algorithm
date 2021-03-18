package com.ssafy.homework;

import java.io.*;
import java.util.*;

public class BJ14889_스타트와링크 {
	private static int min, N;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
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
		System.out.println(min);
	}
	private static void cook(int[][] synergy, int[] foodA, int K, int start, int cnt) {
		if (cnt == K) {
			// 나머지로 만들기
			boolean[] selectA = new boolean[N];
			for (int i = 0; i < K; i++) {
				selectA[foodA[i]] = true;
			}
			int[] foodB = new int[K];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (!selectA[i]) foodB[idx++] = i;
			}
			// 각 값을 계산
			int taste = 0;
			for (int i = 0; i < K; i++) {
				for (int j = 0; j < K; j++) {
					taste += synergy[foodA[i]][foodA[j]];
					taste -= synergy[foodB[i]][foodB[j]];
				}
			}
			// 능력 차이의 최솟값 저장
			min = Math.min(min, Math.abs(taste));
			return;
		}
		// N/2개 선택해 만들기
		for (int i = start; i < N; i++) {
			foodA[cnt] = i;
			cook(synergy, foodA, K, i+1, cnt+1);
		}
	}
}
