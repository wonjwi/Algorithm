package com.ssafy.algo;

import java.io.*;
import java.util.*;

// 1210. [S/W 문제해결 기본] 2일차 - Ladder1
// 100 X 100 크기의 2차원 배열로 주어지는 사다리
// 지정된 도착점에 대응되는 출발점 X를 반환
// 사다리는 연속된 1, 도착 지점은 2, 나머지는 0
// 한 막대에서 출발한 가로선이 다른 막대에 연속하여 이어지지 않는다.
class SW1210_Ladder1 {
	private static int N = 100; // 사다리 크기
	private static int result = 0;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int C = Integer.parseInt(in.readLine());
			int[][] ladder = new int[N][N];
			List<Integer> idx = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				ladder[0][j] = Integer.parseInt(st.nextToken());
				// 사다리 인덱스 정보 저장
				if (ladder[0][j] == 1) idx.add(j);
			}
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 지정된 도착점과 대응하는 출발점 찾기
			ride(ladder, idx, 0);
			System.out.printf("#%d %d\n", C, result);
		}
	}
	private static void ride(int[][] ladder, List<Integer> idx, int i) {
		int row = 0;
		int col = idx.get(i);
		int k = i;
		while (row != N-1) {
			row++;
			if (col-1 >= 0 && ladder[row][col-1] == 1) {
				col = idx.get(--k);
			}
			else if (col+1 < N && ladder[row][col+1] == 1) {
				col = idx.get(++k);
			}
		}
		// 지정된 도착점이면 종료
		if (ladder[row][col] == 2) {
			result = idx.get(i);
			return;
		}
		ride(ladder, idx, i+1);
	}
}

//==========================================================================

//package com.ssafy.algo;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//// 1210. [S/W 문제해결 기본] 2일차 - Ladder1
//// 100 X 100 크기의 2차원 배열로 주어지는 사다리
//// 지정된 도착점에 대응되는 출발점 X를 반환
//// 사다리는 연속된 1, 도착 지점은 2, 나머지는 0
//// 한 막대에서 출발한 가로선이 다른 막대에 연속하여 이어지지 않는다.
////-------------------------------------------------
////각 사다리의 도착점이 지정된 도착점인지 확인
////for (int j=0; j<N; j++) {
////	if (사다리라면) {
////		사다리타기(ladder, 행, 열, 방향);
////		if (지정된 도착점) {
////			결과 출력;
////			break;
////		}
////	}
////}
////사다리타기(int[][] ladder, int 행, int 열, int 방향) {
////	정해진 방향 이동;
////	if (사다리 끝) {
////		return;
////	}
////	if (주변 탐색) {
////		방향 변경;
////	}
////	ladder(ladder, 이동할행, 이동할열, 방향);
////}
//class SW1210_Ladder1 {
//	// 4방 탐색 배열 (좌, 우, 아래)
//	private static int[] moveX = { 0, 0, 1 };
//	private static int[] moveY = { -1, 1, 0 };
//	// 사다리 크기
//	private static int N = 100;
//	// 사다리 탐색
//	private static boolean isArrive = false;
//	private static void ladderGo(int[][] ladder, boolean[][] visit, int x, int y, int direction) {
//		// 해당 방향으로 이동
//		x += moveX[direction];
//		y += moveY[direction];
//		visit[x][y] = true;
//		// 사다리 끝이면 종료
//		if (x == N-1) {
//			// 지정된 도착점이면 알려준다.
//			if (ladder[x][y] == 2) isArrive = true;
//			return;
//		}
//		// 다음 이동방향을 구하기 위해 주변 탐색
//		for (int i = 0; i < 3; i++) {
//			int row = x + moveX[i];
//			int col = y + moveY[i];
//			// 배열을 초과하지 않고 방문하지 않은 길로 방향을 바꾼다.
//			if (row >= 0 && row < N && col >= 0 && col < N && visit[row][col] == false && ladder[row][col] != 0) {
//				direction = i;
//				break;
//			}
//		}
//		ladderGo(ladder, visit, x, y, direction);
//	}
//	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = 10;
//		for (int tc = 1; tc <= T; tc++) {
//			int C = Integer.parseInt(in.readLine());
//			isArrive = false;
//			// 사다리 정보 입력
//			int[][] ladder = new int[N][N];
//			for (int i = 0; i < N; i++) {
//				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
//				for (int j = 0; j < N; j++) {
//					ladder[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			// 지정된 도착점과 대응하는 출발점 찾기
//			for (int j = 0; j < N; j++) {
//				if (ladder[0][j] == 1) {
//					boolean[][] visit = new boolean[N][N];
//					ladderGo(ladder, visit, 0, j, 2);
//					// 지정된 도착점이면 출발점 좌표 출력
//					if (isArrive) {
//						System.out.printf("#%d %d\n", C, j);
//						break;
//					}
//				}
//			}
//		}
//	}
//}

