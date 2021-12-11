package algorithm;

import java.io.*;
import java.util.*;

public class BJ11650_좌표정렬하기 {

	static class Pos implements Comparable<Pos> {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pos o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		Queue<Pos> pq = new PriorityQueue<Pos>();
		int x, y;

		// 주어진 점들의 위치를 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			pq.add(new Pos(x, y));
		}

		// 주어진 조건대로 좌표 출력
		while (!pq.isEmpty()) {
			Pos pos = pq.poll();
			sb.append(pos.x).append(" ").append(pos.y).append("\n");
		}
		System.out.println(sb.toString());
	}

}