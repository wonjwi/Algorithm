package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String octal = in.readLine();
		String binary[] = { "000", "001", "010", "011", "100", "101", "110", "111" };
		String firstBinary[] = { "0", "1", "10", "11", "100", "101", "110", "111" };

		sb.append(firstBinary[octal.charAt(0) - '0']);
		for (int i = 1; i < octal.length(); i++) {
			sb.append(binary[octal.charAt(i) - '0']);
		}

		System.out.println(sb.toString());
	}

}