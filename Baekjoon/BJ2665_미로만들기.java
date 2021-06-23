package week19;

import java.io.*;
import java.util.*;

public class BJ2665_미로만들기 {

	static int dr[] = { 1, 0, 0, -1 };
	static int dc[] = { 0, 1, -1, 0 };

	static class Room implements Comparable<Room> {
		int r, c, cnt;

		public Room(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Room o) {
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		boolean map[][] = new boolean[n][n];
		boolean visited[][] = new boolean[n][n];
		char arr[] = null;

		// 흰 방은 true, 검은 방은 false
		for (int i = 0; i < n; i++) {
			arr = in.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (arr[j] == '1')
					map[i][j] = true;
			}
		}

		// 흰 방으로 바꾸어야 할 최소의 수 찾기
		int answer = 0;

		// 시작방에서 출발
		PriorityQueue<Room> queue = new PriorityQueue<Room>();
		queue.add(new Room(0, 0, 0));
		visited[0][0] = true;

		Room tmp = null;
		int r, c, cnt;

		while (!queue.isEmpty()) {
			// 가장 위에 있는 값 꺼내기
			tmp = queue.poll();
			r = tmp.r;
			c = tmp.c;
			cnt = tmp.cnt;

			// 끝방에 도착하면 종료
			if (r == n - 1 && c == n - 1) {
				answer = cnt;
				break;
			}

			// 인접한 방으로 이동
			for (int i = 0; i < 4; i++) {
				int row = r + dr[i];
				int col = c + dc[i];
				if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col])
					continue;

				// 흰 방끼리는 그냥 지나갈 수 있음
				if (map[row][col]) {
					visited[row][col] = true;
					queue.add(new Room(row, col, cnt));
				}
				// 검은 방은 흰 방으로 바꾸어야 함
				else {
					visited[row][col] = true;
					queue.add(new Room(row, col, cnt + 1));
				}
			}
		}

		System.out.println(answer);
	}

}
