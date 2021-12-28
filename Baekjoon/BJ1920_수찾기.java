package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int num[] = new int[N];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		// 이분 탐색을 위한 오름차순 정렬
		Arrays.sort(num);

		int M = Integer.parseInt(in.readLine());
		int tmp;

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			tmp = Arrays.binarySearch(num, Integer.parseInt(st.nextToken()));
			sb.append(tmp >= 0 ? "1" : "0").append("\n");
		}

		System.out.println(sb.toString());
	}

}