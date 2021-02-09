package com.ssafy.algo;

import java.io.*;
import java.util.*;

//1233. [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
//사칙연산자과 양의 정수로만 구성된 임의의 이진 트리가 주어질 때, 유효성을 검사
class SW1233_사칙연산검사 {
	static int N;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			boolean result = false;
			// 트리가 갖는 정점의 총 수
			N = Integer.parseInt(in.readLine());
			// 각각의 정점 정보 입력
			String[] tree = new String[N+1];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				st.nextToken(); // 정점번호
				tree[i] = st.nextToken();
			}
			// 주어진 식의 유효성을 검사
			for (int i = 0; i < N; i++) {
				char temp1 = tree[i].charAt(0);
				if (temp1 < '0' || temp1 > '9') {
					if (i*2+1 >= N) break;
				} 
				if (i == N-1) result = true;
			}
			System.out.println("#" + tc + " " + (result ? 1 : 0));
		}
	}
}