package week28;

import java.io.*;
import java.util.*;

public class BJ2210_숫자판점프 {

	static int dr[] = { 1, -1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int map[][] = new int[5][5];
		Set<Integer> set = new HashSet<Integer>();

		// 숫자판 데이터 입력
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 만들 수 있는 수들의 개수 구하기
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, map, 0, 0, set);
			}
		}

		// 구한 값 출력
		System.out.println(set.size());
	}

	private static void dfs(int r, int c, int[][] map, int cnt, int num, Set<Integer> set) {
		// 여섯 자리 수를 구하면 저장
		if (cnt == 6) {
			set.add(num);
			return;
		}
		
		// 인접한 네 방향으로 이동
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] < 0 || r + dr[i] >= 5 || c + dc[i] < 0 || c + dc[i] >= 5) continue;
			dfs(r + dr[i], c + dc[i], map, cnt + 1, num * 10 + map[r][c], set);
		}
	}

}
