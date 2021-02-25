package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2578_빙고 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 철수의 빙고판
		int[][] bingo = new int[5][5];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 사회자가 부른 수
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (check(bingo, num) >= 3) {
					System.out.println(5*i+j+1);
					return;
				}
			}
		}
	}
	private static int check(int[][] bingo, int num) {
		int bingoCnt = 0;
		Loop:
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == num) {
					bingo[i][j] = 0; // 숫자 체크
					break Loop;
				}
			}
		}
		int[] rowCnt = new int[5];
		int[] colCnt = new int[5];
		// 가로세로 체크
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == 0) {
					rowCnt[i]++;
					colCnt[j]++;
				}
			}
		}
		int[] diag = new int[2];
		for (int i = 0; i < 5; i++) {
			// 대각선 체크
			if (bingo[i][i] == 0) diag[0]++;
			if (bingo[i][4-i] == 0) diag[1]++;
			if (rowCnt[i] == 5) bingoCnt++;
			if (colCnt[i] == 5) bingoCnt++;
		}
		if (diag[0] == 5) bingoCnt++;
		if (diag[1] == 5) bingoCnt++;
		return bingoCnt;
	}
}
