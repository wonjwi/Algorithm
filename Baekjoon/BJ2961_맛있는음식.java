package com.ssafy.algo;

import java.io.*;
import java.util.*;

//2961. 도영이가 만든 맛있는 음식
//여러 재료를 이용해서 요리할 때, 그 음식의 신맛은 사용한 재료의 신맛의 곱, 쓴맛은 합이다.
//재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만들어라.
public class BJ2961_맛있는음식 {
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 재료의 개수
		int[][] taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			taste[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}
		cook(taste, 1, 0, N, 0);
		System.out.println(min);
	}
	private static void cook(int[][] taste, int S, int B, int N, int cnt) {
		if (cnt == N) {
			if (S != 1 && B != 0) // 재료를 하나 이상 사용
				min = Math.min(Math.abs(S-B), min);
			return;
		}
		cook(taste, S*taste[cnt][0], B+taste[cnt][1], N, cnt+1);
		cook(taste, S, B, N, cnt+1);
	}
//	private static void cook(int[][] taste, int flag, int N, int cnt) {
//		if (cnt == N) {
//			int S = 1, B = 0;
//			for (int i = 0; i < N; i++) {
//				if ((flag & 1<<i) != 0) {
//					S *= taste[i][0];
//					B += taste[i][1];
//				}
//			}
//			if (S != 1 && B != 0) // 재료를 하나 이상 사용
//				min = Math.min(Math.abs(S-B), min);
//			return;
//		}
//		cook(taste, flag | 1<<cnt, N, cnt+1);
//		cook(taste, flag | 0<<cnt, N, cnt+1);
//	}
//	private static void cook(int[][] taste, boolean[] checked, int N, int cnt) {
//		if (cnt == N) {
//			int S = 1, B = 0;
//			for (int i = 0; i < N; i++) {
//				if (checked[i]) {
//					S *= taste[i][0];
//					B += taste[i][1];
//				}
//			}
//			if (S != 1 && B != 0) // 재료를 하나 이상 사용
//				min = Math.min(Math.abs(S-B), min);
//			return;
//		}
//		checked[cnt] = true;
//		cook(taste, checked, N, cnt+1);
//		checked[cnt] = false;
//		cook(taste, checked, N, cnt+1);
//	}
}