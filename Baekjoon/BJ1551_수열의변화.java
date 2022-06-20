package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int num[] = new int[N];

		st = new StringTokenizer(in.readLine(), ",");

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int k = 0; k < K; k++) {
			for (int i = 1; i < N - k; i++) {
				num[i - 1] = num[i] - num[i - 1];
			}
		}

		for (int i = 0; i < N - K; i++) {
			sb.append(num[i]).append(",");
		}
		sb.setLength(sb.length() - 1);

		System.out.println(sb.toString());
	}

}