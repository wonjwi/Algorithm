package algostudy;

import java.io.*;
import java.util.*;

/** 1935. 후위 표기식2
 * 후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산
 */
public class BJ1935_후위표기식2 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String postfix = in.readLine(); // 후위 표기식
		// A부터 N개의 피연산자에 대응하는 값
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		// 후위 표기식 계산
		Stack<Double> stack = new Stack<Double>();
		for (int i = 0; i < postfix.length(); i++) {
			char temp = postfix.charAt(i);
			if (temp >= 'A' && temp <= 'Z') {
				stack.push((double)num[temp-'A']);
			} else {
				double b = stack.pop();
				double a = stack.pop();
				switch (temp) {
				case '+':
					stack.push(a + b);
					break;
				case '-':
					stack.push(a - b);
					break;
				case '*':
					stack.push(a * b);
					break;
				case '/':
					stack.push(a / b);
					break;
				}
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}