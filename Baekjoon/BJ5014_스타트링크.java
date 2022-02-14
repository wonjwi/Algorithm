package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static class Floor implements Comparable<Floor> {
		int floor, cnt;

		public Floor(int floor, int cnt) {
			this.floor = floor;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Floor o) {
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		Queue<Floor> pq = new PriorityQueue<Floor>();
		pq.add(new Floor(S, 0));

		boolean visited[] = new boolean[F + 1];
		visited[S] = true;

		while (!pq.isEmpty()) {
			Floor tmp = pq.poll();

			if (tmp.floor == G) {
				System.out.println(tmp.cnt);
				return;
			}

			if (tmp.floor + U <= F && !visited[tmp.floor + U]) {
				pq.add(new Floor(tmp.floor + U, tmp.cnt + 1));
				visited[tmp.floor+U] = true;
			}
			if (tmp.floor - D >= 1 && !visited[tmp.floor - D]) {
				pq.add(new Floor(tmp.floor - D, tmp.cnt + 1));
				visited[tmp.floor - D] = true;
			}
		}

		System.out.println("use the stairs");
	}

}