package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static class Pos implements Comparable<Pos> {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pos o) {
			if (this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int x, y;

		PriorityQueue<Pos> pq = new PriorityQueue<Pos>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			pq.add(new Pos(x, y));
		}

		while (!pq.isEmpty()) {
			Pos tmp = pq.poll();

			sb.append(tmp.x).append(" ").append(tmp.y).append("\n");
		}

		System.out.println(sb.toString());
	}

}