package week11;

import java.io.*;
import java.util.StringTokenizer;

public class BJ3980_선발명단 {
	
	static int[][] ability = new int[11][11];
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int C = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < C; tc++) {
			// i번 선수가 j번 포지션에서 뛸 때의 능력
			// 모든 선수에게 적합한 포지션의 수는 최대 5개
			for (int i = 0; i < 11; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 11; j++) {
					ability[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			// 선수들을 각 포지션에 배치했을 때, 능력치 합의 최댓값
			select(new boolean[11], 0, 0);
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void select(boolean[] selected, int cnt, int sum) {
		// 모든 포지션의 배치가 끝남
		if (cnt == 11) {
			answer = Math.max(answer, sum);
			return;
		}
		// 각 포지션마다 선수 배치
		for (int i = 0; i < 11; i++) {
			if (selected[i] || ability[i][cnt] == 0) continue;
			selected[i] = true;
			select(selected, cnt+1, sum+ability[i][cnt]);
			selected[i] = false;
		}
	}

}
