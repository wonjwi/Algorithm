package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int k, S[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(in.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;

			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}

			lotto(new int[6], new boolean[k], 0, 0);
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}

	private static void lotto(int[] result, boolean[] select, int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < k; i++) {
			if (select[i])
				continue;

			result[cnt] = S[i];
			select[i] = true;
			lotto(result, select, cnt + 1, i + 1);
			select[i] = false;
		}
	}

}