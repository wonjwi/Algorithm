package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static int M, N, map[][], dp[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		// 산의 세로-가로 크기
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// 산의 각 지점의 높이
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 도착지까지 내리막길로만 이동
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		}

		// 이동 가능한 경로의 수
		System.out.println(DFS(0, 0));
	}

	private static int DFS(int r, int c) {
		if (r == M - 1 && c == N - 1)
			return 1;

		else if (dp[r][c] >= 0)
			return dp[r][c];

		dp[r][c] = 0; // 방문체크

		// 상하좌우로 가능한지 확인
		for (int d = 0; d < 4; d++) {
			int row = r + dr[d];
			int col = c + dc[d];

			if (row < 0 || row >= M || col < 0 || col >= N)
				continue;

			// 내리막길로만 이동 가능
			if (map[r][c] > map[row][col]) {
				dp[r][c] += DFS(row, col);
			}
		}

		return dp[r][c];
	}

}