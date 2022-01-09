package week28;

import java.io.*;
import java.util.*;

public class BJ17396_백도어 {

	static class Node implements Comparable<Node> {
		int node;
		long time;

		public Node(int node, long time) {
			this.node = node;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			if (this.time < o.time)
				return -1;
			else
				return 1;
		}
	}

	static final long INF = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean isShow[] = new boolean[N];
		List<Node> adjList[] = new ArrayList[N];
		long distance[] = new long[N];

		// 각 분기점이 시야에 보이는지 여부
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			isShow[i] = st.nextToken().charAt(0) == '1' ? true : false;
			adjList[i] = new ArrayList<Node>();
			distance[i] = INF;
		}

		isShow[N - 1] = false;
		distance[0] = 0;

		// 한 분기점에서 다른 분기점으로 가는 간선
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			if (isShow[a] || isShow[b])
				continue;

			adjList[a].add(new Node(b, t));
			adjList[b].add(new Node(a, t));
		}

		// 상대 넥서스까지 가는데 걸리는 최소 시간
		Queue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0, 0));

		while (!pq.isEmpty()) {
			int curr = pq.peek().node;
			long currTime = pq.poll().time;

			if (distance[curr] < currTime)
				continue;

			for (Node tmp : adjList[curr]) {
				int next = tmp.node;
				long nextTime = tmp.time + currTime;

				if (nextTime < distance[next]) {
					distance[next] = nextTime;
					pq.add(new Node(next, nextTime));
				}
			}
		}

		System.out.println(distance[N - 1] == INF ? "-1" : distance[N - 1]);
	}

}