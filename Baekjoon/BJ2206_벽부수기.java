package week03;

import java.io.*;
import java.util.*;

public class BJ2206_벽부수기 {
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static class Wall {
		int r, c, distance;
		boolean broken;
		public Wall(int r, int c, int distance, boolean broken) {
			this.r = r;
			this.c = c;
			this.distance = distance;
			this.broken = broken;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 0은 이동할 수 있는 곳, 1은 이동할 수 없는 벽
		char[][] map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		// (1, 1)에서 (N, M)까지 이동하는 최단 거리 탐색
		Queue<Wall> route = new LinkedList<Wall>();
		route.add(new Wall(0, 0, 1, false));
		boolean[][][] visit = new boolean[N][M][2];
		visit[0][0][0] = true;
		while (!route.isEmpty()) {
			Wall tmp = route.poll();
			int r = tmp.r;
			int c = tmp.c;
			int distance = tmp.distance;
			boolean flag = tmp.broken;
			// 목적지에 도착했으면 이동한 거리 출력
			if (r == N-1 && c == M-1) {
				System.out.println(distance);
				return;
			}
			// 목적지 도착할 때까지 인접한 칸으로 계속 이동
			for (int i = 0; i < 4; i++) {
				int row = r + dr[i];
				int col = c + dc[i];
				// 범위를 초과하거나 이미 방문한 곳은 지나침
				if (row < 0 || col < 0 || row >= N || col >= M || visit[row][col][flag?1:0]) continue;
				// 이동할 수 있는 곳이면 이동
				if (map[row][col] == '0') {
					route.add(new Wall(row, col, distance+1, flag));
					visit[row][col][flag?1:0] = true;
				}
				// 벽을 아직 부술 수 있으면 부수고 이동
				if (map[row][col] == '1' && !flag) {
					route.add(new Wall(row, col, distance+1, true));
					visit[row][col][1] = true;
				}
			}
		}
		// 이동이 불가능할 때는 -1을 출력
		System.out.println(-1);
	}
}