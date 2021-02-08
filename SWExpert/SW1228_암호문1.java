package com.ssafy.algo;

import java.io.*;
import java.util.*;

/** 1228. [S/W 문제해결 기본] 8일차 - 암호문1
 * 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 
 * 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하라.
 */
public class SW1228_암호문1 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			// 원본 암호문 데이터 입력
			int N = Integer.parseInt(in.readLine()); // 원본 암호문의 길이
			List<Integer> password = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				password.add(Integer.parseInt(st.nextToken()));
			}
			int C = Integer.parseInt(in.readLine()); // 명령어의 개수
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < C; i++) {
				st.nextToken(); // 삽입 명령어 버림
				int x = Integer.parseInt(st.nextToken()); // 삽입할 위치
				int y = Integer.parseInt(st.nextToken()); // 삽입할 숫자들
				for (int j = 0; j < y; j++) {
					if (x+j > 10) st.nextToken();
					else password.add(x+j, Integer.parseInt(st.nextToken()));
				}
			}
			result.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				result.append(password.get(i)).append(" ");
			}
			result.append("\n");
		}
		System.out.println(result);
	}
}