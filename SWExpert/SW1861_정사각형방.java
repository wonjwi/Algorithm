package com.ssafy.algo;

import java.io.*;
import java.util.*;

/** 1861. 정사각형 방
 * N^2개의 방이 N×N형태로 늘어서 있다.
 * (i, j) 방에는 1이상 N^2 이하의 각기 다른 숫자 A_i,j가 적혀 있다.
 * 이동할 방이 있고, 그 방에 적힌 숫자가 현재 방의 숫자보다 1만큼 크다면
 * 어떤 방에서 상하좌우에 있는 다른 방으로 이동할 수 있다.
 * 처음 어떤 수가 적힌 방에서 있어야 가장 많은 개수의 방을 이동할 수 있는가?
 */
class SW1861_정사각형방 {
	// 4방 탐색 (상하좌우)
	private static int[] moveX = { -1, 1, 0, 0 };
	private static int[] moveY = { 0, 0, -1, 1 };
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			// 방에 입력 받은 숫자를 적는다.
			int[][] room = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 각 위치마다 이동할 수 있는 최댓값을 구한다.
			int maxNum = 0, maxCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 1;
					int num = room[i][j];
					int x = i, y = j;
					// 더이상 이동 못할 때까지 반복 수행
					int k = 0;
					while(true) {
						if(k > 3) break;
						int row = x + moveX[k];
						int col = y + moveY[k];
						if(row >= 0 && row < N && col >= 0 && col < N) {
							if(room[row][col] - num == 1) {
								num = room[row][col];
								x = row;
								y = col;
								cnt++;
								k = -1;
							}
						}
						k++;
					}
					// 최댓값 확인 후 저장
					if(maxCnt < cnt) {
						maxCnt = cnt;
						maxNum = room[i][j];
					} else if(maxCnt == cnt && num < maxNum) {
						maxNum = room[i][j];
					}
				}
			}
			System.out.printf("#%d %d %d\n", tc, maxNum, maxCnt);
		}
	}
}