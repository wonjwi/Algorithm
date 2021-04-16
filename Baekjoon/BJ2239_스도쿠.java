package ssafy.workshop;

import java.io.*;

public class BJ2239_스도쿠 {
	
	static boolean[][] garo, sero, nemo;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[9][9];
		garo = new boolean[9][10];
		sero = new boolean[9][10];
		nemo = new boolean[9][10];
		for (int i = 0; i < 9; i++) {
			String str = in.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j)-'0';
				// 숫자가 있으면 가로, 세로, 네모 체크
				if (map[i][j] > 0) {
					garo[i][map[i][j]] = true;
					sero[j][map[i][j]] = true;
					nemo[3*(i/3)+j/3][map[i][j]] = true;
				}
			}
		}
		// 스도쿠 퍼즐 완성하기
		puzzle(map, 0, 0);
	}

	private static void puzzle(int[][] map, int r, int c) {
		// 퍼즐을 완성하면 출력
		if (r == 9) {
			printMap(map);
			System.exit(0);
		}
		
		// 줄의 끝에 왔으면 다음 줄로 이동
		if (c == 9) {
			puzzle(map, r+1, 0);
			return;
		}
		
		// 이미 숫자가 있으면 다음 칸 채우기
		if (map[r][c] > 0) {
			puzzle(map, r, c+1);
			return;
		}
		
		for (int i = 1; i <= 9; i++) { // 숫자 1-9 시도
			// 불가능한 숫자는 넘어감
			if (garo[r][i] || sero[c][i] || nemo[3*(r/3)+c/3][i]) continue;
			garo[r][i] = true;
			sero[c][i] = true;
			nemo[3*(r/3)+c/3][i] = true;
			map[r][c] = i;
			puzzle(map, r, c+1);
			garo[r][i] = false;
			sero[c][i] = false;
			nemo[3*(r/3)+c/3][i] = false;
			map[r][c] = 0;
		}
	}

	private static void printMap(int[][] map) {
		// 완성한 스도쿠 퍼즐 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
