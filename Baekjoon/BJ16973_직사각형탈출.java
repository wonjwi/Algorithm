package week09;

import java.io.*;
import java.util.*;

public class BJ16973_직사각형탈출 {
	
	static class Quad {
		int r, c, cnt;
		public Quad(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int N, M, H, W;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		// 격자판의 크기 N, M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 격자판의 정보 입력 (0은 빈 칸, 1은 벽)
		char[][] map = new char[N+1][M+1];
		boolean[][] visited = new boolean[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		st = new StringTokenizer(in.readLine(), " ");
		// 직사각형의 크기 H, W
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		// 시작 좌표와 도착 좌표
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int fr = Integer.parseInt(st.nextToken());
		int fc = Integer.parseInt(st.nextToken());
		
		// 벽이 있으면 근처에 표시 해두기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == '1') {
					int mr = Math.max(0, i-H);
					int mc = Math.max(0, j-W);
					for (int r = i; r > mr; r--)
						for (int c = j; c > mc; c--)
							visited[r][c] = true;
				}
			}
		}
		// 직사각형을 시작 좌표에서 도착 좌표로 보내기
		BFS(map, visited, sr, sc, fr, fc);
	}

	private static void BFS(char[][] map, boolean[][] visited, int sr, int sc, int fr, int fc) {
		// 시작 위치에서 출발
		visited[sr][sc] = true;
		boolean fail = true;
		Queue<Quad> queue = new LinkedList<Quad>();
		queue.add(new Quad(sr, sc, 0));
		
		// Queue가 빌 때까지 이동
		while (!queue.isEmpty()) {
			Quad q = queue.poll();
			// 도착 좌표에 도착하면 이동 횟수 출력
			if (q.r == fr && q.c == fc) {
				System.out.println(q.cnt);
				fail = false;
				break;
			}
			// 도착하지 않았으면 계속 이동
			for (int i = 0; i < 4; i++) {
				int r = q.r+dr[i];
				int c = q.c+dc[i];
				// 인덱스를 초과하거나 방문한 곳은 가지 않음
				if (r < 1 || r+H-1 > N || c < 1 || c+W-1 > M || visited[r][c]) continue;
				visited[r][c] = true;
				queue.add(new Quad(r, c, q.cnt+1));
			}
		}
		// 도착 좌표에 도착하지 못하면 -1 출력
		if (fail) System.out.println(-1);
	}

}
