package com.ssafy.algo;

import java.io.*;
import java.util.*;

//17406. 배열 돌리기 4
//크기가 N×M인 배열 A와 회전 연산이 주어졌을 때, 배열 A의 값의 최솟값을 구해보자. 
//배열 A의 값은 각 행에 있는 모든 수의 합 중 최솟값을 의미한다. 
//회전 연산은 모두 한 번씩 사용해야 하며, 순서는 임의로 정해도 된다.
public class BJ17406_배열돌리기4 {
	static int[] moveX = { 1, 0, -1, 0 }; // 반시계 방향
	static int[] moveY = { 0, 1, 0, -1 }; // 아래, 오른, 위, 왼
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 회전 연산의 수
		// 입력 배열 저장
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 회전 연산의 정보 저장
		int[] rotationR = new int[K];
		int[] rotationC = new int[K];
		int[] rotationS = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			rotationR[i] = Integer.parseInt(st.nextToken());
			rotationC[i] = Integer.parseInt(st.nextToken());
			rotationS[i] = Integer.parseInt(st.nextToken());
		}
		// 회전 연산 순서의 경우의 수(순열) 찾기
		List<int[]> orderList = new ArrayList<int[]>();
		makePermutation(orderList, new int[K], new boolean[K], K, 0);
		// 더 이상 경우의 수가 없으면 종료
		int minValue = Integer.MAX_VALUE;
		for (int k=0; k<orderList.size(); k++) {
			int[][] copy = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = arr[i][j];
				}
			}
			// 찾은 순서대로 회전 연산 실행
			for (int r = 0; r < K; r++) {
				int n = orderList.get(k)[r];
				rotate(copy, rotationR[n]-1, rotationC[n]-1, rotationS[n]);
			}
			// 배열의 값의 최솟값 구하기
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0; // 각 행마다 합 구하기
				for (int j = 0; j < M; j++) {
					sum += copy[i][j];
				}
				min = Math.min(min, sum);
			}
			minValue = Math.min(minValue, min);
		}
		System.out.println(minValue);
	}
	private static void rotate(int[][] arr, int aRow, int aCol, int aSize) {
		// 안쪽으로 들어가면서 이동이 끝날 때까지
		for (int n = 0; n < aSize; n++) {
			int x = aRow-aSize+n;
			int y = aCol-aSize+n;
			int temp = arr[x][y]; // 출발점 저장
			int direction = 0;
			while (true) {
				// 이동할 위치를 구한다.
				int row = x + moveX[direction];
				int col = y + moveY[direction];
				// 이동할 곳이 범위를 초과하면 방향을 바꾼다.
				if (row < aRow-aSize+n || row > aRow+aSize-n || col < aCol-aSize+n || col > aCol+aSize-n) {
					direction++;
					// 이동할 곳의 위치를 다시 구한다.
					row = x + moveX[direction];
					col = y + moveY[direction];
				} 
				// 출발점은 미리 저장한 값을 사용한다.
				if (row == aRow-aSize+n && col == aCol-aSize+n) {
					arr[x][y] = temp;
					break; // 한 바퀴 돌았으므로 종료
				}
				arr[x][y] = arr[row][col];
				x = row;
				y = col;
			}
		} // End - for
	}
	private static void makePermutation(List<int[]> orderList, int[] order, boolean[] visit, int K, int cnt) {
		// 순서가 완성되면 리스트에 저장
		if (cnt == K) {
			int[] temp = new int[K];
			for (int i = 0; i < K; i++) {
				temp[i] = order[i];
			}
			orderList.add(temp);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (visit[i]) continue;
			order[cnt] = i;
			visit[i] = true;
			makePermutation(orderList, order, visit, K, cnt+1);
			visit[i] = false;
		}
	}
}