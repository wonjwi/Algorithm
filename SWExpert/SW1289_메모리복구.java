package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

// 1289. 원재의 메모리 복구하기
//int T = 첫 번째 줄 입력;
//for (int i = 1; i <= T; i++) {
//	String str = 다음 한 줄 입력;
//	int cnt = 0; // 수정 횟수
//	for (int j = 0; j < str.length() - 1; j++) {
//		if (str의 j번째 문자 != str의 j+1번째 문자) {
//			cnt++;
//		}
//	}
//	"#i cnt" 출력;
//}
class SW1289_메모리복구 {
	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int cnt = 0; // 수정 횟수
			String str = sc.next(); // 원래 상태
			char temp = '0';
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) != temp) {
					cnt++;
					temp = temp == '0' ? '1' : '0';
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}

//==========================================================================

//package com.ssafy.algo;
//
//import java.util.Scanner;
//import java.io.FileInputStream;
//
//// 1289. 원재의 메모리 복구하기
//class SW1289_메모리복구 {
//	public static void main(String args[]) throws Exception {
//		
//		System.setIn(new FileInputStream("res/input.txt"));
//		Scanner sc = new Scanner(System.in);
//		int T;
//		T = sc.nextInt();
//		for (int test_case = 1; test_case <= T; test_case++) {
//			int cnt = 0; // 수정 횟수
//			String str = sc.next(); // 원래 상태
//			if (str.charAt(0) == '1') {
//				cnt++;
//			}
//			for (int j = 0; j < str.length() - 1; j++) {
//				if (str.charAt(j) != str.charAt(j+1)) {
//					cnt++;
//				}
//			}
//			System.out.println("#" + test_case + " " + cnt);
//		}
//	}
//}