package algorithm;

import java.io.*;
import java.util.*;

public class BJ1012_유기농배추 {

	static int M, N;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		int K, x, y, pos[][], result;
		boolean map[][];

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new boolean[M][N];
			pos = new int[K][2];

			// 배추밭에 배추의 위치 입력
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				map[x][y] = true;
				pos[i][0] = x;
				pos[i][1] = y;
			}

			// 필요한 배추흰지렁이 마리 수 구하기
			result = 0;

			for (int i = 0; i < K; i++) {
				// 이미 검사한 위치는 PASS
				if (!map[pos[i][0]][pos[i][1]])
					continue;

				find(map, pos[i][0], pos[i][1]);
				result++;
			}

			sb.append(result).append("\n");
		}

		// 각 테스트 케이스의 결과 출력
		System.out.println(sb.toString());
	}

	private static void find(boolean[][] map, int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int tmp[], mX, mY;

		queue.add(new int[] { x, y });
		map[x][y] = false;

		while (!queue.isEmpty()) {
			tmp = queue.poll();
			x = tmp[0];
			y = tmp[1];

			// 상하좌우로 계속해서 탐색
			for (int d = 0; d < 4; d++) {
				mX = x + dx[d];
				mY = y + dy[d];

				if (mX < 0 || mX >= M || mY < 0 || mY >= N || !map[mX][mY])
					continue;

				queue.add(new int[] { mX, mY });
				map[mX][mY] = false;
			}
		}
	}

}
