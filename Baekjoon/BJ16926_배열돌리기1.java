package com.ssafy.algo;

import java.io.*;
import java.util.*;

//16926. 배열 돌리기 1
//크기가 N×M인 배열을 반시계 방향으로 R번 회전시킨 결과를 구하라.
public class BJ16926_배열돌리기1 {
	static int[] moveX = { 0, 1, 0, -1 }; // 시계 방향
	static int[] moveY = { 1, 0, -1, 0 }; // 오, 아래, 왼, 위
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		// 입력 배열 저장
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 반시계 방향 R번 회전
		int min = Math.min(N, M) / 2;
		for (int i = 0; i < R; i++) {
			rotate(arr, min, N-1, M-1);
		}
		// 결과 배열 출력
		StringBuilder resultArr = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				resultArr.append(arr[i][j]).append(" ");
			}
			resultArr.append("\n");
		}
		System.out.println(resultArr);
	}
	private static void rotate(int[][] arr, int num, int endRow, int endCol) {
		// 안쪽으로 들어가면서 이동이 끝날 때까지
		for (int n = 0; n < num; n++) {
			int temp = arr[n][n]; // 출발점 저장
			
			int direction = 0;
			int x = n;
			int y = n;
			while (true) {
				// 이동할 위치를 구한다.
				int row = x + moveX[direction];
				int col = y + moveY[direction];
				// 이동할 곳이 범위를 초과하면 방향을 바꾼다.
				if (row < n || row > endRow || col < n || col > endCol) {
					direction++;
					// 이동할 곳의 위치를 다시 구한다.
					row = x + moveX[direction];
					col = y + moveY[direction];
				} 
				// 출발점은 미리 저장한 값을 사용한다.
				if (row == n && col == n) {
					arr[x][y] = temp;
					endRow--;
					endCol--;
					break; // 한 바퀴 돌았으므로 종료
				}
				// 시계방향 한 칸 옆을 현재 위치에 넣기
				arr[x][y] = arr[row][col];
				x = row;
				y = col;
			}
		} // End - for
	}
}

//-------------------------------------------------------------------------------
//public class BJ16926_배열돌리기1 {
//	static int[] moveX = { 1, 0, -1, 0 }; // 반시계 방향
//	static int[] moveY = { 0, 1, 0, -1 }; // 아래, 오, 위, 왼
//	static int N, M;
//	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(in.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		int R = Integer.parseInt(st.nextToken());
//		// 입력 배열 저장
//		int[][] arr = new int[N][M];
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(in.readLine());
//			for (int j = 0; j < M; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		// 반시계 방향 R번 회전
//		int[][] result = new int[N][M];
//		for (int r = 0; r < R; r++) {
//			rotate(arr, result, 0, 0, 0, 0, N-1, M-1);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					arr[i][j] = result[i][j];
//				}
//			}
//		}
//		// 결과 배열 출력
//		StringBuilder resultArr = new StringBuilder();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				resultArr.append(result[i][j]).append(" ");
//			}
//			resultArr.append("\n");
//		}
//		System.out.println(resultArr);
//	}
//	private static void rotate(int[][] arr, int[][] result, int x, int y, int direction, int last, int endRow, int endCol) {
//		// 이동을 완료하면 종료한다.
//		if (last == Math.min(M, N)/2) return;
//		// 이동할 위치를 구한다.
//		int row = x + moveX[direction];
//		int col = y + moveY[direction];
//		// 이동할 곳이 범위를 초과하면 이동방향을 바꾼다.
//		if (row < last || row > endRow || col < last || col > endCol) {
//			direction = (direction + 1) % 4;
//			// 이동할 곳의 위치를 다시 구한다.
//			row = x + moveX[direction];
//			col = y + moveY[direction];
//		}
//		// 이동할 위치에 원래 값 입력
//		result[row][col] = arr[x][y];
//		// 한 바퀴를 다 돌면 안쪽으로 출발지 변경
//		if (row == last && col == last) {
//			rotate(arr, result, last+1, last+1, 0, last+1, endRow-1, endCol-1);
//		} // 아니라면 다음 위치를 이동시킨다.
//		else {
//			rotate(arr, result, row, col, direction, last, endRow, endCol);
//		}
//	}
//}
