package boj.contest;

import java.io.*;
import java.util.HashMap;

public class goodbye2021_b {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		long N;

		HashMap<Long, Boolean> map = new HashMap<Long, Boolean>();

		for (int tc = 0; tc < T; tc++) {
			N = Long.parseLong(in.readLine());

			sb.append(N % 3 == 2 || N % 9 == 0 ? "TAK" : "NIE").append("\n");
		}

		System.out.println(sb.toString());
	}

}