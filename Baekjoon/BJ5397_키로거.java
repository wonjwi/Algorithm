package week16;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class BJ5397_키로거 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		String str = null;
		int len, cursor;
		List<Character> pwd = new LinkedList<Character>();
		for (int i = 0; i < T; i++) {
			pwd.clear();
			cursor = 0;
			str = in.readLine();
			len = str.length();
			for (int j = 0; j < len; j++) {
				char c = str.charAt(j);
				if (c == '-') {
					if (cursor == 0) continue;
					pwd.remove(--cursor);
				} else if (c == '>') {
					if (cursor == pwd.size()) continue;
					cursor++;
				} else if (c == '<') {
					if (cursor == 0) continue;
					cursor--;
				} else {
					pwd.add(cursor++, c);
				}
			}
			for (char c : pwd) {
				sb.append(c);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
