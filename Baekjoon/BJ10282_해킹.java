package week09;

import java.io.*;
import java.util.*;

public class BJ10282_해킹 {
	
	static class Computer {
		int node, time;
		public Computer(int node, int time) {
			this.node = node;
			this.time = time;
		}
	}
	static int cnt, result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
			int d = Integer.parseInt(st.nextToken()); // 의존성 개수
			int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호
			
			// 의존성 정보 입력
			List<Computer>[] adjList = new ArrayList[n+1];
			for (int i=1; i<=n; i++) {
				adjList[i] = new ArrayList<Computer>();
			}
			for (int i = 0; i < d; i++) {
				// a가 b를 의존, b 감염 s초 후 a도 감염됨
				st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				adjList[b].add(new Computer(a, s));
			}
			// 컴퓨터 c부터 컴퓨터 감염 시작
			cnt = 1; result = 0;
			dijkstra(adjList, n, c);
			// 감염되는 컴퓨터 수와 마지막 감염까지 걸리는 시간
			sb.append(cnt).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dijkstra(List<Computer>[] adjList, int n, int start) {
		// 컴퓨터 start부터 감염 시작
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0; 
		
		// 감염에 걸리는 시간이 짧은 곳부터 삽입
		PriorityQueue<Computer> pq = new PriorityQueue<Computer>((c1, c2) -> c1.time-c2.time);
		pq.add(new Computer(start, 0));
		
		// 감염이 끝날 때까지 반복
		while (!pq.isEmpty()) {
			Computer tmp = pq.poll();
			int curr = tmp.node;
			// 마지막 감염 시간 갱신
			result = Math.max(result, distance[curr]);
			
			// curr을 경유지로 하는 다른 컴퓨터로의 감염 시간 따져보기
			for (Computer com : adjList[curr]) {
				int next = com.node, time = com.time;
				if (distance[next] > distance[curr]+time) {
					// 첫 방문이면 감염 컴퓨터 수 카운트
					if (distance[next] == Integer.MAX_VALUE) cnt++;
					
					distance[next] = distance[curr]+time;
					pq.add(new Computer(next, distance[next]));
				}
			}
		}
	}
	
}
