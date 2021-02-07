package com.ssafy.algo;

import java.io.*;
import java.util.*;

/** 3499. 퍼펙트 셔플
 *  카드 덱을 절반으로 나누고 나눈 것들에서 교대로 카드를 뽑아 새로운 덱 만들기
 *  N개의 카드가 있는 덱을 퍼펙트 셔플하면 어떤 순서가 되는지 출력하는 프로그램을 작성
 *  만약 N이 홀수이면, 먼저 놓는 쪽에 한 장이 더 들어가게 한다.
 */
class SW3499_퍼펙트셔플 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			String[] card = new String[N];
			int N2 = (N%2 == 0) ? N/2 : N/2+1;
			for (int i = 0; i < N2; i++) {
				card[2*i] = st.nextToken();
			}
			for (int i = 0; i < N/2; i++) {
				card[2*i+1] = st.nextToken();
			}
			for (int i = 0; i < N; i++) {
				sb.append(card[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}