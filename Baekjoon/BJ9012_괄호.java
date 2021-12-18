package algorithm;

import java.io.*;
import java.util.*;

public class BJ9012_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		String str;
		Stack<Character> stack = new Stack<Character>();
		char c;
		
		Loop: for (int tc = 0; tc < T; tc++) {
			// 문자열 입력 받기
			str = in.readLine();
			stack.clear();

			for (int i = 0; i < str.length(); i++) {
				c = str.charAt(i);

				switch (c) {
				case '(':
					stack.add(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != '(') {
						sb.append("NO").append("\n");
						continue Loop;	
					}
					break;
				}
			}

			// 균형 잡혀있는지 검사
			if (stack.isEmpty()) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}