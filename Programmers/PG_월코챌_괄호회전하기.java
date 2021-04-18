package codingtest.programmers;

import java.util.Stack;

public class PG_월코챌_괄호회전하기 {
	
	public static void main(String[] args) {
		String s = "[)(]";
		int answer = 0;
		
		for (int i = 0, len = s.length(); i < len; i++) {
			if (isPossible(s)) answer++;
			char head = s.charAt(0);
			s = s.substring(1, len)+head;
		}
		
		System.out.println(answer);
	}

	private static boolean isPossible(String s) {
		Stack<Character> open = new Stack<Character>();
		for (int i = 0, len = s.length(); i < len; i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') open.add(s.charAt(i));
			if (s.charAt(i) == ')' && (open.isEmpty() || open.pop() != '(')) return false;
			else if (s.charAt(i) == ']' && (open.isEmpty() || open.pop() != '[')) return false;
			else if (s.charAt(i) == '}' && (open.isEmpty() || open.pop() != '{')) return false;
		}
		if (open.size() != 0) return false;
		return true;
	}

}
