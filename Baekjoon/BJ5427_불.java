package week17;

import java.io.*;
import java.util.*;

public class BJ5427_불 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		char[][] map = null;
		boolean[][] visited = null;
		int w, h, time, size, temp[], r, c;
		Queue<int[]> sg = new LinkedList<int[]>();
		Queue<int[]> fire = new LinkedList<int[]>();
		boolean impossible;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			visited = new boolean[h][w];

			sg.clear();
			fire.clear();
			time = 0;
			impossible = true;

			// 빌딩의 지도 입력 받기
			for (int i = 0; i < h; i++) {
				map[i] = in.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					// 상근이의 위치
					if (map[i][j] == '@') {
						sg.add(new int[] { i, j, 0 });
						map[i][j] = '.';
						visited[i][j] = true;
					}
					// 불이 있는 위치
					else if (map[i][j] == '*') {
						fire.add(new int[] { i, j });
					}
				}
			}

			Loop: while (!sg.isEmpty()) {
				// 매 초마다 불이 퍼져나감
				size = fire.size();
				for (int i = 0; i < size; i++) {
					temp = fire.poll();
					for (int d = 0; d < 4; d++) {
						r = temp[0] + dr[d];
						c = temp[1] + dc[d];
						if (r < 0 || r >= h || c < 0 || c >= w)
							continue;
						// 빈 공간이면 불이 퍼짐
						if (map[r][c] == '.') {
							map[r][c] = '*';
							fire.add(new int[] { r, c });
						}
					}
				}
				// 상근이가 인접한 칸으로 이동
				size = sg.size();
				for (int i = 0; i < size; i++) {
					temp = sg.poll();
					for (int d = 0; d < 4; d++) {
						r = temp[0] + dr[d];
						c = temp[1] + dc[d];
						time = temp[2] + 1;
						// 빌딩 탈출 성공
						if (r < 0 || r >= h || c < 0 || c >= w) {
							impossible = false;
							break Loop;
						}
						// 가보지 않은 빈 공간이면 이동
						if (map[r][c] == '.' && !visited[r][c]) {
							sg.add(new int[] { r, c, time });
							visited[r][c] = true;
						}
					}
				}
			}
			sb.append(impossible ? "IMPOSSIBLE" : time).append("\n");
		}
		System.out.println(sb.toString());
	}

}
