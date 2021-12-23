package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		LinkedList<Integer> deque = new LinkedList<Integer>();
		String tmp;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			tmp = st.nextToken();

			if (tmp.equals("push_front")) {
				deque.addFirst(Integer.parseInt(st.nextToken()));
			} else if (tmp.equals("push_back")) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			} else if (tmp.equals("pop_front")) {
				sb.append(deque.isEmpty() ? "-1" : deque.pollFirst()).append("\n");
			} else if (tmp.equals("pop_back")) {
				sb.append(deque.isEmpty() ? "-1" : deque.pollLast()).append("\n");
			} else if (tmp.equals("size")) {
				sb.append(deque.size()).append("\n");
			} else if (tmp.equals("empty")) {
				sb.append(deque.isEmpty() ? "1" : "0").append("\n");
			} else if (tmp.equals("front")) {
				sb.append(deque.isEmpty() ? "-1" : deque.peekFirst()).append("\n");
			} else if (tmp.equals("back")) {
				sb.append(deque.isEmpty() ? "-1" : deque.peekLast()).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}