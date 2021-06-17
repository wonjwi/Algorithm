package week18;

import java.io.*;
import java.util.*;

// PRIM (프림)
public class BJ16398_행성연결 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 각 행성간의 플로우 관리 비용
		int N = Integer.parseInt(in.readLine());
		int adjMatrix[][] = new int[N][N];
		int minEdge[] = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		boolean visited[] = new boolean[N];
		long answer = 0; int min, minIdx;
		minEdge[0] = 0; // 시작 행성 셋팅
		
		// N개의 행성을 최소비용으로 연결
		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
			minIdx = 0;
			
			// 연결되지 않은 행성 중 비용이 최소인 행성 탐색
			for (int j = 0; j < N; j++) {
				if (!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minIdx = j;
				}
			}
			
			answer += min; // 해당 행성의 비용 더하기
			visited[minIdx] = true;
			
			for (int j = 0; j < N; j++) {
				// 연결되지 않은 행성 중 비용이 더 저렴한 경로 찾기
				if (!visited[j] && minIdx != j && minEdge[j] > adjMatrix[minIdx][j]) {
					minEdge[j] = adjMatrix[minIdx][j];
				}
			}
		}
		
		System.out.println(answer);
	}

}

// Kruskal (크루스칼)
//public class BJ16398_행성연결 {
//
//	static class Edge implements Comparable<Edge> {
//		int from, to, weight;
//
//		public Edge(int from, int to, int weight) {
//			this.from = from;
//			this.to = to;
//			this.weight = weight;
//		}
//
//		@Override
//		public int compareTo(Edge o) {
//			return Integer.compare(this.weight, o.weight);
//		}
//	}
//
//	static int parents[];
//	static List<Edge> edgeList;
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//
//		int N = Integer.parseInt(in.readLine());
//		int weight;
//		parents = new int[N];
//		edgeList = new ArrayList<Edge>();
//
//		// 각 행성간의 플로우 관리 비용 입력
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(in.readLine(), " ");
//			for (int j = 0; j < N; j++) {
//				weight = Integer.parseInt(st.nextToken());
//				if (i >= j) continue;
//				edgeList.add(new Edge(i, j, weight));
//			}
//		}
//		
//		// 행성간의 비용 기준 오름차순 정렬
//		Collections.sort(edgeList);
//		
//		// 부모 노드 값 셋팅
//		for (int i = 0; i < N; i++) {
//			parents[i] = i;
//		}
//		
//		// N개의 행성을 최소비용으로 연결
//		long answer = 0; int cnt = 0;
//		for (Edge edge : edgeList) {
//			if (union(edge.from, edge.to)) {
//				answer += edge.weight;
//				if (++cnt == N-1) break;
//			}
//		}
//		System.out.println(answer);
//	}
//	
//	private static boolean union(int a, int b) {
//		a = findParent(a);
//		b = findParent(b);
//		
//		if (a == b) return false;
//		
//		parents[b] = a;
//		return true;
//	}
//
//	private static int findParent(int x) {
//		if (parents[x] == x) return x;
//		return parents[x] = findParent(parents[x]);
//
//	}
//
//}
