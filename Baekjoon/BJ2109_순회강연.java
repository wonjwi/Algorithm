package week15;

import java.io.*;
import java.util.*;

public class BJ2109_순회강연 {
	
	static class Lecture implements Comparable<Lecture> {
		int d, p;
		public Lecture(int d, int p) {
			this.d = d;
			this.p = p;
		}
		@Override
		public int compareTo(Lecture o) {
			if (this.p == o.p) {
				return this.d-o.d;
			}
			return o.p-this.p;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n, d, p;
		n = Integer.parseInt(in.readLine());
		Queue<Lecture> queue = new PriorityQueue<Lecture>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			p = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			queue.add(new Lecture(d, p));
		}
		int money = 0;
		boolean selected[] = new boolean[10001];
		boolean flag;
		for (int i = 0; i < n; i++) {
			Lecture tmp = queue.poll();
			d = tmp.d;
			if (selected[d]) {
				flag = false;
				while (d > 1) {
					if (!selected[--d]) {
						flag = true; break;
					}
				}
				if (!flag) continue;
			}
			money += tmp.p;
			selected[d] = true;
		}
		System.out.println(money);
	}

}
