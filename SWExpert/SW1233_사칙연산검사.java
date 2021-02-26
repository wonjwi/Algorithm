package com.ssafy.workshop;

import java.io.*;
import java.util.*;

//1233. [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
//사칙연산자과 양의 정수로만 구성된 임의의 이진 트리가 주어질 때, 유효성을 검사
//숫자 밑에는 아무것도 없어야 하고, 기호 밑에는 좌우 자식이 모두 있어야 한다.
class SW1233_사칙연산검사 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			// 트리가 갖는 정점의 총 수
			int N = Integer.parseInt(in.readLine());
			// 각각의 정점 정보 입력
			char[] tree = new char[N+1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				st.nextToken(); // 정점번호
				tree[i] = st.nextToken().charAt(0);
			}
			// 주어진 식의 유효성을 검사
			boolean result = isVallid(tree, N, 1);
			System.out.println("#" + tc + " " + (result ? 1 : 0));
		}
	}

	private static boolean isVallid(char[] tree, int N, int index) {
		char curr = tree[index];
		int left = 2*index;
		int right = 2*index+1;
		// 노드의 값이 연산자일 때
		if (curr < '0' || curr > '9') {
			// 왼쪽, 오른쪽 노드가 있어야 함
			if (left > N) return false;
			if (right > N) return false;
			// 왼쪽, 오른쪽 노드 탐색
			if (!isVallid(tree, N, left)) return false;
			if (!isVallid(tree, N, right)) return false;
		}
		// 노드의 값이 숫자일 때
		else {
			// 그 아래로 노드가 있으면 안 됨
			if (left <= N) return false;
			if (right <= N) return false;
		}
		return true;
	}
}

//-----------------------------------------------------------------------
//class SW1233_사칙연산검사 {
//	static int N;
//	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		for (int tc = 1; tc <= 10; tc++) {
//			boolean result = false;
//			// 트리가 갖는 정점의 총 수
//			N = Integer.parseInt(in.readLine());
//			// 각각의 정점 정보 입력
//			String[] tree = new String[N+1];
//			for (int i = 0; i < N; i++) {
//				StringTokenizer st = new StringTokenizer(in.readLine());
//				st.nextToken(); // 정점번호
//				tree[i] = st.nextToken();
//			}
//			// 주어진 식의 유효성을 검사
//			for (int i = 0; i < N; i++) {
//				char temp1 = tree[i].charAt(0);
//				if (temp1 < '0' || temp1 > '9') {
//					if (i*2+1 >= N) break;
//				} 
//				if (i == N-1) result = true;
//			}
//			System.out.println("#" + tc + " " + (result ? 1 : 0));
//		}
//	}
//}