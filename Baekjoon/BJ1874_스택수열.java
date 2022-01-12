package algorithm;

import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(in.readLine());
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		Stack<Integer> stack = new Stack<Integer>();
		int idx = 0, num = 0;

		while (idx < n) {
			if (stack.isEmpty()) {
				stack.add(++num);
				sb.append("+\n");
			} else if (arr[idx] == stack.peek()) {
				stack.pop();
				sb.append("-\n");
				idx++;
			} else {
				stack.add(++num);
				sb.append("+\n");
			}

			if (num > n) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println(sb.toString());
	}

}