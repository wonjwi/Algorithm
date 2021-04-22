package ssafy.homework;

import java.io.*;
import java.util.*;

public class SW1868_파핑파핑지뢰찾기 {
	
	static Queue<int[]> zero = new LinkedList<int[]>();
	static int N, map[][], minBombCnt;
	static boolean bomb[][], visited[][];
	static int dr[] = {-1,-1,-1,0,0,1,1,1}; // 8방 탐색
	static int dc[] = {-1,0,1,-1,1,-1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			bomb = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				for (int j = 0; j < N; j++) {
					// 지뢰가 있는 곳을 체크
					if (str.charAt(j) == '*') bomb[i][j] = true;
				}
			}
			// 지뢰가 아닌 모든 칸에 대해 주변 탐색
			map = new int[N][N]; minBombCnt = 8;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!bomb[i][j]) checkAdj(i, j);
				}
			}
			// 모든 칸이 확인되는 최소 클릭수 구하기
			visited = new boolean[N][N];
			sb.append("#").append(tc).append(" ").append(getMinCount()).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void checkAdj(int r, int c) {
		int bombCnt = 0;
		for (int d = 0; d < 8; d++) {
			int row = r+dr[d];
			int col = c+dc[d];
			if (row < 0 || row >= N || col < 0 || col >= N) continue;
			if (bomb[row][col]) bombCnt++;
		}
		map[r][c] = bombCnt;
		if (bombCnt == 0) zero.add(new int[] {r, c});
	}

	private static int getMinCount() {
		int answer = 0;
		
		// 클릭 안 한 0이 남아 있을 때
		while (!zero.isEmpty()) {
			int[] tmp = zero.poll();
			int r = tmp[0];
			int c = tmp[1];
			if (visited[r][c]) continue;
			visited[r][c] = true;
			answer++;
			click(r, c);
		}
		// 방문 안 한 나머지 숫자 클릭
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!bomb[i][j] && !visited[i][j]) {
					answer++;
				}
			}
		}
		return answer;
	}

	private static void click(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {i, j}); // 행, 열
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int d = 0; d < 8; d++) {
				int row = r+dr[d];
				int col = c+dc[d];
				if (row < 0 || row >= N || col < 0 || col >= N || visited[row][col]) continue;
				visited[row][col] = true;
				// 주변에 0이 있으면 이어서 탐색
				if (map[row][col] == 0) queue.add(new int[] {row, col});
			}
		}
	}

}
