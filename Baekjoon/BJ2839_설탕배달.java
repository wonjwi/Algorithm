package com.ssafy.algo;

import java.io.*;
import java.util.*;

//2839. 설탕 배달
//설탕공장에서 만드는 설탕은 3킬로그램 봉지와 5킬로그램 봉지가 있다.
//설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지를 구하라.
//정확하게 N킬로그램을 만들 수 없다면 -1을 아니라면 봉지의 최소 개수를 출력한다.
public class BJ2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 배달할 무게
		boolean flag = false;
		Loop:
		for (int i = N/5; i >= 0; i--) {
			for (int j = 0; i*5 + j*3 <= N; j++) {
				if (i*5 + j*3 == N) {
					System.out.println(i+j);
					flag = true; break Loop;
				}
			}
		}
		if (!flag) System.out.println(-1);
	}
}
//public class BJ2839_설탕배달 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(in.readLine()); // 배달할 무게
//		int min = Integer.MAX_VALUE;
//		int max = N/3;
//		for (int i = 0; i <= N/5; i++) {
//			for (int j = 0; j <= max-i; j++) {
//				if (i*5 + j*3 == N) {
//					min = Math.min(min, i+j); 
//				}
//			}
//		}
//		if (min <= max) System.out.println(min);
//		else System.out.println(-1);
//	}
//}