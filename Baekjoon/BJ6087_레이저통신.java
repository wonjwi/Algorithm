package week08;

import java.io.*;
import java.util.*;

public class BJ6087_레이저통신 {
	
	static class Laser implements Comparable<Laser> {
		int r, c, dir, mirror;
		public Laser(int r, int c, int dir, int mirror) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.mirror = mirror;
		}
		@Override
		public int compareTo(Laser o) {
			return this.mirror-o.mirror;
		}
	}
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int W, H, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// 지도 입력 (. 빈 칸, * 벽, C 연결해야 하는 칸)
		char[][] map = new char[H][W];
		int[][] laser = new int[2][2]; // 레이저 발사 위치
		int idx = 0;
		for (int i = 0; i < H; i++) {
			map[i] = in.readLine().toCharArray();
			if (idx == 2) continue;
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'C') {
					laser[idx][0] = i;
					laser[idx++][1] = j;
				}
			}
		}
		// 레이저와 레이저 연결
		BFS(map, laser);
	}

	private static void BFS(char[][] map, int[][] laser) {
		int startR = laser[0][0], startC = laser[0][1];
		int endR = laser[1][0], endC = laser[1][1];
		PriorityQueue<Laser> q = new PriorityQueue<Laser>();
		// 4방향으로 다 보내본다.
		for (int i = 0; i < 4; i++) {
			q.add(new Laser(startR, startC, i, 0));
		}
		int[][] visited = new int[H][W];
		for (int i = 0; i < H; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		visited[startR][startC] = 0;
		
		while (!q.isEmpty()) {
			Laser tmp = q.poll();
			// 다른 레이저에 도착하면 종료
			if (tmp.r == endR && tmp.c == endC) {
				// 필요한 거울의 개수 출력
				System.out.println(tmp.mirror);
				break;
			}
			// 레이저는 거울(/, \)을 이용해 90도 회전 가능
			for (int i = 0; i < 4; i++) {
				int r = tmp.r+dr[i];
				int c = tmp.c+dc[i];
				if (r<0 || r>=H || c<0 || c>=W || map[r][c] == '*') continue;
				int mirror = tmp.mirror;
				// 방향이 다르면 거울 사용해서 회전
				if (tmp.dir != i) mirror++;
				if (visited[r][c] >= mirror) {
					visited[r][c] = mirror;
					q.add(new Laser(r, c, i, mirror));
				}
			}
		}
	}

}
