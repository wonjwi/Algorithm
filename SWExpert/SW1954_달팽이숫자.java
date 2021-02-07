package homework;

import java.util.Scanner;
import java.io.FileInputStream;

// 1954. 달팽이 숫자
// 1부터 N*N까지의 숫자가 시계방향으로 이루어진 달팽이 출력
// 달팽이의 크기인 N은 1 이상 10 이하의 정수
//---------------------------------------------
// 재귀를 이용해 시계방향으로 돌면서 반복
class SW1954_달팽이숫자 {
	// 4방 탐색 배열 - 우, 하, 좌, 상 (시계방향)
	private static int[] moveX = { 0, 1, 0, -1 };
	private static int[] moveY = { 1, 0, -1, 0 };
	
	// 달팽이 크기
	private static int N;
	
	// 달팽이 숫자 입력
	private static void snailWrite(int[][] snail, boolean[][] visit, int num, int x, int y, int direction) {
		// 달팽이의 해당 위치에 숫자 입력
		snail[x][y] = num;
		visit[x][y] = true;
		// 입력을 끝냈으면 종료한다.
		if (num == N*N) return;
		// 이동할 곳의 위치를 구한다.
		int row = x + moveX[direction];
		int col = y + moveY[direction];
		// 이동할 곳이 배열을 초과하거나 이미 방문한 곳이면 이동방향을 바꾼다.
		if (row < 0 || row >= N || col < 0 || col >= N || visit[row][col] == true) {
			direction = (direction + 1) % 4;
			// 이동할 곳의 위치를 다시 구한다.
			row = x + moveX[direction];
			col = y + moveY[direction];
		}
		// 이동할 곳으로 간다.
		snailWrite(snail, visit, num+1, row, col, direction);
	}
	
	// 달팽이 숫자 출력
	private static void snailPrint(int[][] snail, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(snail[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc);
			N = sc.nextInt(); // 달팽이의 크기
			int[][] snail = new int[N][N]; // 달팽이
			boolean[][] visit = new boolean[N][N];
			snailWrite(snail, visit, 1, 0, 0, 0);
			snailPrint(snail, N);
		}
	}
}

//==========================================================================

//package homework;
//
//import java.util.Scanner;
//import java.io.FileInputStream;
//
//// 1954. 달팽이 숫자
//// 1부터 N*N까지의 숫자가 시계방향으로 이루어진 달팽이 출력
//// 달팽이의 크기인 N은 1 이상 10 이하의 정수
////---------------------------------------------
//// 테두리를 시계 방향으로 출력 -> 재귀로 반복
//class SW1954_달팽이숫자 {
//	private static int num = 1; // 달팽이 숫자
//	
//	// 달팽이 숫자 입력
//	private static void snailWrite(int[][] snail, int start, int end) {
//		// 더이상 입력할 곳이 없으면 종료
//		if (end < 0) return;
//		// 마지막 한 칸(가운데) 입력 후 종료
//		if (start == end) {
//			snail[start][end] = num++;
//			return;
//		}
//		// 한 바퀴 돌기
//		for (int j = start; j < end; j++) {
//			snail[start][j] = num++;
//		}
//		for (int i = start; i < end; i++) {
//			snail[i][end] = num++;
//		}
//		for (int j = end; j > start; j--) {
//			snail[end][j] = num++;
//		}
//		for (int i = end; i > start; i--) {
//			snail[i][start] = num++;
//		}
//		snailWrite(snail, start+1, end-1);
//	}
//	
//	// 달팽이 숫자 출력
//	private static void snailPrint(int[][] snail, int N) {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(snail[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
//	
//	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		for (int tc = 1; tc <= T; tc++) {
//			System.out.println("#" + tc);
//			num = 1;
//			int N = sc.nextInt(); // 달팽이의 크기
//			int snail[][] = new int[N][N]; // 달팽이
//			snailWrite(snail, 0, N-1);
//			snailPrint(snail, N);
//		}
//	}
//}