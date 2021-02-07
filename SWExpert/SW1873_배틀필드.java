package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

/** 1873. 상호의 배틀필드
 * 전차는 사용자의 전차 하나뿐, 적이나 아군으로 만들어진 전차는 등장하지 않는다.
 * 사용자의 전차는 입력에 따라 격자판으로 이루어진 게임 맵에서 다양한 동작을 한다.
 * 초기 게임 맵의 상태와 사용자가 넣을 입력이 순서대로 주어질 때, 
 * 모든 입력을 처리하고 나면 게임 맵의 상태가 어떻게 되는지 구하라.
 */
class SW1873_배틀필드 {
	// 4방 이동 - 상, 하, 좌, 우
	private static char[] sign = { '^', 'v', '<', '>' };
	private static int[] moveX = { -1, 1, 0, 0 };
	private static int[] moveY = { 0, 0, -1, 1 };
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 게임 맵 크기 입력 (H x W)
			StringTokenizer st = new StringTokenizer(in.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			// 게임 맵 데이터 입력
			// 사용자의 전차 위치와 방향 구하기
			int userX = -1;
			int userY = -1;
			int direction = -1;
			for (int i = 0; i < H; i++) {
				String str = in.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					for (int k = 0; k < 4; k++) {
						if (userX >= 0) break;
						if (map[i][j] == sign[k]) {
							userX = i;
							userY = j;
							direction = k;
							break;
						}
					}
				}
			}
			// 사용자가 넣은 입력 실행
			int N = Integer.parseInt(in.readLine());
			String inputStr = in.readLine();
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				char input = inputStr.charAt(i);
				switch (input) {
				// 방향을 바꾸고 평지라면 한 칸 이동
				case 'R':
					cnt++;
				case 'L':
					cnt++;
				case 'D':
					cnt++;
				case 'U':
					// 전차의 방향을 바꾼다.
					direction = cnt;
					map[userX][userY] = sign[direction];
					// 전차가 이동 가능하면 이동한다.
					int row = userX + moveX[direction];
					int col = userY + moveY[direction];
					if (row >= 0 && row < H && col >= 0 && col < W && map[row][col] == '.') {
						map[userX][userY] = '.';
						userX = row;
						userY = col;
						map[userX][userY] = sign[direction];
					}
					break;
				// 바라보고 있는 방향으로 포탄 발사
				case 'S':
					row = userX;
					col = userY;
					while (true) {
						row += moveX[direction];
						col += moveY[direction];
						// 배열을 초과하면 아무 일 없이 종료
						if (row < 0 || row >= H || col < 0 || col >= W) break;
						// 벽돌 또는 강철에 충돌하면 멈춤
						if (map[row][col] == '*') {
							map[row][col] = '.';
							break;
						} else if (map[row][col] == '#') {
							break;
						}
					}
				}
			}
			// 실행 후 게임 맵 출력
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}