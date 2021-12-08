package algorithm;

import java.io.*;
import java.util.*;

public class BJ1260_DFS와BFS {

	static int N, M, V;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		// 그래프 간선 정보를 입력
		boolean graph[][] = new boolean[N + 1][N + 1];
		int a, b;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = true;
		}

		// 깊이 우선 탐색(DFS)
		boolean visited[] = new boolean[N + 1];
		visited[V] = true; // 시작 정점
		sb.append(V).append(" ");
		dfs(graph, visited, sb, V);

		// 넓이 우선 탐색(BFS)
		visited = new boolean[N + 1]; // 초기화
		visited[V] = true; // 시작 정점
		sb.append("\n").append(V).append(" ");
		bfs(graph, visited, sb);

		System.out.println(sb.toString());
	}

	private static void dfs(boolean[][] graph, boolean[] visited, StringBuilder sb, int n) {
		for (int i = 1; i <= N; i++) {
			if (graph[n][i] && !visited[i]) {
				visited[i] = true;
				sb.append(i).append(" ");
				dfs(graph, visited, sb, i);
			}
		}
	}

	private static void bfs(boolean[][] graph, boolean[] visited, StringBuilder sb) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			for (int i = 1; i <= N; i++) {
				if (graph[n][i] && !visited[i]) {
					visited[i] = true;
					sb.append(i).append(" ");
					queue.add(i);
				}
			}
		}
	}

}