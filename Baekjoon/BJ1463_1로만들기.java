package com.ssafy.workshop;

import java.io.*;

public class BJ1463_1로만들기 {
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		DFS(N, 0);
		System.out.println(min);
	}

	private static void DFS(int N, int cnt) {
		if (N == 1) {
			min = Math.min(min, cnt);
			return;
		}
		if (cnt >= min) return;
		
		if (N%3 == 0) DFS(N/3, cnt+1);
		if (N%2 == 0) DFS(N/2, cnt+1);
		DFS(N-1, cnt+1);
	}

}
