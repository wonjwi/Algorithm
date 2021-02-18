package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

/** 1247. [S/W 문제해결 응용] 3일차 - 최적 경로
 * 회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 가장 짧은 경로 찾기
 */
public class SW1247_최적경로 {
	static int N, minDistance;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			minDistance = Integer.MAX_VALUE;
			N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[][] location = new int[N+2][]; // 방문할 위치
			// 시작 위치 저장 (회사)
			location[0] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			// 마지막 위치 저장 (집)
			location[N+1] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			// 고객 위치들 저장
			for (int i = 1; i < N+1; i++)
				location[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			// 가장 짧은 경로 구하기
			visitCustomer(location, new boolean[N+1], 0, 0, 0);
			// 가장 짧은 경로의 이동거리 출력하기
			result.append("#").append(tc).append(" ").append(minDistance).append("\n");
		}
		System.out.println(result);
	}

	private static void visitCustomer(int[][] location, boolean[] visited, int cnt, int prev, int distance) {
		if (distance >= minDistance) return;
		// 경로가 완성되면 이동거리 계산
		if (cnt == N) {
			int temp = Math.abs(location[prev][0]-location[N+1][0]);
			temp += Math.abs(location[prev][1]-location[N+1][1]);
			minDistance = Math.min(minDistance, distance+temp);
			return;
		}
		for (int i = 1; i < N+1; i++) {
			if (visited[i]) continue;
			
			int temp = Math.abs(location[prev][0]-location[i][0]);
			temp += Math.abs(location[prev][1]-location[i][1]);
			
			visited[i] = true;
			visitCustomer(location, visited, cnt+1, i, distance+temp);
			visited[i] = false;
		}
	}
}
