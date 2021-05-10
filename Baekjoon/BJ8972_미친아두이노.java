package week14;

import java.io.*;
import java.util.*;

public class BJ8972_미친아두이노 {
	
	static class Arduino {
		int r, c;
		public Arduino(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int R, C;
	static int dr[] = {0,1,1,1,0,0,0,-1,-1,-1};
	static int dc[] = {0,-1,0,1,-1,0,1,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 보드의 상태 (.는 빈 칸, R은 아두이노, I는 종수)
		char map[][] = new char[R][C];
		Queue<Arduino> crazy = new LinkedList<Arduino>();
		Arduino js = null;
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'I') { // 종수의 위치
					js = new Arduino(i, j);
				} else if (map[i][j] == 'R') { // 아두이노
					crazy.add(new Arduino(i, j));
				}
			}
		}
		String direction = in.readLine();
		int len = direction.length(), dir;
		for (int i = 0; i < len; i++) {
			// 움직이려고 하는 방향
			dir = direction.charAt(i)-'0';
			if (!move(map, js, crazy, dir)) {
				System.out.println("kraj "+(i+1));
				return;
			}
		}
		// 보드의 상태 출력
		System.out.println(printMap(map));
	}

	private static String printMap(char[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private static boolean move(char[][] map, Arduino js, Queue<Arduino> crazy, int dir) {
		// 종수의 아두이노가 이동
		map[js.r][js.c] = '.';
		int row = js.r+dr[dir];
		int col = js.c+dc[dir];
		
		// 미친 아두이노를 만나면 게임 끝
		if (map[row][col] == 'R') {
			return false;
		} else {
			map[row][col] = 'I';
			js.r = row;
			js.c = col;
		}
		// 미친 아두이노가 종수와 가장 가까워지는 방향으로 이동
		int min, minDir = 0, distance, r, c;
		for (Arduino tmp : crazy) {
			r = tmp.r;
			c = tmp.c;
			map[r][c] = '.';
		}
		while (!crazy.isEmpty()) {
			Arduino tmp = crazy.poll();
			r = tmp.r;
			c = tmp.c;
			min = Integer.MAX_VALUE;
			for (int d = 1; d <= 9; d++) {
				if (d == 5) continue;
				row = r+dr[d];
				col = c+dc[d];
				if (row<0 || row>=R || col<0 || col>=C) continue;
				distance = Math.abs(js.r-row) + Math.abs(js.c-col);
				if (min > distance) {
					min = distance;
					minDir = d;
				}
			}
			row = r+dr[minDir];
			col = c+dc[minDir];
			// 미친 아두이노가 종수를 만나면 게임 끝
			if (map[row][col] == 'I') {
				return false;
			// 미친 아두이노가 같은 칸에 이미 있으면
			} else if (map[row][col] == 'R') {
				map[row][col] = 'r';
			} else if (map[row][col] != 'r') {
				map[row][col] = 'R';
			}
		}
		// 2개 이상이 같은 칸에 있으면 모두 파괴
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'r') map[i][j] = '.';
				else if (map[i][j] == 'R') crazy.add(new Arduino(i, j));
			}
		}
		return true;
	}

}
