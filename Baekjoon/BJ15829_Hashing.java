package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(in.readLine());
		String str = in.readLine();

		long pow[] = new long[L];
		pow[0] = 1;
		for (int i = 1; i < L; i++) {
			pow[i] = pow[i - 1] * 31;
			pow[i] %= 1234567891;
		}

		long answer = 0;
		for (int i = 0; i < L; i++) {
			int alpha = str.charAt(i) - 'a' + 1;

			answer += alpha * pow[i];
			answer %= 1234567891;
		}

		System.out.println(answer);
	}

}