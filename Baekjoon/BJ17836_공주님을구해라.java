package week06;

import java.io.*;
import java.util.*;

public class BJ17836_공주님을구해라 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Hero {
		int r, c, time;
		int gram;
		public Hero(int r, int c, int time, int gram) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.gram = gram;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		// 성의 구조 (0은 빈 칸, 1은 벽, 2는 검)
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		// T시간 이내에 공주를 구하면 최단 시간 출력, 아니면 Fail 출력
		boolean[][][] visited = new boolean[N][M][2];
		Queue<Hero> queue = new LinkedList<Hero>();
		queue.add(new Hero(0, 0, 0, 0));
		while (!queue.isEmpty()) {
			Hero curr = queue.poll();
			int r = curr.r;
			int c = curr.c;
			int time = curr.time;
			int gram = curr.gram;
			
			// 공주님 구출 성공
			if (r == N-1 && c == M-1) {
				System.out.println(curr.time);
				return;
			}
			// 제한 시간 초과
			if (time > T) break;
			
			// 숨겨진 그람을 찾았다!
			if (map[r][c] == '2') gram = 1;
			
			// 용사는 상하좌우로 이동 가능
			for (int i = 0; i < 4; i++) {
				int row = r + dr[i];
				int col = c + dc[i];
				if (row < 0 || col < 0 || row >= N || col >= M || visited[row][col][gram]) continue;
				// 검이 없으면 벽을 만났을 때 건너뛰기
				if (gram == 0 && map[row][col] == '1') continue;
				// 방문한 곳 체크
				visited[row][col][gram] = true;
				queue.add(new Hero(row, col, time+1, gram));
			}
		}
		System.out.println("Fail");
	}

}
