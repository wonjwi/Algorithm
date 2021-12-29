package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수빈 위치
		int K = Integer.parseInt(st.nextToken()); // 동생 위치
		int X, visited[] = new int[100001];

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		visited[N] = 1;

		while (!queue.isEmpty()) {
			X = queue.poll();

			// 동생을 만나면 종료
			if (X == K) {
				System.out.println(visited[X] - 1);
				break;
			}

			// 순간이동 또는 걷기
			if (X * 2 <= 100000 && visited[X * 2] == 0) {
				visited[X * 2] = visited[X] + 1;
				queue.add(X * 2);
			}
			if (X + 1 <= 100000 && visited[X + 1] == 0) {
				visited[X + 1] = visited[X] + 1;
				queue.add(X + 1);
			}
			if (X > 0 && visited[X - 1] == 0) {
				visited[X - 1] = visited[X] + 1;
				queue.add(X - 1);
			}
		}
	}

}