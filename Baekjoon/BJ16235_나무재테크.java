package week23;

import java.io.*;
import java.util.*;

public class BJ16235_나무재테크 {

	static class Tree implements Comparable<Tree> {
		int r, c, age;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			// 나이가 어린 나무부터
			return this.age - o.age;
		}
	}

	static int N, M, K, A[][], map[][], dead[][];
	static PriorityQueue<Tree> tree = new PriorityQueue<Tree>();
	static PriorityQueue<Tree> next = new PriorityQueue<Tree>();
	static int dr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int dc[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		map = new int[N][N];
		dead = new int[N][N];
		int r, c, age;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				// 처음에 들어있는 양분 셋팅
				map[i][j] = 5;
				// 겨울에 추가될 양분의 양 입력
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 상도가 심은 나무의 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			age = Integer.parseInt(st.nextToken());
			tree.add(new Tree(r, c, age));
		}

		// K년동안 사계절을 반복
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}

		// 살아남은 나무의 수 출력
		System.out.println(tree.size());
	}

	private static void spring() {
		int r, c, age;

		while (!tree.isEmpty()) {
			Tree tmp = tree.poll();
			r = tmp.r;
			c = tmp.c;
			age = tmp.age;

			// 자신의 나이만큼 양분을 먹음
			if (age <= map[r][c]) {
				map[r][c] -= age;
				next.add(new Tree(r, c, age + 1));
			}
			// 양분을 먹을 수 없으면 죽음
			else {
				dead[r][c] += age / 2;
			}
		}
	}

	private static void summer() {
		// 죽은 나무를 양분으로 추가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += dead[i][j];
				dead[i][j] = 0;
			}
		}
	}

	private static void fall() {
		int r, c, age, row, col;

		while (!next.isEmpty()) {
			Tree tmp = next.poll();
			r = tmp.r;
			c = tmp.c;
			age = tmp.age;

			tree.add(new Tree(r, c, age));

			// 나이가 5의 배수인 나무는 인접한 곳으로 번식
			if (age % 5 == 0) {
				for (int d = 0; d < 8; d++) {
					row = r + dr[d];
					col = c + dc[d];
					
					if (row < 0 || row >= N || col < 0 || col >= N) continue;

					tree.add(new Tree(row, col, 1));
				}
			}
		}
	}

	private static void winter() {
		// S2D2가 땅에 양분을 추가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += A[i][j];
			}
		}
	}
}
