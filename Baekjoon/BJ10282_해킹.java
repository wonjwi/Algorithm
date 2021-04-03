package week09;

import java.io.*;
import java.util.*;

public class BJ10282_해킹 {
	
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
			Map<Integer, Integer>[] adjList = new HashMap[n+1];
			for (int i=1; i<=n; i++) {
				adjList[i] = new HashMap<Integer, Integer>();
			}
			for (int i = 0; i < d; i++) {
				// a가 b를 의존, b 감염 s초 후 a도 감염됨
				st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				adjList[b].put(a, s);
			}
			// 입력된 정보로 컴퓨터 감염 시작
			int[] distance = new int[n+1];
			boolean[] visited = new boolean[n+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[c] = 0; // c부터 감염 시작
			
			int cnt = 0, idx = 0;
			for (int i = 1; i <= n; i++) {
				int min = Integer.MAX_VALUE;
				int curr = 0;
				// 감염되지 않은 컴퓨터 중 감염에 걸리는 시간이 짧은 곳 선택
				for (int j = 1; j <= n; j++) {
					if (!visited[j] && min > distance[j]) {
						min = distance[j];
						curr = j;
					}
				}
				// 감염이 끝나면 종료
				if (curr == 0) break;
				// 감염될 컴퓨터가 있으면 계속 진행
				visited[curr] = true;
				cnt++; idx = curr;
				// curr을 경유지로 하는 감염되지 않은 다른 컴퓨터로의 감염 시간 따져보기
				for (int j = 1; j <= n; j++) {
					if (visited[j] || !adjList[curr].containsKey(j)) continue;
					distance[j] = Math.min(distance[j], min+adjList[curr].get(j));
				}
			}
			// 감염되는 컴퓨터 수와 마지막 감염까지 걸리는 시간
			sb.append(cnt).append(" ").append(distance[idx]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
