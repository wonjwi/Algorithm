package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = null;

		Loop: while (!(str = in.readLine()).equals("0")) {
			int left = 0, right = str.length() - 1;

			while (left < right) {
				if (str.charAt(left++) != str.charAt(right--)) {
					sb.append("no\n");
					continue Loop;
				}
			}

			sb.append("yes\n");
		}

		System.out.println(sb.toString());
	}

}