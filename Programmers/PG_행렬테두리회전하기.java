package week17;

import java.util.*;

public class PG_행렬테두리회전하기 {

	public static void main(String[] args) {
//		int rows = 6;
//		int columns = 6;
//		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
		int rows = 100;
		int columns = 97;
		int[][] queries = { { 1, 1, 100, 97 } };
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}

	static public int[] solution(int rows, int columns, int[][] queries) {
		int len = queries.length;
		int[] answer = new int[len];

		// 행렬의 숫자 값 셋팅
		int[][] map = new int[rows + 1][columns + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				map[i][j] = ((i - 1) * columns + j);
			}
		}

		// queries의 행의 개수만큼 회전
		for (int i = 0; i < len; i++) {
			answer[i] = rotate(map, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
		}

		return answer;
	}

	private static int rotate(int[][] map, int r1, int c1, int r2, int c2) {
		// 회전하는 숫자 저장할 큐
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		int temp = map[r1][c1];
		for (int i = r1; i < r2; i++) {
			map[i][c1] = map[i + 1][c1];
			queue.add(map[i][c1]);
		}
		for (int j = c1; j < c2; j++) {
			map[r2][j] = map[r2][j + 1];
			queue.add(map[r2][j]);
		}
		for (int i = r2; i > r1; i--) {
			map[i][c2] = map[i - 1][c2];
			queue.add(map[i][c2]);
		}
		for (int j = c2; j > c1 + 1; j--) {
			map[r1][j] = map[r1][j - 1];
			queue.add(map[r1][j]);
		}
		map[r1][c1 + 1] = temp;
		queue.add(temp);

		return queue.poll();
	}

}
