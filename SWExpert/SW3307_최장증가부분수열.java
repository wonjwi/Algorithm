package com.ssafy.workshop;

import java.io.*;
import java.util.StringTokenizer;

public class SW3307_최장증가부분수열 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine()); // 수열의 길이
			
			int[] num = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) { // 수열 입력
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			// 최장 증가 부분 수열 구하기
			int[] LIS = new int[N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1; // 이어지는 수열 없을 때
				for (int j = 0; j < i; j++) {
					if (num[j] <= num[i] && LIS[i] < LIS[j]+1) {
						LIS[i] = LIS[j]+1; // 앞에다 붙여서 더 값이 크면 교체
					}
				}
				max = Math.max(max, LIS[i]);
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
