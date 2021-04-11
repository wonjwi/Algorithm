package week10;

import java.io.*;
import java.util.*;

public class BJ9466_텀프로젝트 {
	
	static boolean[] checked, visited;
	static int[] pick;
	static int n, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(in.readLine()); // 학생의 수
			st = new StringTokenizer(in.readLine(), " ");
			// 선택된 학생들의 번호 입력
			pick = new int[n+1];
			for (int i = 1; i <= n; i++) {
				pick[i] = Integer.parseInt(st.nextToken());
			}
			// 팀에 속하지 못한 학생들의 수 구하기
			ans = 0; // 결과 변수 초기화
			checked = new boolean[n+1];
			visited = new boolean[n+1];
			for (int i = 1; i <= n; i++) {
				if (visited[i]) continue;
				DFS(i);
			}
			sb.append(n-ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void DFS(int curr) {
		// 선택되었던 학생일 때
		if (visited[curr]) return;
		visited[curr] = true;
		// 다음 학생을 선택
		int next = pick[curr];
		// 이미 선택됨 = 팀을 이룬다!
		if (visited[next]) {
			// 새로운 팀이면 카운팅
			if (!checked[next]) {
				while (true) {
					ans++;
					if (next == curr) break;
					next = pick[next];
				}
			}
		}
		else {
			DFS(next);
		}
		checked[curr] = true;
	}

}
