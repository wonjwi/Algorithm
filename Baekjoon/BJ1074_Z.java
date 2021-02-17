package com.ssafy.algo;

import java.io.*;
import java.util.*;

//1074. Z
//크기가 2^N × 2^N인 2차원 배열을 Z모양으로 탐색한다.
//N > 1일 경우, 배열을 크기가 2^N-1 × 2^N-1로 4등분 한 후에 재귀적으로 방문한다.
//r행 c열을 몇 번째로 방문하는지 출력하라.
public class BJ1074_Z {
	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		while (N > 0) {
			int tmpN = (int) Math.pow(2, N-1); // Z탐색 크기
			if (r < tmpN && c >= tmpN) {
				c -= tmpN;
				cnt += tmpN*tmpN;
			} else if (r >= tmpN && c < tmpN) {
				r -= tmpN;
				cnt += 2*tmpN*tmpN;
			} else if (r >= tmpN && c >= tmpN) {
				r -= tmpN;
				c -= tmpN;
				cnt += 3*tmpN*tmpN;
			}
			N--; // 1/2 크기로 다시 탐색
		}
		System.out.println(cnt);
	}
}