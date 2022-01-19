package week29;

import java.io.*;
import java.util.*;

public class BJ18234_당근훔쳐먹기 {

	static class Carrot implements Comparable<Carrot> {
		int w, p;

		public Carrot(int w, int p) {
			this.w = w;
			this.p = p;
		}

		@Override
		public int compareTo(Carrot o) {
			if (this.p == o.p) {
				return o.w - this.w;
			}
			return o.p - this.p;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		Queue<Carrot> pq = new PriorityQueue<Carrot>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());

			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			pq.add(new Carrot(w, p));
		}

		long answer = 0;

		for (int i = 0; i < N; i++) {
			Carrot tmp = pq.poll();

			answer += tmp.w + (long) tmp.p * --T;
		}

		System.out.println(answer);
	}

}