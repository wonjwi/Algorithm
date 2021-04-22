package algorithm;

import java.io.*;
import java.util.*;

public class BJ2458_키순서 {
	
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 학생들의 키 관계에 대한 인접 행렬
		int adj[][] = new int[N+1][N+1], answer = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1; // a가 b보다 작음
		}
		// 자신보다 큰 학생을 탐색하지 않은 상태로 초기화
		for (int i = 1; i <= N; i++) adj[i][0] = -1;
		
		// 아직 탐색 전이면 자신보다 큰 학생 따라서 탐색
		for (int i = 1; i <= N; i++) {
			if (adj[i][0] == -1) DFS(i, adj);
		}
		
		// 자신보다 작은 학생 수 구하기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				adj[0][j] += adj[i][j];
			}
		}
		// 자신의 키가 몇 번째인지 알 수 있는 학생의 수
		for (int i = 1; i <= N; i++) {
			if (adj[0][i]+adj[i][0] == N-1) answer++;
		}
		System.out.println(answer);
	}

	private static void DFS(int curr, int[][] adj) {
		for (int i = 1; i <= N; i++) {
			if (adj[curr][i] == 1) { // curr가 i보다 작으면
				// 아직 탐색하지 않은 학생이면 탐색
				if (adj[i][0] == -1) DFS(i, adj);
				// i보다 큰 학생이 있다면
				if (adj[i][0] > 0) {
					// curr도 그 학생보다 작다는 걸 표시
					for (int j = 1; j <= N; j++) {
						if (adj[i][j] == 1) adj[curr][j] = 1;
					}
				}
			}
		}
		int cnt = 0;
		// curr보다 큰 학생들을 모두 더함
		for (int i = 1; i <= N; i++) cnt += adj[curr][i];
		adj[curr][0] = cnt;
	}

}
/*
// 플로이드-와샬
public class BJ2458_키순서 {
	
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 학생들의 키 관계에 대한 인접 행렬
		int adj[][] = new int[N+1][N+1], answer = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1; // a가 b보다 작음
		}
		
		// 경유지 -> 출발지 -> 도착지
		for (int i = 1; i <= N; i++) {
			for (int start = 1; start <= N; start++) {
				if (i == start) continue; // 출발지가 경유지와 같을 때
				for (int end = 1; end <= N; end++) {
					if (start == end || i == end) continue; // 도착지가 경유지나 출발지와 같을 때
					if (adj[start][i]+adj[i][end] == 2) {
						adj[start][end] = 1;
					}
				}
			}
		}
		// 자신의 키가 몇 번째인지 알 수 있는 학생의 수
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				adj[i][0] += adj[i][j];
				adj[0][i] += adj[j][i];
			}
			if (adj[0][i]+adj[i][0] == N-1) answer++;
		}
		System.out.println(answer);
	}
	
}
*/
/*
public class BJ2458_키순서 {
	
static int N, M, gtCnt[], ltCnt[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 학생들의 키 관계에 대한 인접 행렬
		int[][] adj = new int[N+1][N+1];
		gtCnt = new int[N+1];
		ltCnt = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1; // a가 b보다 작음
		}
		// 학생마다 자신보다 큰 학생 따라서 탐색
		for (int i = 1; i <= N; i++) {
			DFS(i, i, adj, new boolean[N+1]);
		}
		// 자신의 키가 몇 번째인지 알 수 있는 학생의 수
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (gtCnt[i]+ltCnt[i] == N-1) answer++;
		}
		System.out.println(answer);
	}

	private static void DFS(int curr, int start, int[][] adj, boolean[] visited) {
		visited[curr] = true;
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			if (adj[curr][i] == 1) {
				DFS(i, start, adj, visited);
				gtCnt[start]++; // start보다 i가 큼
				ltCnt[i]++; // start가 i보다 작음
			}
		}
	}

}
*/
