package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static class Beer implements Comparable<Beer> {
		int like, level;

		public Beer(int like, int level) {
			this.like = like;
			this.level = level;
		}

		@Override
		public int compareTo(Beer o) {
			if (this.level < o.level) {
				return -1;
			} else if (this.level == o.level && this.like > o.like) {
				return -1;
			}
			return 1;
		}
	}

	static class Drink implements Comparable<Drink> {
		int like, level;

		public Drink(int like, int level) {
			this.like = like;
			this.level = level;
		}

		@Override
		public int compareTo(Drink o) {
			return this.like - o.like;
		}
	}

	static int N, M, K, answer;
	static Queue<Beer> beer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		beer = new PriorityQueue<Beer>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());

			beer.add(new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		festival();

		System.out.println(answer == 0 ? "-1" : answer);
	}

	private static void festival() {
		int sum = 0, max = 0;

		Queue<Drink> pq = new PriorityQueue<Drink>();

		for (int i = 0; i < N; i++) {
			int like = beer.peek().like;
			int level = beer.poll().level;

			sum += like;
			max = Math.max(max, level);

			pq.add(new Drink(like, level));
		}

		while (true) {
			if (sum >= M) {
				answer = max;
				break;
			}

			if (beer.isEmpty())
				break;

			sum -= pq.poll().like;

			int like = beer.peek().like;
			int level = beer.poll().level;

			sum += like;
			max = Math.max(max, level);

			pq.add(new Drink(like, level));
		}
	}

}