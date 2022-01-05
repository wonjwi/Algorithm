package week22;

import java.io.*;
import java.util.StringTokenizer;

public class BJ16198_에너지모으기 {

	static int N, weight[], max;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		weight = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());

		// 에너지 구슬의 무게 입력
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		// 모을 수 있는 최대 에너지 구하기
		energy(new boolean[N], 0, 0);

		System.out.println(max);
	}

	private static void energy(boolean[] selected, int cnt, int sum) {
		// 에너지 모으기가 끝나면 최댓값 갱신
		if (N - 2 == cnt) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 1; i < N - 1; i++) {
			if (selected[i])
				continue;

			// i번째 에너지 구슬을 제거한 경우
			selected[i] = true;
			energy(selected, cnt + 1, sum + find(selected, i));
			selected[i] = false;
		}
	}

	private static int find(boolean[] selected, int i) {
		int prev = i - 1, next = i + 1;

		while (selected[prev]) {
			prev--;
		}
		while (selected[next]) {
			next++;
		}

		return weight[prev] * weight[next];
	}

}
