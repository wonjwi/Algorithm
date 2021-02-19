package com.ssafy.algo;

import java.io.*;
import java.util.*;

/** 3234. 준환이의 양팔저울
 * N개의 서로 다른 무게를 가진 무게 추와 양팔저울이 있다.
 * 오른쪽의 무게 총합이 왼쪽의 무게 총합보다 더 커지지 않아야 한다.
 * 이런 방법으로 모든 무게추를 올리는 방법의 총 가짓수를 구하라.
 */
public class SW3234_양팔저울 {
	private static int possibleCnt;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine()); // 무게추의 수
			int[] weight = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			possibleCnt = 0;
			balance(weight, new int[N], new boolean[N], N, 0);
			sb.append("#").append(tc).append(" ").append(possibleCnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void balance(int[] weight, int[] selectWeight, boolean[] selected, int N, int cnt) {
		// 무게추를 놓는 순열 완성
		if (cnt == N) {
			test(weight, selectWeight, 0, 0, N, 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (selected[i]) continue;
			selectWeight[cnt] = weight[i];
			selected[i] = true;
			balance(weight, selectWeight, selected, N, cnt+1);
			selected[i] = false;
		}
	}
	private static void test(int[] weight, int[] selectWeight, int left, int right, int N, int cnt) {
		// 조건을 만족하는 경우의 수 찾기
		if (cnt == N) {
			possibleCnt++; 
			return;
		}
		test(weight, selectWeight, left+selectWeight[cnt], right, N, cnt+1);
		if (left >= right+selectWeight[cnt]) {
			test(weight, selectWeight, left, right+selectWeight[cnt], N, cnt+1);
		}
	}
}
