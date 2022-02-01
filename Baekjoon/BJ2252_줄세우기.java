package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int front[] = new int[N + 1];
		List<Integer> back[] = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			back[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			front[B]++;
			back[A].add(B);
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (front[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int i = queue.poll();

			sb.append(i).append(" ");

			for (int k : back[i]) {
				if (--front[k] == 0) {
					queue.add(k);
				}
			}
		}

		System.out.println(sb.toString());
	}

}