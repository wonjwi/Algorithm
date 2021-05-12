package week15;

import java.io.*;
import java.util.*;

public class BJ2668_숫자고르기 {
	
	static int N, num[];
	static boolean visited[], cycle[];
	static List<Integer> answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		num = new int[N+1];
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		
		// 사이클을 이루는 정수들 찾기
		visited = new boolean[N+1];
		cycle = new boolean[N+1];
		answer = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			DFS(i); // 끝까지 탐색
		}
		
		// 뽑힌 정수들을 개수와 함께 출력
		sb.append(answer.size()).append("\n");
		Collections.sort(answer);
		for (int i : answer) {
			sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void DFS(int curr) {
		// 이미 확인한 번호라면
		if (visited[curr]) return;
		visited[curr] = true;
		int next = num[curr];
		// 다음 번호가 이미 확인한 번호라면
		if (visited[next]) {
			// 새로운 사이클이면 리스트에 넣기
			if (!cycle[next]) {
				answer.add(curr);
				while (next != curr) {
					answer.add(next);
					next = num[next];
				}
			}
		} else { // 다음 번호 탐색
			DFS(next);
		}
		cycle[curr] = true;
	}

}
