package algorithm;

import java.io.*;
import java.util.*;

public class BJ2163_초콜릿자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 초콜릿을 1*1 크기의 조각으로 쪼개기 위한 횟수
		int result = 0;

		if (N == 1 || M == 1) {
			result = N - 1 + M - 1;
		} else {
			result = N - 1 + N * (M - 1);
		}

		System.out.println(result);
	}

}