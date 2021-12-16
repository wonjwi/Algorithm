package algorithm;

import java.io.*;
import java.util.*;

public class BJ1929_소수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int sqrtN = (int) Math.sqrt(N);

		boolean isNotPrime[] = new boolean[10000001];
		isNotPrime[0] = isNotPrime[1] = true;

		for (int i = 2; i <= sqrtN; i++) {
			for (int j = i + i; j <= N; j += i) {
				isNotPrime[j] = true;
			}
		}

		for (int i = M; i <= N; i++) {
			if (!isNotPrime[i]) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}