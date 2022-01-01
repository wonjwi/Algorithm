package boj.contest;

import java.io.*;

public class goodbye2021_a {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 소수 미리 구하기
		boolean isNotPrime[] = new boolean[20001];
		isNotPrime[0] = isNotPrime[1] = true;

		for (int i = 2; i <= 200; i++) {
			for (int j = i + i; j <= 20000; j += i) {
				isNotPrime[j] = true;
			}
		}

		int N = Integer.parseInt(in.readLine());
		int answer = Integer.MAX_VALUE;

		for (int a = 2; a <= 200; a++) {
			if (isNotPrime[a])
				continue;
			for (int b = a + 1; b <= 200; b++) {
				if (isNotPrime[b]) {
					continue;
				} else {
					if (a * b > N) {
						answer = Math.min(answer, a * b);
					}
					break;
				}
			}
		}

		System.out.println(answer);
	}

}