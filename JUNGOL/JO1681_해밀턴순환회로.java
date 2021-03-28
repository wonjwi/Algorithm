package com.ssafy.homework;

import java.io.*;
import java.util.StringTokenizer;

public class JO1681_해밀턴순환회로 {
	
	static int N, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine()); // 장소의 수
		// i 장소에서 j 장소로 이동하는 비용 입력
		int[][] adjMatrix = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 물건을 모두 배달하고 회사로 돌아오기 위한 최소 비용 구하기
		go(adjMatrix, new boolean[N+1], 1, 1, 0);
		System.out.println(min);
	}

	private static void go(int[][] adjMatrix, boolean[] visited, int curr, int cnt, int sum) {
		// 배달을 마치면 출발지로 돌아가기
		if (cnt == N) {
			if (adjMatrix[curr][1] == 0) return;
			min = Math.min(min, sum+adjMatrix[curr][1]);
			return;
		}
		for (int i = 2; i <= N; i++) {
			if (visited[i] || adjMatrix[curr][i] == 0 || sum+adjMatrix[curr][i] > min) continue;
			visited[i] = true;
			go(adjMatrix, visited, i, cnt+1, sum+adjMatrix[curr][i]);
			visited[i] = false;
		}
	}

}