package algorithm;

import java.io.*;
import java.util.*;

public class BJ10828_스택 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		String tmp;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			tmp = st.nextToken();

			if (tmp.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if (tmp.equals("pop")) {
				sb.append(stack.isEmpty() ? "-1" : stack.pop()).append("\n");
			} else if (tmp.equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if (tmp.equals("empty")) {
				sb.append(stack.isEmpty() ? "1" : "0").append("\n");
			} else if (tmp.equals("top")) {
				sb.append(stack.isEmpty() ? "-1" : stack.peek()).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}