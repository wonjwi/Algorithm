package algorithm;

import java.io.*;
import java.util.*;

public class BJ13460_구슬탈출2 {

	static class Pos implements Comparable<Pos> {
		int rr, rc, br, bc, cnt;

		public Pos(int rr, int rc, int br, int bc, int cnt) {
			this.rr = rr;
			this.rc = rc;
			this.br = br;
			this.bc = bc;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pos o) {
			return this.cnt - o.cnt;
		}
	}

	static int dr[] = { 0, 0, -1, 1 };
	static int dc[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean map[][] = new boolean[N][M];
		boolean visited[][][][] = new boolean[N][M][N][M];
		int rr = 0, rc = 0, br = 0, bc = 0, gr = 0, gc = 0;

		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				switch (str.charAt(j)) {
				case '#':
					map[i][j] = true;
					break;
				case 'R':
					rr = i;
					rc = j;
					break;
				case 'B':
					br = i;
					bc = j;
					break;
				case 'O':
					gr = i;
					gc = j;
					break;
				}
			}
		}

		Queue<Pos> queue = new PriorityQueue<Pos>();
		queue.add(new Pos(rr, rc, br, bc, 0));
		visited[rr][rc][br][bc] = true;

		while (!queue.isEmpty()) {
			Pos pos = queue.poll();

			if (pos.cnt >= 10) {
				System.out.println(-1);
				return;
			}

			// 좌우상하로 구슬 이동 가능
			for (int d = 0; d < 4; d++) {
				boolean red = false, blue = false;

				rr = pos.rr;
				rc = pos.rc;
				br = pos.br;
				bc = pos.bc;

				while (!map[rr + dr[d]][rc + dc[d]]) {
					rr += dr[d];
					rc += dc[d];

					// 빨간 구슬이 구멍에 도착
					if (rr == gr && rc == gc) {
						red = true;
						break;
					}
				}
				while (!map[br + dr[d]][bc + dc[d]]) {
					br += dr[d];
					bc += dc[d];

					// 파란 구슬이 구멍에 도착
					if (br == gr && bc == gc) {
						blue = true;
						break;
					}
				}

				if (blue) {
					continue;
				} else if (red) {
					System.out.println(pos.cnt + 1);
					return;
				}

				// 같은 칸에 있을 수 없음
				if (rr == br && rc == bc) {
					switch (d) {
					case 0: // 왼쪽
						if (pos.rc < pos.bc) {
							bc++;
						} else {
							rc++;
						}
						break;
					case 1: // 오른쪽
						if (pos.rc < pos.bc) {
							rc--;
						} else {
							bc--;
						}
						break;
					case 2: // 위쪽
						if (pos.rr < pos.br) {
							br++;
						} else {
							rr++;
						}
						break;
					case 3: // 아래쪽
						if (pos.rr < pos.br) {
							rr--;
						} else {
							br--;
						}
						break;
					}
				}

				if (!visited[rr][rc][br][bc]) {
					queue.add(new Pos(rr, rc, br, bc, pos.cnt + 1));
					visited[rr][rc][br][bc] = true;
				}
			}
		}

		System.out.println(-1);
	}

}