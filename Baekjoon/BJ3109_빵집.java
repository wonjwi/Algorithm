package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 3109. 빵집
 * 모든 파이프라인은 첫째 열에서 시작해야 하고, 마지막 열에서 끝나야 한다.
 * 각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결할 수 있다.
 * 건물이 있는 경우에는 파이프를 놓을 수 없고, 각 칸을 지나는 파이프는 하나여야 한다.
 * 설치할 수 있는 가스관과 빵집을 연결하는 파이프라인의 최대 개수를 구하라.
 */
public class BJ3109_빵집 {
	
	static int R, C, cnt = 0;
	static boolean[][] unavailable;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		unavailable = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == 'x') // 건물 위치 체크
					unavailable[i][j] = true;
			}
		}
		for (int i = 0; i < R; i++) {
			setPipe(i, 0); // 0열에서 시작
		}
		System.out.println(cnt);
	}

	private static boolean setPipe(int row, int col) {
		// 파이프라인이 완성되면 카운팅 후 돌아가기
		if (col == C-1) {
			cnt++;
			return true;
		}
		
		// 다음 위치에서 계속 탐색
		if (row-1 >= 0 && !unavailable[row-1][col+1]) {
			unavailable[row-1][col+1] = true;
			if (setPipe(row-1, col+1)) return true;
		} 
		if (!unavailable[row][col+1]) {
			unavailable[row][col+1] = true;
			if (setPipe(row, col+1)) return true;
		} 
		if (row+1 < R && !unavailable[row+1][col+1]) {
			unavailable[row+1][col+1] = true;
			if (setPipe(row+1, col+1)) return true;
		}
		
		return false;
	}
	
}
