package com.ssafy.homework;

import java.io.*;
import java.util.Arrays;

public class SW1251_하나로 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 섬들의 위치 정보 입력
			int N = Integer.parseInt(in.readLine()); // 섬의 개수
			String[] str1 = in.readLine().split(" "); // X좌표
			String[] str2 = in.readLine().split(" "); // Y좌표
			int[][] location= new int[N][2]; // X, Y
			for (int i = 0; i < N; i++) {
				location[i][0] = Integer.parseInt(str1[i]);
				location[i][1] = Integer.parseInt(str2[i]);
			}
			double E = Double.parseDouble(in.readLine()); // 환경 부담 세율
			
			// 환경 부담금을 최소로 하여 모든 섬 연결
			boolean[] visited = new boolean[N];
			double[] minEdge = new double[N];
			Arrays.fill(minEdge, Double.MAX_VALUE);
			minEdge[0] = 0;
			double result = 0.0;
			
			for (int c = 0; c < N; c++) {
				double min = Double.MAX_VALUE;
				int minVertex = 0;
				// 연결되지 않은 섬 중 비용이 최소인 곳 연결
				for (int i = 0; i < N; i++) {
					if (!visited[i] && min > minEdge[i]) {
						min = minEdge[i];
						minVertex = i;
					}
				}
				result += min;
				visited[minVertex] = true;
				
				for (int i = 0; i < N; i++) {
					// 연결되지 않았고 환경 부담금이 최소인 곳 찾기
					// 환경 부담금 = 환경 부담 세율(E)*해저터널 길이(L)^2
					double distance = Math.pow(location[minVertex][0]-location[i][0], 2) + Math.pow(location[minVertex][1]-location[i][1], 2);
					if (!visited[i] && minEdge[i] > distance) {
						minEdge[i] = distance;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(Math.round(result*E)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
