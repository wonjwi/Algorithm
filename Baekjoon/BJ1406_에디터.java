package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		String str = in.readLine(); // 초기 문자열
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		int N = str.length();
		int M = Integer.parseInt(in.readLine());

		for (int i = 0; i < N; i++) {
			left.add(str.charAt(i));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			char c = st.nextToken().charAt(0);

			switch (c) {
			// 커서를 왼쪽으로 한 칸 옮김
			case 'L':
				if (left.size() == 0)
					continue;
				right.add(left.pop());
				break;
			// 커서를 오른쪽으로 한 칸 옮김
			case 'D':
				if (right.size() == 0)
					continue;
				left.add(right.pop());
				break;
			case 'B':
				if (left.size() == 0)
					continue;
				left.pop();
				break;
			case 'P':
				left.add(st.nextToken().charAt(0));
				break;
			}
		}

		// 편집기에 남아있는 문자열 출력
		while (!left.isEmpty()) {
			right.add(left.pop());
		}

		while (!right.isEmpty()) {
			sb.append(right.pop());
		}

		System.out.println(sb.toString());
	}

}