package week07;

import java.io.*;
import java.util.*;

public class SW10966_물놀이 {
	
	static class Place {
		int r, c, cnt;
		public Place(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 지도 입력 (W는 물, L은 땅)
			char[][] map = new char[N][M];
			Queue<Place> water = new LinkedList<Place>();
			for (int i = 0; i < N; i++) {
				map[i] = in.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					// 물의 위치를 저장
					if (map[i][j] == 'W') {
						water.add(new Place(i, j, 0));
					}
				}
			}
			
			// 땅에서 물으로 이동하기 위한 최소 이동 횟수 구하기
			sb.append("#").append(tc).append(" ").append(move(map, water)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static int move(char[][] map, Queue<Place> place) {
		int sum = 0;
		while (!place.isEmpty()) {
			Place p = place.poll();
			int r = p.r;
			int c = p.c;
			int cnt = p.cnt+1;
			map[r][c] = 'X';
			// 상하좌우로 이동하면서 탐색
			for (int i = 0; i < 4; i++) {
				int row = r + dr[i];
				int col = c + dc[i];
				if (row < 0 || row >= N || col < 0 || col >= M || map[row][col] != 'L') continue;
				sum += cnt;
				map[row][col] = 'X';
				place.add(new Place(row, col, cnt));
			}
		}
		return sum;
	}
	
}
