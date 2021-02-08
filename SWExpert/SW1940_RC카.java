package com.ssafy.add;

import java.io.*;
import java.util.StringTokenizer;

/** 1940. 가랏! RC카!
 * N개의 command 를 모두 수행했을 때, N초 동안 이동한 거리를 구하라.
 */
class SW1940_RC카 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int totalDistance = 0; // 이동거리
			int speed = 0; // 현재 속력 (초기 값 0)
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int command = Integer.parseInt(st.nextToken());
				if (command != 0) {
					int change = Integer.parseInt(st.nextToken());
					// 명령이 1이면 입력 값만큼 가속, 2면 감속한다.
					if (command == 1) speed += change;
					// 현재 속도보다 감속할 속도가 더 크면 속도는 0이 된다.
					else speed = speed > change ? speed-change : 0;
				}
				totalDistance += speed;
			}
			result.append("#").append(tc).append(" ").append(totalDistance).append("\n");
		}
		System.out.println(result);
	}
}
