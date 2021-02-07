package algostudy;

import java.io.*;
import java.util.*;

/** 1918. 후위 표기식
 * 중위 표기식이 주어졌을 때 후위 표기식으로 고치는 프로그램
 */
public class BJ1918_후위표기식 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] infix = in.readLine().toCharArray(); // 중위 표기식
		StringBuilder postfix = new StringBuilder(); // 후위 표기식
		int num = 0; // 닫히지 않은 괄호 개수
		List<Stack<Character>> sign = new ArrayList<Stack<Character>>();
		sign.add(new Stack<Character>());
		for (int i = 0; i < infix.length; i++) {
			char temp = infix[i];
			switch (temp) {
			case '+':
			case '-':
				if (!sign.get(num).isEmpty()) 
					postfix.append(sign.get(num).pop());
				if (!sign.get(num).isEmpty() && (sign.get(num).peek() == '+' || sign.get(num).peek() == '-'))
					postfix.append(sign.get(num).pop());
				sign.get(num).push(temp);
				break;
			case '*':
			case '/':
				if (!sign.get(num).isEmpty() && (sign.get(num).peek() == '*' || sign.get(num).peek() == '/')) 
					postfix.append(sign.get(num).pop());
				sign.get(num).push(temp);
				break;
			case '(':
				num++;
				sign.add(new Stack<Character>());
				break;
			case ')':
				while (!sign.get(num).isEmpty()) {
					postfix.append(sign.get(num).pop());
				}
				num--;
				break;
			default:
				postfix.append(temp);
			}
		}
		while (!sign.get(num).isEmpty()) {
			postfix.append(sign.get(num).pop());
		}
		System.out.println(postfix.toString());
	}
}

//public class BJ1918_후위표기식 {
//public static void main(String[] args) throws Exception {
//	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	char[] infix = in.readLine().toCharArray(); // 중위 표기식
//	// 후위 표기식 만들기
//	StringBuilder sb = new StringBuilder();
//	Stack<Character> sign = new Stack<Character>();
//	for (int i = 0; i < infix.length; i++) {
//		char temp = infix[i];
//		switch (temp) {
//		case '+':
//		case '-':
//			if (!sign.isEmpty() && sign.peek() != '(') 
//				sb.append(sign.pop());
//			if (!sign.isEmpty() && (sign.peek() == '+' || sign.peek() == '-'))
//				sb.append(sign.pop());
//			sign.push(temp);
//			break;
//		case '*':
//		case '/':
//			if (!sign.isEmpty() && (sign.peek() == '*' || sign.peek() == '/')) 
//				sb.append(sign.pop());
//			sign.push(temp);
//			break;
//		case '(':
//			sign.push(temp);
//			break;
//		case ')':
//			while (!sign.isEmpty()) {
//				if (sign.peek() == '(') {
//					sign.pop();
//					break;
//				}
//				sb.append(sign.pop());
//			}
//			break;
//		default:
//			sb.append(temp);
//		}
//	}
//	while (!sign.isEmpty()) {
//		sb.append(sign.pop());
//	}
//	System.out.println(sb.toString());
//}
//}