package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = in.readLine();
		int alphabet[] = new int[26];

		for (int i = 0; i < str.length(); i++) {
			alphabet[str.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			sb.append(alphabet[i]).append(" ");
		}

		System.out.println(sb.toString());
	}

}