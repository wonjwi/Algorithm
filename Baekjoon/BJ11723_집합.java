package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(in.readLine());
		boolean num[] = new boolean[21];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());

			switch (st.nextToken()) {
			case "add":
				num[Integer.parseInt(st.nextToken())] = true;
				break;
			case "remove":
				num[Integer.parseInt(st.nextToken())] = false;
				break;
			case "check":
				sb.append(num[Integer.parseInt(st.nextToken())] ? 1 : 0).append("\n");
				break;
			case "toggle":
				int x = Integer.parseInt(st.nextToken());
				num[x] = !num[x];
				break;
			case "all":
				for (int j = 1; j <= 20; j++) {
					num[j] = true;
				}
				break;
			case "empty":
				for (int j = 1; j <= 20; j++) {
					num[j] = false;
				}
				break;
			}
		}

		System.out.println(sb.toString());
	}

}