package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node> {
		int a, b, weight;

		public Node(int from, int to, int weight) {
			this.a = from;
			this.b = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static Queue<Node> pq;
	static int parent[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<Node>();
		parent = new int[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			pq.add(new Node(A, B, C));
		}

		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		int sum = 0, cnt = 0;

		// 모든 정점들이 연결되면 종료
		while (cnt < V - 1) {
			Node node = pq.poll();

			// 두 정점을 연결할 수 있으면
			if (union(node.a, node.b)) {
				sum += node.weight;
				cnt++;
			}
		}

		System.out.println(sum);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) // 이미 연결된 경우
			return false;

		parent[bRoot] = aRoot;

		return true;
	}

	private static int find(int a) {
		if (parent[a] == a)
			return a;

		return parent[a] = find(parent[a]);
	}

}