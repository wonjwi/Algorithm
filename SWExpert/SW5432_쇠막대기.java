package com.ssafy.add;

import java.io.*;

/** 5432. 쇠막대기 자르기
 * 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 
 * 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하라.
 */
class SW5432_쇠막대기 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 쇠막대기와 레이저 배치 입력
			String str = in.readLine().replace("()", "*");
			// 한 글자씩 탐색
			int total = 0, cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == ')') {
					cnt--;
					total++;
				} else if (ch == '(') {
					cnt++;
				} else if (ch == '*') {
					total += cnt;
				}
			}
			// 잘려진 조각의 총 개수를 출력
			System.out.println("#" + tc + " " + total);
		}
	}
}

//========================================================================

//class SW5432_쇠막대기 {
//	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= T; tc++) {
//			// 쇠막대기와 레이저 배치 입력
//			String str = in.readLine();
//			// 한 글자씩 탐색
//			int total = 0, cnt = 0;
//			for (int i = 0; i < str.length(); i++) {
//				char ch = str.charAt(i);
//				if (ch == ')') {
//					if (str.charAt(i-1) == '(') {
//						cnt--;
//						total += cnt;
//					} else if (str.charAt(i-1) == ')') {
//						cnt--;
//						total++;
//					}
//				} else if (ch == '(') {
//					cnt++;
//				}
//			}
//			// 잘려진 조각의 총 개수를 출력
//			System.out.println("#" + tc + " " + total);
//		}
//	}
//}

//========================================================================

//class SW5432_쇠막대기 {
//	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= T; tc++) {
//			// 쇠막대기와 레이저 배치 입력
//			String str = in.readLine();
//			int N = str.length();
//			char[] arr = new char[N];
//			for (int i = 0; i < N; i++) {
//				arr[i] = str.charAt(i);
//			}
//			// 쇠막대기 탐색하기
//			int open = 0, close = 0, cnt = 0;
//			for (int i = 0; i < N-1; i++) {
//				// 레이저가 쪼개는 쇠막대기 수만큼 더하기
//				if (arr[i] == '(' && arr[i+1] == ')') {
//					cnt += (open - close);
//				} else if (arr[i] == '(' && arr[i+1] != ')') {
//					open++;
//				} else if (i > 0 && arr[i-1] != '(' && arr[i] == ')') {
//					close++;
//				}
//			}
//			// 원래 쇠막대기 수 더하기
//			cnt += open;
//			// 잘려진 조각의 총 개수를 출력
//			System.out.println("#" + tc + " " + cnt);
//		}
//	}
//}