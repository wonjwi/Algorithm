package com.ssafy.add;

import java.io.*;
import java.util.*;

/**
 * 2164. 카드2
 * 1부터 N까지의 번호가 차례로 붙어있는 N장의 카드가 있다.
 * 1번 카드가 제일 위에, N번 카드가 제일 아래인 순서로 놓여 있다.
 * 제일 위에 있는 카드를 바닥에 버리고, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 * 이 동작을 카드가 한 장 남을 때까지 반복할 때, 첫째 줄에 남게 되는 카드의 번호를 출력
 * ------------------------------------------------------------
 * 규칙 : N = 2^n이면 N번 카드, N = 2^n + x이면 2*x번 카드가 남는다.
 */
public class BJ2164_카드2 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int temp = 0;
		int[] square = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 
				2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144 };
		for (int i = 0; i < square.length; i++) {
			if (N == square[i]) {
				System.out.println(N);
				return;
			} 
			else if (N > square[i]) {
				temp = square[i];
			} else {
				break;
			}
		}
		System.out.println(2*(N-temp));
	}
}

//==========================================================================

//package com.ssafy.add;
//
//import java.io.*;
//import java.util.*;
//
///**
// * 2164. 카드2
// * 1부터 N까지의 번호가 차례로 붙어있는 N장의 카드가 있다.
// * 1번 카드가 제일 위에, N번 카드가 제일 아래인 순서로 놓여 있다.
// * 제일 위에 있는 카드를 바닥에 버리고, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
// * 이 동작을 카드가 한 장 남을 때까지 반복할 때, 첫째 줄에 남게 되는 카드의 번호를 출력
// */
//public class BJ2164_카드2 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(in.readLine());
//		// 카드 리스트에 번호 입력
//		Queue<Integer> card = new LinkedList<>();
//		for (int i = 1; i <= N; i++) {
//			card.add(i);
//		}
//		while(card.size() != 1) {
//			card.poll();
//			card.add(card.poll());
//		}
//		System.out.println(card.poll());
//	}
//}