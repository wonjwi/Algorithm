package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static List<Node> adj[];
	static int max, maxV;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(in.readLine());
		int parent, child, weight;

		// 간선 정보를 저장할 리스트
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Node>();
		}

		// 노드의 각 간선 정보 입력
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			parent = Integer.parseInt(st.nextToken());
			child = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());

			adj[parent].add(new Node(child, weight));
			adj[child].add(new Node(parent, weight));
		}
		
		if (n > 1) {
			max = 0;
			visited = new boolean[n + 1];
			
			// 루트 노드 기준으로 가장 깊은 노드 찾기
			visited[1] = true;
			dfs(1, 0);
			System.out.println(max+","+maxV);
			
			max = 0;
			visited = new boolean[n + 1];
			
			// 찾은 노드 기준으로 가장 깊은 노드 찾기
			visited[maxV] = true;
			dfs(maxV, 0);
			System.out.println(max+","+maxV);
		}

		System.out.println(max);
	}

	private static void dfs(int v, int d) {
		if (d > max) {
			max = d;
			maxV = v;
		}

		for (Node node : adj[v]) {
			int next = node.v;
			int weight = node.w;

			// 아직 탐색하지 않은 곳이면
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, d + weight);
			}
		}
	}

}