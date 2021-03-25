package com.ssafy.homework;

import java.io.*;
import java.util.StringTokenizer;

public class BJ9205_맥주 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 상근이네, 편의점, 락페스티벌 좌표 입력
			int N = Integer.parseInt(in.readLine());
			int[][] coords = new int[N+2][2];
			int[] minEdge = new int[N+2];
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(in.readLine());
				coords[i][0] = Integer.parseInt(st.nextToken());
				coords[i][1] = Integer.parseInt(st.nextToken());
				minEdge[i] = Integer.MAX_VALUE;
			}
			
			// 맥주 한 박스(20개) * 50미터에 한 병 => 1000미터
			minEdge[0] = 0; // 상근이네가 시작정점
			boolean[] visited = new boolean[N+2];
			
			for (int c = 0; c < N+2; c++) {
				int min = Integer.MAX_VALUE;
				int minVertex = 0;
				// 아직 연결되지 않은 정점 중 비용이 최소인 곳
				for (int i = 0; i < N+2; i++) {
					if (!visited[i] && min > minEdge[i]) {
						min = minEdge[i];
						minVertex = i;
					}
				}
				
				visited[minVertex] = true;
				
				for (int i = 0; i < N+2; i++) {
					// 연결되지 않았고 인접하고 가까운 곳
					int dist = Math.abs(coords[minVertex][0]-coords[i][0]) + Math.abs(coords[minVertex][1]-coords[i][1]);
					if (!visited[i] && dist <= 1000 && minEdge[i] > dist) {
						minEdge[i] = dist;
					}
				}
			}
			sb.append(minEdge[N+1] == Integer.MAX_VALUE ? "sad" : "happy").append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
