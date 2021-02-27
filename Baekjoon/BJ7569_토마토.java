package week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ7569_토마토 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		// 토마토의 현재 상태
		int[][][] map = new int[N][M][H];
		Queue<int[]> tomato = new LinkedList<int[]>();
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) {
						tomato.add(new int[] {i, j, k, 0});
					}
				}
			}
		}
		// 토마토가 모두 익을 때까지의 최소 날짜 구하기
		int day = 0;
		while (!tomato.isEmpty()) {
			int[] tmp = tomato.poll();
			int r = tmp[0];
			int c = tmp[1];
			int h = tmp[2];
			day = tmp[3];
			// 안 익은 토마토 익히기
			if (h < H-1 && map[r][c][h+1] == 0) { // 위
				map[r][c][h+1] = 1;
				tomato.add(new int[] {r, c, h+1, day+1});
			}
			if (h > 0 && map[r][c][h-1] == 0) { // 아래
				map[r][c][h-1] = 1;
				tomato.add(new int[] {r, c, h-1, day+1});
			}
			if (c > 0 && map[r][c-1][h] == 0) { // 왼쪽
				map[r][c-1][h] = 1;
				tomato.add(new int[] {r, c-1, h, day+1});
			}
			if (c < M-1 && map[r][c+1][h] == 0) { // 오른쪽
				map[r][c+1][h] = 1;
				tomato.add(new int[] {r, c+1, h, day+1});
			}
			if (r < N-1 && map[r+1][c][h] == 0) { // 앞
				map[r+1][c][h] = 1;
				tomato.add(new int[] {r+1, c, h, day+1});
			}
			if (r > 0 && map[r-1][c][h] == 0) { // 뒤
				map[r-1][c][h] = 1;
				tomato.add(new int[] {r-1, c, h, day+1});
			}
		}
		// 안 익은 토마토가 남아있는지 검사
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][k] == 0) {
						System.out.println(-1); return;
					}
				}
			}
		}
		System.out.println(day);
	}
}
