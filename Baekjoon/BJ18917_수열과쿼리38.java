package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(in.readLine());
		long sum = 0, xor = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());

			char c = st.nextToken().charAt(0);
			int x = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

			switch (c) {
			case '1':
				sum += x;
				xor ^= x;
				break;
			case '2':
				sum -= x;
				xor ^= x;
				break;
			case '3':
				sb.append(sum).append("\n");
				break;
			case '4':
				sb.append(xor).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}

}