package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
	}

	private static int factorial(int n) {
		int answer = 1;

		for (int i = 2; i <= n; i++) {
			answer *= i;
		}

		return answer;
	}

}