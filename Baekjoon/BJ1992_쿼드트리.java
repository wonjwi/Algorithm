package com.ssafy.homework;

import java.io.*;

/**
 * 1992. 쿼드트리
 * 주어진 영상이 모두 0이면 "0"으로, 모두 1이면 "1"으로 압축
 * 0과 1이 섞여 있으면, 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래으로 나누어 압축
 * 4개의 영역을 압축한 결과를 차례대로 괄호 안에 묶어서 표현하라.
 */
public class BJ1992_쿼드트리 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 영상의 크기
		// 영상 입력 받기
		boolean[][] image = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++)
				if (str.charAt(j) == '1') image[i][j] = true;
		}
		// 쿼드트리 만들기
		makeQuadTree(image, N, 0, 0);
		System.out.println(sb.toString());
	}

	private static void makeQuadTree(boolean[][] image, int N, int r, int c) {
		boolean temp = image[r][c];
		boolean flag = true;
		Loop:
		for (int i = r; i < r+N; i++) {
			for (int j = c; j < c+N; j++) {
				if (temp != image[i][j]) {
					flag = false;
					break Loop;
				}
			}
		}
		// 영상이 모두 일치하면 하나만 출력
		if (flag) {
			sb.append(temp ? '1' : '0');
		}
		// 영상이 일치하지 않으면 쪼개서 다시 탐색
		else {
			sb.append('(');
			makeQuadTree(image, N/2, r, c);
			makeQuadTree(image, N/2, r, c+N/2);
			makeQuadTree(image, N/2, r+N/2, c);
			makeQuadTree(image, N/2, r+N/2, c+N/2);
			sb.append(')');
		}
	}
}