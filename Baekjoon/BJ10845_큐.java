package algorithm;

import java.io.*;
import java.util.*;

public class BJ10845_큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		LinkedList<Integer> q = new LinkedList<Integer>();
		String tmp;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			tmp = st.nextToken();

			if (tmp.equals("push")) {
				q.add(Integer.parseInt(st.nextToken()));
			} else if (tmp.equals("pop")) {
				sb.append(q.isEmpty() ? "-1" : q.pollFirst()).append("\n");
			} else if (tmp.equals("size")) {
				sb.append(q.size()).append("\n");
			} else if (tmp.equals("empty")) {
				sb.append(q.isEmpty() ? "1" : "0").append("\n");
			} else if (tmp.equals("front")) {
				sb.append(q.isEmpty() ? "-1" : q.peekFirst()).append("\n");
			} else if (tmp.equals("back")) {
				sb.append(q.isEmpty() ? "-1" : q.peekLast()).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}