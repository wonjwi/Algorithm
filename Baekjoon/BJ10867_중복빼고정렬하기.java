package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		boolean checked[] = new boolean[2001];

		for (int i = 0; i < N; i++) {
			checked[Integer.parseInt(st.nextToken()) + 1000] = true;
		}

		for (int i = 0; i <= 2000; i++) {
			if (checked[i])
				sb.append(i - 1000).append(" ");
		}

		System.out.println(sb.toString());
	}

}