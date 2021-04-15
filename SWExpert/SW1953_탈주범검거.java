package ssafy.workshop;

import java.io.*;
import java.util.*;

public class SW1953_탈주범검거 {
	
	static int N, M, R, C, L;
	static int[] dr = {-1, 0, 0, 1}; // 상좌우하
	static int[] dc = {0, -1, 1, 0}; // 상좌우하
	static int[][] type = {
			{}, 
			{0, 1, 2, 3}, // 1:상좌우하
			{0, 3}, // 2:상하
			{1, 2}, // 3:좌우
			{0, 2}, // 4:상우
			{2, 3}, // 5:우하
			{1, 3}, // 6:좌하
			{0, 1}  // 7:상좌
	};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 세로 크기
			M = Integer.parseInt(st.nextToken()); // 가로 크기
			R = Integer.parseInt(st.nextToken()); // 맨홀 세로 위치
			C = Integer.parseInt(st.nextToken()); // 맨홀 가로 위치
			L = Integer.parseInt(st.nextToken()); // 탈출 소요 시간
			
			// 지하 터널 지도 정보
			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = st.nextToken().charAt(0) - '0';
				}
			}
			boolean[][] visited = new boolean[N][M];
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.add(new int[] {R, C}); // 맨홀 위치
			visited[R][C] = true;
			int count = 1; // 탈주범이 위치할 수 있는 장소의 수
			for (int t = 1; t < L; t++) {
				int size = queue.size(); // 동시간대 처리
				for (int i = 0; i < size; i++) {
					int[] tmp = queue.poll();
					int r = tmp[0];
					int c = tmp[1];
					// 현 구조물의 타입으로 이동가능한 방향 정보
					int[] direction = type[map[r][c]];
					for (int d : direction) {
						int row = r+dr[d];
						int col = c+dc[d];
						if (row<0 || row>=N || col<0 || col>=M || visited[row][col]) continue;
						// 터널이 이어지지 않으면 갈 수 없음
						int next = map[row][col];
						if (next == 0) continue;
						if (Arrays.binarySearch(type[next], 3-d) < 0) continue;
						visited[row][col] = true;
						count++;
						queue.add(new int[] {row, col});
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb.toString());
	}

}

//public class SW1953_탈주범검거 {
//
//static class Point {
//	int r, c;
//	public Point(int r, int c) {
//		this.r = r;
//		this.c = c;
//	}
//}
//
//static int N, M, R, C, L;
//static int[] dr = {-1, 1, 0, 0};
//static int[] dc = {0, 0, -1, 1};
//static int[][] type = {
//		{}, 
//		{0, 1, 2, 3}, // 상하좌우
//		{0, 1}, // 상하
//		{2, 3}, // 좌우
//		{0, 3}, // 상우
//		{1, 3}, // 하우
//		{1, 2}, // 하좌
//		{0, 2}  // 상좌
//};
//
//public static void main(String[] args) throws NumberFormatException, IOException {
//	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	StringBuilder sb = new StringBuilder();
//	
//	int T = Integer.parseInt(in.readLine());
//	for (int tc = 1; tc <= T; tc++) {
//		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
//		N = Integer.parseInt(st.nextToken()); // 세로 크기
//		M = Integer.parseInt(st.nextToken()); // 가로 크기
//		R = Integer.parseInt(st.nextToken()); // 맨홀 세로 위치
//		C = Integer.parseInt(st.nextToken()); // 맨홀 가로 위치
//		L = Integer.parseInt(st.nextToken()); // 탈출 소요 시간
//		
//		// 지하 터널 지도 정보
//		int[][] map = new int[N][M];
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(in.readLine(), " ");
//			for (int j = 0; j < M; j++) {
//				map[i][j] = st.nextToken().charAt(0) - '0';
//			}
//		}
//		boolean[][] visited = new boolean[N][M];
//		Queue<Point> queue = new LinkedList<Point>();
//		queue.add(new Point(R, C)); // 맨홀 위치
//		visited[R][C] = true;
//		int count = 1; // 탈주범이 위치할 수 있는 장소의 수
//		for (int t = 1; t < L; t++) {
//			int size = queue.size(); // 동시간대 처리
//			for (int i = 0; i < size; i++) {
//				Point tmp = queue.poll();
//				int r = tmp.r;
//				int c = tmp.c;
//				int[] direction = type[map[r][c]];
//				for (int d : direction) {
//					int row = r+dr[d];
//					int col = c+dc[d];
//					if (row<0 || row>=N || col<0 || col>=M || visited[row][col]) continue;
//					// 터널이 이어지지 않으면 갈 수 없음
//					int next = map[row][col];
//					if (next == 0) continue;
//					if (d == 0 && (next == 3 || next == 4 || next == 7)) continue;
//					if (d == 1 && (next == 3 || next == 5 || next == 6)) continue;
//					if (d == 2 && (next == 2 || next == 6 || next == 7)) continue;
//					if (d == 3 && (next == 2 || next == 4 || next == 5)) continue;
//					visited[row][col] = true;
//					count++;
//					queue.add(new Point(row, col));
//				}
//			}
//		}
//		sb.append("#").append(tc).append(" ").append(count).append("\n");
//	}
//	System.out.println(sb.toString());
//}
//
//}
