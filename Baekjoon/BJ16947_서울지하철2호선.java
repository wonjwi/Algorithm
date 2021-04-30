package week13;

import java.io.*;
import java.util.*;

public class BJ16947_서울지하철2호선 {
	
	static boolean visited[], isCycle;
	static int N, distance[];
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		
		visited = new boolean[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, -1);
		
		ArrayList<Integer> adj[] = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		
		// 순환선 찾기
		DFS(adj, 0, 1);
		// 각 역과 순환선의 거리 구하기
		BFS(adj);
		
		for (int i = 1; i <= N; i++) {
			sb.append(distance[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static void BFS(ArrayList<Integer>[] adj) {
		int cnt = 1;
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int j = 0; j < len; j++) {
				int tmp = queue.poll();
				// 연결된 구간 모두 큐에 추가
				for (int i : adj[tmp]) {
					if (distance[i] == -1) {
						distance[i] = cnt;
						queue.add(i);
					}
				}
			}
			cnt++; // 순환선과의 거리
		}
	}

	private static void DFS(ArrayList<Integer>[] adj, int prev, int curr) {
		visited[curr] = true;
		// 연결된 구간 모두 탐색
		for (int next : adj[curr]) {
			// 직전 방문지가 아니면서 방문한 곳에 도착
			// 사이클을 이뤘다!!
			if (visited[next] && next != prev) {
				isCycle = true;
				distance[next] = 0;
				queue.add(next);
				break;
			} else if (!visited[next]) {
				DFS(adj, curr, next);
				// 사이클에 속하는 경우
				if (isCycle) {
					// 사이클을 다 돌았으면 종료
					if (distance[next] == 0) {
						isCycle = false;
					} else {
						distance[next] = 0;
						queue.add(next);
					}
					return;
				}
			}
		}
	}

}
