package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String binary = in.readLine();
		int len = binary.length(), mod = len % 3;

		if (mod == 2) {
			sb.append((binary.charAt(0) - '0') * 2 + (binary.charAt(1) - '0'));
		} else if (mod == 1) {
			sb.append((binary.charAt(0) - '0'));
		}

		for (int i = mod; i < len - 2; i += 3) {
			sb.append((binary.charAt(i) - '0') * 4 + (binary.charAt(i + 1) - '0') * 2 + (binary.charAt(i + 2) - '0'));
		}

		System.out.println(sb.toString());
	}

}