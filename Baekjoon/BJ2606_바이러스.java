package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static boolean computer[][], visited[];
	static int N, M, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());

		computer = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			computer[b][a] = computer[a][b] = true;
		}

		visited[1] = true;

		virus(1);

		System.out.println(answer);
	}

	private static void virus(int n) {
		for (int i = 1; i <= N; i++) {
			if (computer[n][i] && !visited[i]) {
				answer++;
				visited[i] = true;

				virus(i);
			}
		}
	}

}