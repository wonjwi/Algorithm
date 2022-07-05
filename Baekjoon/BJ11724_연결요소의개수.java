package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static int N, M, answer;
	static boolean map[][], visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][N];
		visited = new boolean[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			map[u][v] = map[v][u] = true;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				answer++;
				visited[i] = true;
				check(i);
			}
		}

		System.out.println(answer);
	}

	private static void check(int i) {
		for (int j = 0; j < N; j++) {
			if (!visited[j] && map[i][j]) {
				visited[j] = true;
				check(j);
			}
		}
	}

}