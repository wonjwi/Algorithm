package week29;

import java.io.*;
import java.util.*;

public class BJ15900_나무탈출 {

	static int sumOfCnt = 0;
	static boolean visited[];
	static List<Integer> adj[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		visited = new boolean[N + 1];
		adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}

		play(1, 1);

		System.out.println(sumOfCnt % 2 == 0 ? "No" : "Yes");
	}

	private static void play(int curr, int cnt) {
		for (int next : adj[curr]) {
			// 방문했던 노드일 경우
			if (visited[next]) {
				continue;
			}
			visited[next] = true;

			// 리프 노드일 경우
			if (adj[next].size() == 1) {
				sumOfCnt += cnt;
			} else {
				play(next, cnt + 1);
			}
		}
	}

}