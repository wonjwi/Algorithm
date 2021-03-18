package com.ssafy.workshop;

import java.io.*;
import java.util.StringTokenizer;

public class SW3289_서로소집합 {
	
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken()); // 집합의 개수
			makeSet(n); // 서로소 집합 생성
			
			int m = Integer.parseInt(st.nextToken()); // 연산의 개수
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				char k = st.nextToken().charAt(0);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				switch (k) {
				case '0':
					union(a, b);
					break;
				case '1':
					sb.append(check(a, b));
					break;
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static char check(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if (rootA == rootB) return '1';
		return '0';
	}

	private static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if (rootA == rootB) return false;
		parents[rootB] = rootA;
		return true;
	}

	private static int findSet(int a) {
		if (parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}

	private static void makeSet(int n) {
		parents = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

}
