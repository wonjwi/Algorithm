package ssafy.homework;

import java.io.*;
import java.util.*;

public class BJ15961_회전초밥 {
	
	private static int N, d, k, c, max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 접시의 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		// 벨트에 놓인 초밥의 종류
		int[] map = new int[N];
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(in.readLine());
		}
		// 첫번째부터 연속된 k개의 접시를 선택
		int[] visited = new int[3001];
		visited[c]++; // 쿠폰으로 먹는 초밥
		for (int i = 0; i < k; i++) {
			visited[map[i]]++;
		}
		// 그때의 초밥 가짓수 계산
		int count = 0;
		for (int i = 1; i <= d; i++) {
			if (visited[i] > 0) count++;
		}
		max = Math.max(max, count);
		// 이어서 연속된 k개의 접시를 반복해서 선택
		for (int i = 0; i < N-1; i++) {
			// 이전 접시가 중복으로 있을 때
			if (visited[map[i]] > 1) {
				visited[map[i]]--;
			} 
			// 이전 접시가 중복으로 없을 때
			else {
				visited[map[i]] = 0;
				count--;
			}
			// 다음 접시가 중복으로 없을 때
			if (visited[map[(k+i)%N]] == 0) {
				count++;
			} 
			visited[map[(k+i)%N]]++;
			// 최댓값 갱신
			max = Math.max(max, count);
		}
		// 먹을 수 있는 초밥 가짓수의 최대값
		System.out.println(max);
	}

}
