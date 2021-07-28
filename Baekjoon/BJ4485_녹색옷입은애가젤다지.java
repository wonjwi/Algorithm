package week24;

import java.io.*;
import java.util.*;

public class BJ4485_녹색옷입은애가젤다지 {

	static class Link implements Comparable<Link> {
		int r, c, rupee;

		public Link(int r, int c, int rupee) {
			this.r = r;
			this.c = c;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Link o) {
			return this.rupee - o.rupee;
		}
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = 1, N, map[][], answer = 0;
		boolean visited[][];

		while (true) {
			N = Integer.parseInt(in.readLine());
			
			if (N == 0) break;
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			// 각 칸에 있는 도둑루피의 크기 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 링크가 동굴의 입구부터 출구까지 이동
			PriorityQueue<Link> queue = new PriorityQueue<Link>();

			// 동굴의 제일 왼쪽 위에서 출발
			queue.add(new Link(0, 0, map[0][0]));
			visited[0][0] = true;

			int r, c, rupee, row, col;

			while (!queue.isEmpty()) {
				// 우선순위 제일 높은 값 꺼내기
				Link tmp = queue.poll();
				r = tmp.r;
				c = tmp.c;
				rupee = tmp.rupee;

				// 제일 오른쪽 아래에 도착하면 종료
				if (r == N - 1 && c == N - 1) {
					answer = rupee;
					break;
				}

				// 도착하지 않았으면 계속 이동
				for (int d = 0; d < 4; d++) {
					// 상하좌우 인접한 곳으로 1칸 이동
					row = r + dr[d];
					col = c + dc[d];

					if (row < 0 || row >= N || col < 0 || col >= N || visited[row][col]) {
						continue;
					}

					queue.add(new Link(row, col, rupee + map[row][col]));
					visited[row][col] = true;
				}
			}

			// 링크가 잃어야 하는 최소 금액 출력
			sb.append("Problem ").append(tc++).append(": ").append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}

}
