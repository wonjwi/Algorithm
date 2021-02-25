package com.ssafy.workshop;

import java.io.*;
import java.util.*;

public class SW1767_프로세서연결 {
	static int maxPower, minLength;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 멕시노스의 초기 상태 입력
			int N = Integer.parseInt(in.readLine());
			char[][] cell = new char[N][N];
			int[][] core = new int[12][2];
			int power = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					// 0은 빈 cell, 1은 core
					cell[i][j] = st.nextToken().charAt(0);
					// 가장자리에 위치한 core는 전원 연결할 필요 X
					if (i==0 || j==0 || i==N-1 || j==N-1) continue;
					// 나머지 core의 위치 저장
					if (cell[i][j] == '1') {
						core[power][0] = i;
						core[power++][1] = j;
					}
				}
			}
			maxPower = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;
			// 최대한 많은 core에 전원 연결
			connect(cell, core, N, 0, power, 0, 0);
			// 전선 길이 합의 최솟값 출력
			sb.append("#").append(tc).append(" ").append(minLength).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void connect(char[][] cell, int[][] core, int N, int len, int P, int power, int cnt) {
		// 부분 집합이 완성되면 결과값 갱신
		if (cnt == P) {
			if (power > maxPower) {
				maxPower = power;
				minLength = len;
			} else if (power == maxPower) {
				minLength = Math.min(minLength, len);
			}
			return;
		}
		// 코어에 네 방향으로 전선 놓기
		int r = core[cnt][0];
		int c = core[cnt][1];
		for (int d = 0; d < 4; d++) {
			// 전선을 놓을 수 있는 곳이라면
			if (isAvailale(cell, N, r, c, d)) {
				// 전선 놓기
				setChar(cell, N, r, c, d, '2');
				// 놓아진 전선 수 구하기
				int add = 0;
				switch (d) {
				case 0:	add = r; break;
				case 1:	add = N-1-r; break;
				case 2:	add = c; break;
				case 3:	add = N-1-c; break;
				}
				// 다음 코어 진행
				connect(cell, core, N, len+add, P, power+1, cnt+1);
				// 놓은 전선 회수
				setChar(cell, N, r, c, d, '0');
			}
		}
		// 코어에 전선 놓지 않기
		connect(cell, core, N, len, P, power, cnt+1);
	}

	private static boolean isAvailale(char[][] cell, int N, int r, int c, int d) {
		int row = r, col = c;
		while (true) {
			row += dr[d];
			col += dc[d];
			// 직진해서 경계에 도착: 전원연결 가능
			if (row<0 || col<0 || row>=N || col>=N) return true;
			// 빈칸이 아닌 곳이 있음: 전원연결 불가능
			if (cell[row][col] != '0') return false;
		}
	}

	private static void setChar(char[][] cell, int N, int r, int c, int d, char s) {
		int row = r, col = c;
		while (true) {
			row += dr[d];
			col += dc[d];
			if (row<0 || col<0 || row>=N || col>=N) break;
			cell[row][col] = s;
		}
	}
}
