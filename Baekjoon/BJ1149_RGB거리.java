package hwalgo20_서울_7_원지연;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1149_RGB거리 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine()); // 집의 수
		
		// 집을 빨강, 초록, 파랑으로 칠하는 비용
		int[][] RGB = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 모두 옆집과 다른 색으로 칠하는 최솟값 구하기
		int[][] cost = new int[N][3];
		cost[0][0] = RGB[0][0];
		cost[0][1] = RGB[0][1];
		cost[0][2] = RGB[0][2];
		
		for (int i = 1; i < N; i++) {
			cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + RGB[i][0];
			cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + RGB[i][1];
			cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + RGB[i][2];
		}
		System.out.println(Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2])));
	}

}
