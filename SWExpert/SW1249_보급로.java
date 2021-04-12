package ssafy.homework;

import java.io.*;
import java.util.PriorityQueue;

public class SW1249_보급로 {
	
	static class Restore implements Comparable<Restore> {
		int r, c, time;
		public Restore(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
		@Override
		public int compareTo(Restore o) {
			return this.time - o.time;
		}
	}
	
	static int N, ans;
	static char[][] map = new char[100][100];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			// 지도 정보 입력
			N = Integer.parseInt(in.readLine()); // 지도 크기
			for (int i = 0; i < N; i++) { 
				map[i] = in.readLine().toCharArray();
			}
			// 출발지(0, 0) -> 도착지(N-1, N-1)
			BFS(0, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void BFS(int i, int j) {
		PriorityQueue<Restore> pq = new PriorityQueue<Restore>();
		pq.add(new Restore(i, j, 0));
		
		boolean[][] visited = new boolean[N][N];
		visited[i][j] = true;
		
		while (!pq.isEmpty()) {
			// 현재 가장 짧은 경로
			Restore tmp = pq.poll();
			int r = tmp.r;
			int c = tmp.c;
			int time = tmp.time;
			
			// 도착지에 도착 하면 종료
			if (r == N-1 && c == N-1) {
				ans = time;
				break;
			}
			// 도착하지 않았으면 계속 탐색
			for (int d = 0; d < 4; d++) {
				int row = r+dr[d];
				int col = c+dc[d];
				if (row < 0 || row >= N || col < 0 || col >= N || visited[row][col]) continue;
				visited[row][col] = true;
				pq.add(new Restore(row, col, time+map[row][col]-'0'));
			}
		}
	}

}
