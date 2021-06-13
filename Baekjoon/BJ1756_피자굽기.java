package week17;

import java.io.*;
import java.util.*;

public class BJ1756_피자굽기 {

	static int start, last;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int D, N, oven[], radius, min = Integer.MAX_VALUE;
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		start = 0;
		last = D;

		// 깊이마다 넣을 수 있는 최대 지름
		oven = new int[D];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < D; i++) {
			radius = Integer.parseInt(st.nextToken());
			min = Math.min(min, radius);
			oven[i] = min;
		}

		// 피자 반죽을 오븐에 넣기
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			radius = Integer.parseInt(st.nextToken());
			// 반죽을 넣을 위치 찾기
			find(oven, radius);
			// 오븐에 반죽을 넣을 수 없으면
			if (--last < 0) {
				break;
			}
			start = 0; // 탐색 위치 초기화
		}
		// 마지막 피자 반죽의 위치
		System.out.println(last + 1);
	}

	private static void find(int[] oven, int radius) {
		while (start < last) {
			int mid = (start + last) / 2;
			if (oven[mid] < radius) {
				last = mid;
			} else {
				start = mid + 1;
			}
		}
	}

}
