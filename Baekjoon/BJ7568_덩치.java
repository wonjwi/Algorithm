package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int people[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if (people[j][0] - people[i][0] > 0 && people[j][1] - people[i][1] > 0) {
					cnt++;
				}
			}
			sb.append(cnt).append(" ");
		}

		System.out.println(sb.toString());
	}

}