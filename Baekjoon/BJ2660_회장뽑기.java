package week12;

import java.io.*;
import java.util.*;

public class BJ2660_회장뽑기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int adj[][] = new int[N+1][N+1];
		while (true) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1) break; // 마지막 줄
			adj[b][a] = adj[a][b] = 1; // a와 b가 친구
		}
		
		// 친구의 친구인 회원들의 거리 구하기
		for (int i = 1; i <= N; i++) { // 경유지
			for (int start = 1; start <= N; start++) { // 출발지
				if (i == start) continue;
				for (int end = 1; end <= N; end++) { // 도착지
					if (start == end || i == end) continue;
					// 현재 경유한 값이 더 짧으면 갱신
					if (adj[start][i] == 0 || adj[i][end] == 0) continue;
					if (adj[start][i]+adj[i][end] < adj[start][end] || adj[start][end] == 0) 
						adj[start][end] = adj[start][i]+adj[i][end];
				}
			}
		}
		
		// 회원들 중 점수가 가장 작은 사람이 회장이 됨
		int max = 0, min = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			max = 0;
			for (int j = 1; j <= N; j++) {
				max = Math.max(max, adj[i][j]);
			}
			if (max < min) {
				min = max;
				list.clear();
				list.add(i);
			} 
			else if (max == min) list.add(i);
		}
		
		// 회장의 점수와 회장이 될 수 있는 모든 사람 찾기
		sb.append(min).append(" ").append(list.size()).append("\n");
		for (int i : list) sb.append(i).append(" ");
		System.out.println(sb.toString());
	}

}

// BFS 풀이
/* 
public class BJ2660_회장뽑기 {
	
	static int N, adj[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		adj = new int[N+1][N+1];
		while (true) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1) break; // 마지막 줄
			adj[b][a] = adj[a][b] = 1; // a와 b가 친구
		}
		
		// 친구의 친구인 회원들의 거리로 점수 구하기
		// 점수가 가장 작은 사람은 회장이 됨
		int score = 0, min = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			score = getScore(i);
			if (score < min) {
				min = score;
				list.clear();
				list.add(i);
			} 
			else if (score == min) list.add(i);
		}
		
		// 회장의 점수와 회장이 될 수 있는 모든 사람 찾기
		sb.append(min).append(" ").append(list.size()).append("\n");
		for (int i : list) sb.append(i).append(" ");
		System.out.println(sb.toString());
	}

	private static int getScore(int num) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(num);
		boolean visited[] = new boolean[N+1];
		visited[num] = true;
		
		int len, cnt = -1;
		while (!queue.isEmpty()) {
			len = queue.size();
			cnt++; // 사이에 있는 친구수
			for (int i = 0; i < len; i++) {
				int curr = queue.poll();
				for (int j = 1; j <= N; j++) {
					if (!visited[j] && adj[curr][j] == 1) {
						queue.add(j);
						visited[j] = true;
					}
				}
			}
		}
		return cnt;
	}

}
*/