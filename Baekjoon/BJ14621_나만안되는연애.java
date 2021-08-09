package week25;

import java.io.*;
import java.util.*;

public class BJ14621_나만안되는연애 {

	static class Node implements Comparable<Node> {
		int from, to, distance;

		public Node(int from, int to, int distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}
	}
	
	static int N, M, parents[];
	static PriorityQueue<Node> nodeList;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean isWoman[] = new boolean[N + 1];
		st = new StringTokenizer(in.readLine(), " ");
		
		// 남초 대학교인지 여초 대학교인지 여부
		for (int i = 1; i <= N; i++) {
			isWoman[i] = st.nextToken().charAt(0) == 'W' ? true : false;
		}

		nodeList = new PriorityQueue<Node>();
		int u, v, d, cnt = 0, answer = 0;
		
		// 대학교 간의 도로 데이터 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			// 사심을 만족시키지 않는 길 제외
			if (isWoman[u] == isWoman[v]) continue;

			nodeList.add(new Node(u, v, d));
		}
		
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		// 만들 수 있는 가장 짧은 사심 경로 찾기
		while (!nodeList.isEmpty()) {
			Node node = nodeList.poll();
			
			if (!union(node.from, node.to)) continue;
			
			answer += node.distance;
			if (++cnt == N - 1) break;
		}

		// 사심 경로의 길이 출력
		System.out.println(cnt >= N - 1 ? answer : -1);
	}

	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		// 부모 노드 같음 => 사이클 형성 => 이미 포함된 경로
		if (a == b) return false;
		
		parents[b] = a;
		return true;
	}
	
}
