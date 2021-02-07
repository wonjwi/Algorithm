package homework;

import java.io.*;
import java.util.*;

/** 1223. [S/W 문제해결 기본] 6일차 - 계산기2
 * 문자열로 이루어진 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램
 */
class SW1223_계산기2 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			String str = in.readLine();
			// 숫자와 기호를 후위 표기식으로 만든다.
			Queue<Character> post = new LinkedList<Character>();
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < N; i++) {
				char temp = str.charAt(i);
				// 숫자면 큐에 넣기
				if (temp >= 48 && temp <= 57) {
					post.add(temp);
				// 기호일 경우 조건에 따라 처리
				} else {
					// 스택이 비어있으면 스택에 넣기
					if (stack.isEmpty()) {
						stack.push(temp);
					// 스택이 비어있지 않으면 +, * 나눠서 생각
					} else {
						if (temp == '*') {
							if (stack.peek() == '*') {
								post.add(temp);								
							} else {
								stack.push(temp);
							}
						} else if (temp == '+') {
							if (stack.peek() == '*') {
								post.add(stack.pop());
								stack.push(temp);
							} else {
								post.add(temp);
							}
						}
					}
				}
			}
			// 스택에 남아있는 것 큐로 다 넣기
			while (!stack.isEmpty()) {
				post.add(stack.pop());
			}
			// 만들어진 후위 표기식을 계산한다.
			Stack<Integer> result = new Stack<Integer>();
			for (int i = 0; i < N; i++) {
				char temp = post.poll();
				// 숫자일 때와 기호일 때를 나눠서 처리
				if (temp == '+' || temp == '*') {
					int a = result.pop();
					int b = result.pop();
					result.push((temp == '+') ? a+b : a*b);
				} else {
					result.push(temp-48);
				}
			}
			sb.append(result.pop()).append("\n");
		}
		System.out.println(sb.toString());
	}
}