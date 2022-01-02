package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int sum = 0, K = Integer.parseInt(in.readLine());

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < K; i++) {
			int x = Integer.parseInt(in.readLine());

			if (x == 0) {
				stack.pop();
			} else {
				stack.add(x);
			}
		}

		for (int x : stack) {
			sum += x;
		}

		System.out.println(sum);
	}

}