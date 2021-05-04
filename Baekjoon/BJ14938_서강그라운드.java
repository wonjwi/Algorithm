package week14;

import java.io.*;
import java.util.*;

public class BJ14938_서강그라운드 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		// 각 구역에 있는 아이템의 수
		st = new StringTokenizer(in.readLine(), " ");
		int item[] = new int[n+1];
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		// 각 구역에 연결된 길의 정보
		int adj[][] = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			adj[i][i] = -1;
		}
		int a, b, l;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			adj[b][a] = adj[a][b] = l;
		}
		// 각 구역 사이의 최단거리 찾기
		for (int i = 1; i <= n; i++) { // 경유지
			for (int start = 1; start <= n; start++) { // 출발지
				if (i == start) continue;
				for (int end = 1; end <= n; end++) { // 도착지
					if (start == end || i == end) continue;
					// 현재 경유한 값이 더 짧으면 갱신
					if (adj[start][i] == 0 || adj[i][end] == 0) continue;
					if (adj[start][i]+adj[i][end] < adj[start][end] || adj[start][end] == 0) 
						adj[start][end] = adj[start][i]+adj[i][end];
				}
			}
		}
		// 얻을 수 있는 최대 아이템 개수 찾기
		int max = 0, sum;
		for (int i = 1; i <= n; i++) {
			sum = 0;
			for (int j = 1; j <= n; j++) {
				if (adj[i][j] <= m && adj[i][j] != 0) sum += item[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
