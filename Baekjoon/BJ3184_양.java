package week25;

import java.io.*;
import java.util.*;

public class BJ3184_양 {

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static char map[][];
	static boolean visit[][];
	static int R, C, sheep, wolf;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];

		// 마당의 구조 입력
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		// 늑대 또는 양이 있는 영역 찾기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 아직 싸움 전이면 싸움 붙이기
				if ((map[i][j] == 'v' || map[i][j] == 'o') && !visit[i][j]) {
					fight(i, j, map[i][j] == 'v');
				}
			}
		}
		// 살아있는 양의 수와 늑대의 수 출력
		System.out.println(sheep + " " + wolf);
	}

	private static void fight(int sr, int sc, boolean isWolf) {
		Queue<int[]> q = new LinkedList<int[]>();
		int sCnt = isWolf ? 0 : 1, wCnt = isWolf ? 1 : 0, tmp[], r, c, row, col;

		// 입력 위치에서 탐색 시작
		q.add(new int[] { sr, sc });
		visit[sr][sc] = true;

		while (!q.isEmpty()) {
			tmp = q.poll();
			r = tmp[0];
			c = tmp[1];

			// 수평, 수직으로 탐색
			for (int i = 0; i < 4; i++) {
				row = r + dr[i];
				col = c + dc[i];

				if (row < 0 || row >= R || col < 0 || col >= C || visit[row][col]) {
					continue;
				}
				// 양과 늑대의 수 세기
				if (map[row][col] == 'o') {
					sCnt++;
				} else if (map[row][col] == 'v') {
					wCnt++;
				} else if (map[row][col] == '#') {
					continue;
				}
				// 방문 처리 후 큐에 넣기
				visit[row][col] = true;
				q.add(new int[] { row, col });
			}
		}

		// 더 많이 있는 쪽이 영역에 남음
		if (sCnt > wCnt) {
			sheep += sCnt;
		} else {
			wolf += wCnt;
		}
	}

}
