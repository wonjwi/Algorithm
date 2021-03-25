package com.ssafy.workshop;

import java.io.*;

public class BJ1463_1로만들기 {
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N+1]; // 1로 만들기 위해 필요한 연산 횟수
		arr[1] = 0;
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i-1]+1;
			if (i%3 == 0) arr[i] = Math.min(arr[i], arr[i/3]+1);
			if (i%2 == 0) arr[i] = Math.min(arr[i], arr[i/2]+1);
		}
		System.out.println(arr[N]);
	}

}

//import java.io.*;
//
//public class BJ1463_1로만들기 {
//	
//	static int min = Integer.MAX_VALUE;
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(in.readLine());
//		DFS(N, 0);
//		System.out.println(min);
//	}
//
//	private static void DFS(int N, int cnt) {
//		if (N == 1) {
//			min = Math.min(min, cnt);
//			return;
//		}
//		if (cnt >= min) return;
//		
//		if (N%3 == 0) DFS(N/3, cnt+1);
//		if (N%2 == 0) DFS(N/2, cnt+1);
//		DFS(N-1, cnt+1);
//	}
//
//}
