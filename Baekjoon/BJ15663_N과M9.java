package com.ssafy.nm;

import java.io.*;
import java.util.*;

/**
 * 15663. N과 M (9)
 * N개의 자연수와 자연수 M이 주어졌을 때, 길이가 M인 수열을 모두 구하시오.
 * 조건 : N개의 자연수 중에서 M개를 고른 수열
 * 		: 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class BJ15663_N과M9 {
	private static StringBuilder result = new StringBuilder();
	private static int N;
	private static int M;	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		combination(input, new int[M], new boolean[N], 0);
		System.out.println(result);
	}

	private static void combination(int[] input, int[] output, boolean[] selected, int cnt) {
		// 수열을 완성하면 출력
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				result.append(output[i]).append(" ");
			}
			result.append("\n");
			return;
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			// 이미 선택된 숫자는 지나친다.
			if (selected[i]) continue;
			// 같은 자리에 중복된 숫자는 지나친다.
			boolean isExist = false;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) == input[i]) {
					isExist = true;
					break;
				}
			}
			if (isExist) continue;
			output[cnt] = input[i];
			list.add(input[i]);
			selected[i] = true;
			combination(input, output, selected, cnt+1);
			selected[i] = false;
		}
	}
}