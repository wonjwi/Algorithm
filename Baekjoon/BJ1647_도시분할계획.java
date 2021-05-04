package week08;

import java.io.*;
import java.util.*;

public class BJ1647_도시분할계획 {
	
	static class Road implements Comparable<Road> {
		int from, to, cost;
		public Road(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Road o) {
			return this.cost-o.cost;
		}
	}
	static int N, M, parents[];
	static Road[] roadList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 집의 개수
		M = Integer.parseInt(st.nextToken()); // 길의 개수
		
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		// 연결된 길의 정보 입력
		roadList = new Road[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			roadList[i] = new Road(from, to, cost);
		}
		// 비용 기준 오름차순 정렬
		Arrays.sort(roadList);
		
		// 두 마을에 최소의 길만 남겼을 때의 유지비 합
		int answer = 0, count = 0;
		for (Road road : roadList) {
			if (union(road.from, road.to)) {
				answer += road.cost;
				// 두 마을로 나누기 위해 한 군데 덜 연결
				if (++count == N-2) break;
			}
		}
		System.out.println(answer);
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int findSet(int a) {
		if (parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}

}
