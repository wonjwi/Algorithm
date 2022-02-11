package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String str = in.readLine();
		int N = Integer.parseInt(str);
		int X = N - str.length() * 9;

		while (++X <= N) {
			int sum = X;
			int tmp = X;

			while (tmp > 0) {
				sum += tmp % 10;
				tmp /= 10;
			}

			if (sum == N) {
				System.out.println(X);
				return;
			}
		}

		System.out.println(0);
	}

}