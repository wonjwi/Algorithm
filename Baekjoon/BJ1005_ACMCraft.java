package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static int N, K, time[];
	static int dp[] = new int[1001];
	static boolean adj[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = new int[N + 1];
			adj = new boolean[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				dp[i] = -1;
			}

			// 각 건물당 건설에 걸리는 시간
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}

			// 각 건물의 건설 순서
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());

				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				adj[Y][X] = true; // Y 지으려면 X 먼저
			}

			// 승리하기 위해 건설해야 할 건물 번호
			int W = Integer.parseInt(in.readLine());

			sb.append(craft(W)).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static int craft(int w) {
		if (dp[w] >= 0)
			return dp[w];

		int max = 0;

		for (int i = 1; i <= N; i++) {
			if (adj[w][i]) {
				max = Math.max(max, craft(i));
			}
		}

		return dp[w] = max + time[w];
	}

}