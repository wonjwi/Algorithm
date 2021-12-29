package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static int answer = Integer.MAX_VALUE;
	static boolean isBreak[] = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine()); // 목표 채널
		int M = Integer.parseInt(in.readLine()); // 고장난 버튼 개수

		if (M > 0) {
			st = new StringTokenizer(in.readLine());
		}
		for (int i = 0; i < M; i++) {
			isBreak[Integer.parseInt(st.nextToken())] = true;
		}

		pressButton(N, 100, 0);

		// 채널 N으로 이동하기 위해 눌러야 하는 버튼 횟수
		System.out.println(answer);
	}

	private static void pressButton(int N, int curr, int cnt) {
		answer = Math.min(answer, cnt + Math.abs(N - curr));

		// 채널은 50만까지이므로 6자리까지만 시도
		if (cnt == 6 || N == curr) {
			return;
		}

		// 0부터 9까지 가능한 버튼 다 눌러보기
		for (int i = 0; i <= 9; i++) {
			if (isBreak[i])
				continue;

			if (cnt == 0) {
				pressButton(N, i, cnt + 1);
			} else {
				pressButton(N, curr * 10 + i, cnt + 1);
			}
		}
	}

}