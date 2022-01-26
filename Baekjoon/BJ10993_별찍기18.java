package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	static int size[] = new int[11];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		// 배열의 크기 구하기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Math.pow(2, i);
			size[i + 1] = sum;
		}

		// 배열 만들고 별 찍기
		char map[][] = new char[sum][2 * sum - 1];
		for (int i = 0; i < sum; i++) {
			Arrays.fill(map[i], ' ');
		}

		star(map, N, 0, 0);

		// 완성한 별 출력하기
		if (N % 2 == 0) {
			for (int i = 0; i < sum; i++) {
				for (int j = 0; j < 2 * sum - 1 - i; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		} else {
			for (int i = 0; i < sum; i++) {
				for (int j = 0; j < sum + i; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static void star(char[][] map, int N, int i, int j) {
		// N이 1일 때
		if (N == 1) {
			map[i][j] = '*';
			return;
		}
		// N이 짝수일 때
		else if (N % 2 == 0) {
			int last = 2 * size[N] - 2;
			for (int k = 0; k < size[N]; k++) {
				map[i][j + k] = map[i][j + last - k] = '*';
				map[i + k][j + k] = map[i + k][j + last - k] = '*';
			}
			star(map, N - 1, i + 1, j + (int) Math.pow(2, N - 1));
		}
		// N이 홀수일 때
		else {
			int last = 2 * size[N] - 2;
			for (int k = 0; k < size[N]; k++) {
				map[i + size[N] - 1][j + k] = map[i + size[N] - 1][j + last - k] = '*';
				map[i + size[N] - k - 1][j + k] = map[i + size[N] - k - 1][j + last - k] = '*';
			}
			star(map, N - 1, i + (int) Math.pow(2, N - 1) - 1, j + (int) Math.pow(2, N - 1));
		}
	}

}