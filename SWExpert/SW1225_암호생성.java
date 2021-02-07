package com.ssafy.algo;

import java.io.*;
import java.util.*;

/** 1225. [S/W 문제해결 기본] 7일차 - 암호생성기
 * 8개의 숫자를 입력 받고 주어진 조건에 따라 n개의 수를 처리해 8자리 암호 생성
 * 첫 번째 숫자를 N 감소한 뒤, 맨 뒤로 보내는 과정을 반복 (1<=N<=5)
 * 숫자가 감소할 때 0보다 작아지는 경우 0으로 유지하고, 프로그램 종료
 * 이 때의 8자리의 숫자 값을 구하는 프로그램을 작성하라.
 */
class SW1225_암호생성 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str = in.readLine()) != null) {
			// 테스트 케이스 번호
			int tc = Integer.parseInt(str);
			// 8개의 숫자 저장
			StringTokenizer st = new StringTokenizer(in.readLine());
			Queue<Integer> password = new LinkedList<Integer>();
			for (int i = 0; i < 8; i++) {
				password.add(Integer.parseInt(st.nextToken()));
			}
			boolean flag = true;
			int i = 0;
			while(flag) {
				// 첫 번째 수 꺼내서 감소시키기
				int temp = password.poll()-(++i);
				if (temp <= 0) {
					temp = 0;
					flag = false;
				}
				// 뒤로 보내기 (다시 삽입)
				password.add(temp);
				// 사이클 반복
				if (i == 5) i = 0;
			}
			System.out.print("#" + tc);
			while(!password.isEmpty()) {
				System.out.print(" "+password.poll());
			}
			System.out.println();
		}
	}
}