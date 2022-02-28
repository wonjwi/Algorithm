package algorithm;

import java.io.*;
import java.util.*;

public class BJ2644_촌수계산 {

	static List<Integer> family[];
	static boolean visited[];
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(in.readLine());

		family = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			family[i] = new ArrayList<>();
		}
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken()); // 부모
			int y = Integer.parseInt(st.nextToken()); // 자식
			family[y].add(x);
			family[x].add(y);
		}

		find(a, b, 0);
		System.out.println(answer);
	}

	private static void find(int a, int b, int cnt) {
		if (a == b) {
			answer = cnt;
			return;
		}

		visited[a] = true;

		for (int i : family[a]) {
			if (!visited[i]) {
				find(i, b, cnt + 1);
			}
		}
	}

}

//public class BJ2644_촌수계산 {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//
//		int n = Integer.parseInt(in.readLine());
//		st = new StringTokenizer(in.readLine());
//		int a = Integer.parseInt(st.nextToken());
//		int b = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(in.readLine());
//
//		int parent[] = new int[n + 1];
//
//		for (int i = 0; i < m; i++) {
//			st = new StringTokenizer(in.readLine());
//			int x = Integer.parseInt(st.nextToken()); // 부모
//			int y = Integer.parseInt(st.nextToken()); // 자식
//			parent[y] = x;
//		}
//
//		Queue<int[]> queue = new LinkedList<>();
//		queue.add(new int[] { a, b, 0 });
//
//		while (!queue.isEmpty()) {
//			int tmp[] = queue.poll();
//
//			if (tmp[0] == tmp[1]) {
//				System.out.println(tmp[2]);
//				return;
//			}
//
//			if (parent[tmp[0]] != 0) {
//				queue.add(new int[] { parent[tmp[0]], tmp[1], tmp[2] + 1 });
//			}
//			if (parent[tmp[1]] != 0) {
//				queue.add(new int[] { tmp[0], parent[tmp[1]], tmp[2] + 1 });
//			}
//		}
//
//		System.out.println(-1);
//	}
//
//}