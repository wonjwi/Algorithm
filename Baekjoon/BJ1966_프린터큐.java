package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.readLine());

			Queue<int[]> queue = new LinkedList<int[]>();
			int idx, value, answer = 1, cnt[] = new int[10];

			for (int i = 0; i < N; i++) {
				value = Integer.parseInt(st.nextToken());
				queue.add(new int[] { i, value });

				cnt[value]++;
			}

			findMax(cnt);

			while (!queue.isEmpty()) {
				idx = queue.peek()[0];
				value = queue.poll()[1];

				if (idx == M && value == max) {
					break;
				} else if (value == max) {
					cnt[max]--;
					answer++;

					if (cnt[max] == 0) {
						findMax(cnt);
					}
				} else {
					queue.add(new int[] { idx, value });
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void findMax(int[] cnt) {
		for (int i = 9; i >= 1; i--) {
			if (cnt[i] > 0) {
				max = i;
				return;
			}
		}
		return;
	}

}