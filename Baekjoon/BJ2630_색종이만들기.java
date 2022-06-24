package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static int white, blue;
	static boolean map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		map = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0) == '1';
			}
		}
		makeColorPaper(N, 0, 0);
		System.out.println(white + "\n" + blue);
	}

	private static void makeColorPaper(int N, int r, int c) {
		boolean tmp = map[r][c];
		boolean flag = true;
		Loop: for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (tmp != map[i][j]) {
					flag = false;
					break Loop;
				}
			}
		}
		// 모두 같은 색깔의 영역일 경우
		if (flag) {
			if (tmp) {
				blue++;
			} else {
				white++;
			}
		} else {
			// 그렇지 않으면 쪼개서 다시 탐색
			makeColorPaper(N / 2, r, c);
			makeColorPaper(N / 2, r, c + N / 2);
			makeColorPaper(N / 2, r + N / 2, c);
			makeColorPaper(N / 2, r + N / 2, c + N / 2);
		}
	}

}