package week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ7576_토마토 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		// 토마토의 현재 상태
		int[][] map = new int[N][M];
		Queue<int[]> tomato = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					tomato.add(new int[] {i, j, 0});
				}
			}
		}
		// 토마토가 모두 익을 때까지의 최소 날짜 구하기
		int day = 0;
		while (!tomato.isEmpty()) {
			int[] tmp = tomato.poll();
			int r = tmp[0];
			int c = tmp[1];
			day = tmp[2];
			// 안 익은 토마토 익히기
			if (r > 0 && map[r-1][c] == 0) { // 상
				map[r-1][c] = 1;
				tomato.add(new int[] {r-1, c, day+1});
			}
			if (r < N-1 && map[r+1][c] == 0) { // 하
				map[r+1][c] = 1;
				tomato.add(new int[] {r+1, c, day+1});
			}
			if (c > 0 && map[r][c-1] == 0) { // 좌
				map[r][c-1] = 1;
				tomato.add(new int[] {r, c-1, day+1});
			}
			if (c < M-1 && map[r][c+1] == 0) { // 우
				map[r][c+1] = 1;
				tomato.add(new int[] {r, c+1, day+1});
			}
		}
		// 안 익은 토마토가 남아있는지 검사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1); return;
				}
			}
		}
		System.out.println(day);
	}
}
