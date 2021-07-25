package week19;

import java.io.*;
import java.util.*;

public class BJ1941_소문난칠공주 {

	static char map[];
	static int answer;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		map = new char[25];
		for (int i = 0; i < 5; i++) {
			String str = in.readLine();
			for (int j = 0; j < 5; j++) {
				map[i * 5 + j] = str.charAt(j);
			}
		}

		// 칠공주를 만들 수 있는 경우의 수 구하기
		DFS(new int[7], 0, 0, 0);
		System.out.println(answer);
	}

	private static void DFS(int[] select, int totalCnt, int yCnt, int start) {
		// 임도연파가 많아지면 중간에 종료
		if (yCnt >= 4) return;

		// 7명의 조합이 만들어지면 인접한지 확인
		if (totalCnt == 7) {
			if (check(select)) answer++;
			return;
		}

		for (int i = start; i < 25; i++) {
			select[totalCnt] = i;
			DFS(select, totalCnt + 1, yCnt + (map[i] == 'Y' ? 1 : 0), i + 1);
		}
	}

	private static boolean check(int[] select) {
		boolean visited[] = new boolean[7];
		int curr, next, r, c, cnt = 1;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(select[0]);
		visited[0] = true;

		while (!queue.isEmpty()) {
			// 현재 위치에서 상하좌우 탐색
			curr = queue.poll();
			for (int d = 0; d < 4; d++) {
				r = curr / 5 + dr[d];
				c = curr % 5 + dc[d];
				if (r < 0 || r >= 5 || c < 0 || c >= 5) continue;
				next = r * 5 + c;
				
				for (int j = 1; j < 7; j++) {
					if (visited[j]) continue;
					// 뽑힌 리스트에 있다면 큐에 넣기
					if (select[j] == next) {
						cnt++;
						queue.add(select[j]);
						visited[j] = true;
						break;
					}
				}
			}
		}

		if (cnt == 7) return true;
		return false;
	}

}
