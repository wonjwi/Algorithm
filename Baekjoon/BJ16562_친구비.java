package com.ssafy.homework;

import java.io.*;
import java.util.StringTokenizer;

public class BJ16562_친구비 {
	
	static void makeSet(int[] parents, int V) {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int[] parents, int a) {
		if (parents[a] == a) return a;
		return parents[a] = findSet(parents, parents[a]);
	}
	
	static boolean union(int[] parents, int a, int b) {
		int aRoot = findSet(parents, a);
		int bRoot = findSet(parents, b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 학생수
		int M = Integer.parseInt(st.nextToken()); // 친구관계수
		int k = Integer.parseInt(st.nextToken()); // 가진 돈
		
		// 각각의 학생이 원하는 친구비
		st = new StringTokenizer(in.readLine(), " ");
		int[] cost = new int[N+1];
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		// 학생들의 친구 관계
		int[] parents = new int[N+1];
		makeSet(parents, N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (cost[findSet(parents, from)] > cost[findSet(parents, to)]) {
				int temp = from;
				from = to;
				to = temp;
			}
			union(parents, from, to);
		}
		for (int i = 1; i <= N; i++) {
			findSet(parents, i);
		}
		
		// 친구비로 모두와 친구 되기
		boolean[] visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			visited[parents[i]] = true;
		}
		
		// 모든 학생과 친구가 되는 최소비용
		int totalCost = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i]) totalCost += cost[i];
		}
		System.out.println((totalCost <= k) ? totalCost : "Oh no");
	}

}