//==========================================================================

//package com.ssafy.algo;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//// 1210. [S/W 문제해결 기본] 2일차 - Ladder1
//// 100 X 100 크기의 2차원 배열로 주어지는 사다리
//// 지정된 도착점에 대응되는 출발점 X를 반환
//// 사다리는 연속된 1, 도착 지점은 2, 나머지는 0
//// 한 막대에서 출발한 가로선이 다른 막대에 연속하여 이어지지 않는다.
////-------------------------------------------------
////사다리 정보 입력
////for (int i=0; i<N; i++) {
////	for (int j=0; j<N; j++) {
////		ladder[i][j] = 사다리 정보;
////	}
////}
////도착점 위치 찾기
////for (int i=0; i<N; i++) {
////	if (ladder[N-1][i] == 2) {
////		도착점 저장;
////	}
////}
////도착점에서 출발 했을 때 도착하는 X 찾기
////while(true) {
////	위로 이동;
////	왼쪽, 오른쪽 검사;
////		사다리가 있다면?
////			사다리 방향으로 이동;
////			위쪽 검사;
////				사다리가 있다면?
////					위로 이동;
////					...
////}
//class SW1210_Ladder1 {
//	
//	// 사다리 크기
//	private static int N = 100; 
//	
//	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = 10;
//		int C = 0;
//		for (int tc = 1; tc <= T; tc++) {
//			C = Integer.parseInt(in.readLine());
//			// 사다리 정보 입력
//			int[][] ladder = new int[N][N];
//			boolean[][] visit = new boolean[N][N];
//			for (int i = 0; i < N; i++) {
//				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
//				for (int j = 0; j < N; j++) {
//					ladder[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			// 지정된 도착점 위치 찾기
//			int goal = -1;
//			for (int j = 0; j < N; j++) {
//				if (ladder[N-1][j] == 2) {
//					goal = j;
//					break;
//				}
//			}
//			// 지정된 도착점과 대응하는 출발점 찾기			
//			int dir = 1; // 상하좌우 : 1234
//			int i = N-1, j = goal;
//			// 좌우아래 검사
//			// 1이 있으면 이동
//			// 위 2단계를 재귀로!
//			while (true) {
//				// 꼭대기에 도착하면 멈춤
//				if (i == 0) break;
//				// 위로 이동할 때는 좌우 검사
//				if (dir == 1) {
//					if (i-1 >= 0) i--;
//					if (j-1 >= 0 && ladder[i][j-1] == 1) {
//						dir = 3;
//					}
//					if (j+1 < N && ladder[i][j+1] == 1) {
//						dir = 4;
//					}
//				// 좌우로 이동할 때는 위만 검사
//				} else if (dir == 3) {
//					if (j-1 >= 0) j--;
//					if (i-1 >= 0 && ladder[i-1][j] == 1) {
//						dir = 1;
//					}
//				} else if (dir == 4) {
//					if (j+1 < N) j++;
//					if (i-1 >= 0 && ladder[i-1][j] == 1) {
//						dir = 1;
//					}
//				}
//			}
//			// 지정된 도착점과 대응하는 출발점 X좌표 출력
//			System.out.printf("#%d %d\n", C, j);
//		}
//	}
//}