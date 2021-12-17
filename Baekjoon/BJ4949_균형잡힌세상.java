package algorithm;

import java.io.*;
import java.util.*;

public class BJ4949_균형잡힌세상 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str;
		Stack<Character> stack = new Stack<Character>();
		char c;

		Loop: while (true) {
			// 문자열 입력 받기
			str = in.readLine();
			stack.clear();

			// .이 들어오면 입력 종료
			if (str.equals(".")) {
				break;
			}

			for (int i = 0; i < str.length(); i++) {
				c = str.charAt(i);

				switch (c) {
				case '(':
				case '[':
					stack.add(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.pop() != '(') {
						sb.append("no").append("\n");
						continue Loop;
					}
					break;
				case ']':
					if (stack.isEmpty() || stack.pop() != '[') {
						sb.append("no").append("\n");
						continue Loop;
					}
					break;
				}
			}

			// 균형 잡혀있는지 검사
			if (stack.isEmpty()) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}