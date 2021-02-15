package com.ssafy.algo;

import java.io.*;
import java.util.*;

//6808. 규영이와 인영이의 카드게임
//규영이가 받은 9장의 카드에 적힌 수가 주어지고, 내는 카드의 순서가 고정되어있을 때
//인영이가 카드를 내는 순서에 따라 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구하라.
class SW6808_카드게임 {
	static int win = 0, lose = 0;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[] kyuyoung = new int[9];
			boolean[] isSelected = new boolean[19];
			for (int i = 0; i < 9; i++) {
				kyuyoung[i] = Integer.parseInt(st.nextToken());
				isSelected[kyuyoung[i]] = true;
			}
			int cnt = 0, i = 0;
			int[] inyoung = new int[9];
			while (cnt < 9) {
				if (!isSelected[++i]) inyoung[cnt++] = i;
			}
			win = 0; lose = 0;
			playGame(kyuyoung, inyoung, new boolean[9], 0, 0, 0);
			System.out.println("#"+tc+" "+win+" "+lose);
		}
	}
	private static void playGame(int[] kyuyoung, int[] inyoung, boolean[] isSelected, int cnt, int scoreK, int scoreI) {
		// 순열을 완성하면 승패를 계산한다.
		if (cnt == 9) {
			if (scoreK > scoreI) win++;
			else if (scoreK < scoreI) lose++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			if (kyuyoung[cnt] > inyoung[i]) 
				playGame(kyuyoung, inyoung, isSelected, cnt+1, scoreK+kyuyoung[cnt]+inyoung[i], scoreI);
			else
				playGame(kyuyoung, inyoung, isSelected, cnt+1, scoreK, scoreI+kyuyoung[cnt]+inyoung[i]);
			isSelected[i] = false;
		}
	}
}
//class SW6808_카드게임 {
//	static int[] kyuyoung = new int[9];
//	static int[] inyoung = new int[9];
//	static int win=0, lose=0, score=0;
//	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= T; tc++) {
//			StringTokenizer st = new StringTokenizer(in.readLine());
//			boolean[] isSelected = new boolean[19];
//			for (int i = 0; i < 9; i++) {
//				kyuyoung[i] = Integer.parseInt(st.nextToken());
//				isSelected[kyuyoung[i]] = true;
//			}
//			int cnt = 0, i = 0;
//			while (cnt < 9) {
//				if (!isSelected[++i]) inyoung[cnt++] = i;
//			}
//			Arrays.sort(inyoung); // 오름차순 정렬
//			win=0; lose=0;
//			do {
//				for (int j = 0; j < 9; j++) {
//					if (kyuyoung[j] > inyoung[j]) score += kyuyoung[j]+inyoung[j];
//					else score -= kyuyoung[j]+inyoung[j];
//				}
//				if (score > 0) win++;
//				else if (score < 0) lose++;
//				score=0;
//			} while(np());
//			System.out.println("#"+tc+" "+win+" "+lose);
//		}
//	}
//	public static boolean np() {
//		int i = 8;
//		while (i>0 && inyoung[i-1] >= inyoung[i]) --i;
//		
//		if (i == 0) return false;
//		
//		int j = 8;
//		while (inyoung[i-1] >= inyoung[j]) --j;
//		swap(i-1, j);
//		
//		int k = 8;
//		while (i<k) {
//			swap(i++, k--);
//		}
//		return true;
//	}
//	private static void swap(int i, int j) {
//		int temp = inyoung[i];
//		inyoung[i] = inyoung[j];
//		inyoung[j] = temp;
//	}
//}