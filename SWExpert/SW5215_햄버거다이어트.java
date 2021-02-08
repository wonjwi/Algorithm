package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

/** 5215. 햄버거 다이어트
 * 정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거를 조합하라
 */
public class SW5215_햄버거다이어트 {
	private static int maxScore = 0; // 최고 점수
	private static int N = 0; // 재료의 수
	private static int L = 0; // 제한 칼로리
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken()); 
			// 재료에 대한 정보 입력
			int[] scoreArr = new int[N];
			int[] kcalArr = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				scoreArr[i] = Integer.parseInt(st.nextToken());
				kcalArr[i] = Integer.parseInt(st.nextToken());
			}
			// 제한 칼로리 이내에서 최고의 햄버거 조합 구하기
			maxScore = 0; // 최고 점수 초기화
			makeBurger(scoreArr, kcalArr, 0, 0, 0);
			result.append("#").append(tc).append(" ").append(maxScore).append("\n");
		}
		System.out.println(result);
	}
	private static void makeBurger(int[] scoreArr, int[] kcalArr, int scoreSum, int kcalSum, int count) {
		// 제한 칼로리를 넘으면 종료
		if (kcalSum > L) return;
		// 햄버거가 완성되면 최고 점수인지 확인
		if (count == N) {
			if (scoreSum > maxScore) maxScore = scoreSum;
			return;
		} else {
			makeBurger(scoreArr, kcalArr, scoreSum+scoreArr[count], kcalSum+kcalArr[count], count+1);
			makeBurger(scoreArr, kcalArr, scoreSum, kcalSum, count+1);
		}
	}
	
}
//public class SW5215_햄버거다이어트 {
//	private static int maxScore = 0; // 최고 점수
//	private static int N = 0; // 재료의 수
//	private static int L = 0; // 제한 칼로리
//	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder result = new StringBuilder();
//		int T = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= T; tc++) {
//			StringTokenizer st = new StringTokenizer(in.readLine());
//			N = Integer.parseInt(st.nextToken());
//			L = Integer.parseInt(st.nextToken()); 
//			// 재료에 대한 정보 입력
//			int[] scoreArr = new int[N];
//			int[] kcalArr = new int[N];
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(in.readLine());
//				scoreArr[i] = Integer.parseInt(st.nextToken());
//				kcalArr[i] = Integer.parseInt(st.nextToken());
//			}
//			// 제한 칼로리 이내에서 최고의 햄버거 조합 구하기
//			maxScore = 0; // 최고 점수 초기화
//			makeBurger(scoreArr, kcalArr, new boolean[N], 0);
//			result.append("#").append(tc).append(" ").append(maxScore).append("\n");
//		}
//		System.out.println(result);
//	}
//	private static void makeBurger(int[] scoreArr, int[] kcalArr, boolean[] result, int count) {
//		// 햄버거가 완성되면 조건을 확인
//		if (count == N) {
//			int score = 0, kcal = 0;
//			for (int i = 0; i < N; i++) {
//				// 선택된 재료마다 합 더하기
//				if (result[i]) {
//					score += scoreArr[i];
//					kcal += kcalArr[i];
//					// 제한 칼로리를 넘으면 종료
//					if (kcal > L) {
//						score = 0;
//						break;
//					}
//				}
//			}
//			// 최고 점수인지 확인
//			if (score > maxScore) maxScore = score;
//		} else {
//			result[count] = true;
//			makeBurger(scoreArr, kcalArr, result, count+1);
//			result[count] = false;
//			makeBurger(scoreArr, kcalArr, result, count+1);
//		}
//	}
//	
//}