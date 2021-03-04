package week05;

import java.io.*;
import java.util.*;

public class BJ16236_아기상어 {
	static int[] dr = {-1, 0, 0, 1}; // 상좌우하
	static int[] dc = {0, -1, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		// 0: 빈 칸, 1 ~ 6: 물고기 크기, 9: 아기 상어
		int[][] map = new int[N][N];
		// 행, 열, 크기, 먹은 물고기수, 시간
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					queue.add(new int[] {i, j, 2, 0, 0});
					map[i][j] = 0;
				}
			}
		}
		// 혼자서 물고기를 잡아먹을 수 있는 시간
		int result = 0;
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			int size = tmp[2];
			int eat = tmp[3];
			int time = tmp[4];
			// 자신보다 작은 물고기는 먹는다.
			if (map[r][c] != 0 && map[r][c] < size) {
				while (!queue.isEmpty()) {
					int[] tmp2 = queue.poll();
					int r2 = tmp2[0];
					int c2 = tmp2[1];
					int time2 = tmp2[4];
					if (time2 > time) break;
					// 가장 위, 가장 왼쪽의 물고기를 먹는다.
					if (r2 < r && map[r2][c2] != 0 && map[r2][c2] < size) {
						r = r2;
						c = c2;
					} 
					else if (r2 == r && c2 < c && map[r2][c2] != 0 && map[r2][c2] < size) {
						r = r2;
						c = c2;
					}
				}
//				for (int k = 0; k < N; k++) {
//					for (int j = 0; j < N; j++) {
//						if (k == r && j == c) {
//							System.out.print("* ");
//						}
//						else System.out.print(map[k][j]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println("eat:["+r+","+c+"],time:"+time+",size:"+size);
//				System.out.println("=============");
				map[r][c] = 0;
				eat++;
				result = time;
				queue.clear();
				visit = new boolean[N][N];
				visit[r][c] = true;
			}
			// 자신의 크기만큼 물고기를 먹으면 크기 1 증가
			if (eat == size) {
				size++;
				eat = 0;
			}
			for (int i = 0; i < 4; i++) {
				int row = r + dr[i];
				int col = c + dc[i];
				// 범위를 초과하거나 이미 방문한 칸은 지나침
				if (row < 0 || col < 0 || row >= N || col >= N || visit[row][col]) continue;
				// 자신보다 큰 물고기는 지나갈 수 없다.
				if (map[row][col] > size) continue;
				queue.add(new int[] {row, col, size, eat, time+1});
				visit[row][col] = true;
			}
		}
		System.out.println(result);
	}
}
