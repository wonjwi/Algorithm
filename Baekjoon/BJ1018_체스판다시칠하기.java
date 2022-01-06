package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M, answer = Integer.MAX_VALUE;
	static boolean map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 흰색이면 true, 검은색이면 false
		map = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) == 'W';
			}
		}

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				paint(i, j);
			}
		}

		System.out.println(answer);
	}

	private static void paint(int r, int c) {
		int white = 0, black = 0;
		boolean flag = false;

		for (int i = r; i < r + 8; i++) {
			for (int j = c; j < c + 8; j++) {
				// 맨 왼쪽 위 칸이 흰색
				if (map[i][j] == flag) {
					white++;
				}

				// 맨 왼쪽 위 칸이 검은색
				if (map[i][j] != flag) {
					black++;
				}
				flag = !flag;
			}
			flag = !flag;
		}

		answer = Math.min(answer, Math.min(white, black));
	}

}