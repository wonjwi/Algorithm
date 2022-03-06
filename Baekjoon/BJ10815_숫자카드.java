package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		boolean card[] = new boolean[20000001];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			card[Integer.parseInt(st.nextToken()) + 10000000] = true;
		}

		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(card[Integer.parseInt(st.nextToken()) + 10000000] ? 1 : 0).append(" ");
		}

		System.out.println(sb.toString());
	}

}