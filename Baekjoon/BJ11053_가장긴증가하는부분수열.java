package algorithm;

import java.io.*;
import java.util.*;

public class BJ11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		int A[] = new int[N + 1];

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int dp[] = new int[N + 1];
		int max, answer = 1;

		for (int i = 1; i <= N; i++) {
			max = 0;
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}

}