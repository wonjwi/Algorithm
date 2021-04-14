package ssafy.workshop;

import java.io.*;
import java.util.*;

public class BJ17144_미세먼지안녕 {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R, C, T;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		int[][][] map = new int[R][C][2];
		int air = -1; // 공기청정기 행 위치
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				if (map[i][j][0] == -1) air = i;
				map[i][j][1] = map[i][j][0]/5;
			}
		}
		// T초가 지난 후 상태 구하기
		for (int i = 0; i < T; i++) {
			// 미세먼지 확산
			spread(map);
			// 공기청정기 작동
			clean(map, air);
			// 미세먼지 정리
			setting(map);
		}
		System.out.println(sumOfDust(map));
	}

	private static int sumOfDust(int[][][] map) {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j][0] > 0) sum += map[i][j][0];
			}
		}
		return sum;
	}

	private static void setting(int[][][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j][1] = map[i][j][0]/5;
			}
		}
	}

	private static void clean(int[][][] map, int air) {
		// 공기청정기 위쪽 바람 순환
		for (int i = air-2; i > 0; i--) {
			map[i][0][0] = map[i-1][0][0];
		}
		for (int j = 0; j < C-1; j++) {
			map[0][j][0] = map[0][j+1][0];
		}
		for (int i = 0; i < air-1; i++) {
			map[i][C-1][0] = map[i+1][C-1][0];
		}
		for (int j = C-1; j > 1; j--) {
			map[air-1][j][0] = map[air-1][j-1][0];
		}
		map[air-1][1][0] = 0;
		// 공기청정기 아래쪽 바람 순환
		for (int i = air+1; i < R-1; i++) {
			map[i][0][0] = map[i+1][0][0];
		}
		for (int j = 0; j < C-1; j++) {
			map[R-1][j][0] = map[R-1][j+1][0];
		}
		for (int i = R-1; i > air; i--) {
			map[i][C-1][0] = map[i-1][C-1][0];
		}
		for (int j = C-1; j > 1; j--) {
			map[air][j][0] = map[air][j-1][0];
		}
		map[air][1][0] = 0;
	}

	private static void spread(int[][][] map) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c][1] > 0) {
					int next = map[r][c][1];
					// 미세먼지가 인접한 네 방향으로 확산
					for (int d = 0; d < 4; d++) {
						int row = r+dr[d];
						int col = c+dc[d];
						if (row < 0 || row >= R || col < 0 || col >= C || map[row][col][0] == -1) continue;
						map[r][c][0] -= next;
						map[row][col][0] += next;
					}
				}
			}
		}
	}

}
