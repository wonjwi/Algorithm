package com.ssafy.algo;

import java.io.*;
import java.util.*;

/*
 * 15686. 치킨 배달
 * 크기가 N×N인 도시의 0은 빈 칸, 1은 집, 2는 치킨집을 의미.
 * 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리, 도시의 치킨 거리는 집마다의 합.
 * M개의 치킨집을 남길 때, 도시의 치킨 거리가 가장 작게 되도록 하라.
 */
public class BJ15686_치킨배달 {
	static List<int[]> home, shop;
	static int minDistance = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시의 크기
		int M = Integer.parseInt(st.nextToken()); // 남길 치킨집
		// 도시 정보 입력
		home = new ArrayList<int[]>();
		shop = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int temp = st.nextToken().charAt(0)-'0';
				if (temp > 0) { // 집 또는 치킨집 위치 저장
					int[] location = {i, j};
					if (temp == 1) home.add(location);
					else shop.add(location);
				}
			}
		}
		// 치킨집 M개 남기는 조합 구하기
		makeCombination(new boolean[shop.size()], M, 0, 0);
		System.out.println(minDistance);
	}

	private static void makeCombination(boolean[] selected, int M, int cnt, int start) {
		if (M == cnt) {
			// 조합을 완성하면 치킨 거리 최솟값 구하기
			minDistance = Math.min(minDistance, getDistance(selected));
			return;
		}
		for (int i = start; i < shop.size(); i++) {
			selected[i] = true;
			makeCombination(selected, M, cnt+1, i+1);
			selected[i] = false;
		}
	}

	private static int getDistance(boolean[] selected) {
		int distance = 0;
		for (int[] homeLocation : home) {
			int tmpDis = Integer.MAX_VALUE;
			int r = homeLocation[0];
			int c = homeLocation[1];
			for (int i = 0; i < shop.size(); i++) {
				if (selected[i]) {
					int[] temp = shop.get(i);
					tmpDis = Math.min(tmpDis, Math.abs(r-temp[0]) + Math.abs(c-temp[1]));
				}
			}
			distance += tmpDis;
		}
		return distance;
	}
}
