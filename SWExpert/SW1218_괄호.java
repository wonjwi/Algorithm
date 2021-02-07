package com.ssafy.algo;

import java.io.*;
import java.util.Stack;

/** 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
 * 4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어질 때
 * 이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하는 프로그램 작성
 */
class SW1218_괄호 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			// 테스트 케이스의 길이
			int N = Integer.parseInt(in.readLine());
			// 스택에 괄호 쌓기
			String str = in.readLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < N; i++) {
				stack.push(str.charAt(i));
			}
			// 괄호들의 짝이 맞는지 판별
			Stack<Character> temp = new Stack<>();
			boolean result = true;
			while(!stack.isEmpty()) {
				char s = stack.peek();
				char t = ' ';
				if (!temp.isEmpty()) {
					t = temp.peek();
				}
				if (s == ')' || s == ']' || s == '}' || s == '>') {
					temp.push(stack.pop());
				} else if ( (s == '(' && t == ')') || (s == '[' && t == ']') || 
						(s == '{' && t == '}') || (s == '<' && t == '>') ) {
					stack.pop();
					temp.pop();
				} else {
					result = false;
					break;
				}
			}
			// 임시 스택이 비어있지 않으면 안 된다.
			if (!temp.isEmpty()) result = false;
			// 해당 케이스의 유효성 여부를 출력
			System.out.println("#" + tc + " " + (result ? 1 : 0));
		}
	}
}