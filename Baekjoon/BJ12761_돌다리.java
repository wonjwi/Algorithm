package week10;

import java.io.*;
import java.util.*;

public class BJ12761_돌다리 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int A = Integer.parseInt(st.nextToken()); // 스카이 콩콩의 힘
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken()); // 동규 위치
		int M = Integer.parseInt(st.nextToken()); // 주미 위치
		
		// 이동할 수 있는 방식 8가지
		// +1, -1, +A, -A, +B, -B, *A, *B
		BFS(A, B, N, M);
	}

	private static void BFS(int A, int B, int N, int M) {
		boolean[] visited = new boolean[100001];
		int[] move = {1, -1, A, B, -A, -B};
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {N, 0}); // 현 위치, 이동 횟수
		visited[N] = true; // 방문 체크
		
		// 주미에게 도착할 때까지 이동
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int curr = tmp[0];
			int cnt = tmp[1];
			// 주미에게 도착하면 이동 횟수 출력
			if (curr == M) {
				System.out.println(cnt);
				break;
			}
			// 도착하지 않았으면 8가지 방법 시도
			// 단, 이미 방문한 돌다리는 제외
			for (int i = 0; i < 6; i++) {
				int next = curr+move[i];
				if (next < 0 || next > 100000 || visited[next]) continue;
				visited[next] = true;
				q.add(new int[] {next, cnt+1});
			}
			if (curr*A<=100000 && !visited[curr*A]) {
				visited[curr*A] = true;
				q.add(new int[] {curr*A, cnt+1});
			}
			if (curr*B<=100000 && !visited[curr*B]) {
				visited[curr*B] = true;
				q.add(new int[] {curr*B, cnt+1});
			}
		}
	}

}
