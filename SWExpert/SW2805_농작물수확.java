package com.ssafy.algo;

import java.io.*;

/** 2805. 농작물 수확하기
 * ① 농장은 크기는 항상 홀수이다. (1 X 1, 3 X 3 … 49 X 49)
 * ② 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능하다.
 * 농장의 크기 N와 농작물의 가치가 주어질 때, 규칙에 따라 얻을 수 있는 수익은?
 */
class SW2805_농작물수확 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 농장의 크기
			int N = Integer.parseInt(in.readLine());
			// 농장에서 얻을 수 있는 수익 구하기
//			i <= n/2 이면 n/2-i 번째 칸부터 i*2+1 개의 칸 더하기
//			i  > n/2 이면 i-n/2 번째 칸부터 (n-i)*2-1 개의 칸 더하기
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int start = 0;
				int cnt = 0;
				if (i <= N/2) {
					start = N/2 - i;
					cnt = i*2 + 1;
				} else {
					start = i - N/2;
					cnt = (N-i)*2 - 1;
				}
				String str = in.readLine();
				for (int j = start; j < start+cnt; j++) {
					sum += Integer.parseInt(str.substring(j, j+1));
				}
			}
			// 결과 출력
			System.out.println("#" + tc + " " + sum);
		}
	}
}

//==========================================================================

//package com.ssafy.algo;
//
//import java.io.*;
//
///** 2805. 농작물 수확하기
// * ① 농장은 크기는 항상 홀수이다. (1 X 1, 3 X 3 … 49 X 49)
// * ② 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능하다.
// * 농장의 크기 N와 농작물의 가치가 주어질 때, 규칙에 따라 얻을 수 있는 수익은?
// */
//class SW2805_농작물수확 {
//	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= T; tc++) {
//			// 농장의 크기
//			int N = Integer.parseInt(in.readLine());
//			int[][] farm = new int[N][N];
//			// 농작물의 가치 입력
//			for (int i = 0; i < N; i++) {
//				String str = in.readLine();
//				for (int j = 0; j < N; j++) {
//					farm[i][j] = Integer.parseInt(str.substring(j, j+1));
//				}
//			}
//			// 농장에서 얻을 수 있는 수익 구하기
////			i <= n/2 이면 n/2-i 번째 칸부터 i*2+1 개의 칸 더하기
////			i  > n/2 이면 i-n/2 번째 칸부터 (n-i)*2-1 개의 칸 더하기
//			int sum = 0;
//			for (int i = 0; i < N; i++) {
//				int start = 0;
//				int cnt = 0;
//				if (i <= N/2) {
//					start = N/2 - i;
//					cnt = i*2 + 1;
//				} else {
//					start = i - N/2;
//					cnt = (N-i)*2 - 1;
//				}
//				for (int j = start; j < start+cnt; j++) {
//					sum += farm[i][j];
//				}
//			}
//			// 결과 출력
//			System.out.println("#" + tc + " " + sum);
//		}
//	}
//}