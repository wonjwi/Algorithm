package algorithm;

import java.io.*;
import java.util.*;

public class Main {

//	Integer 배열 사용
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int cnt[] = new int[20000001];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			cnt[Integer.parseInt(st.nextToken()) + 10000000]++;
		}

		int M = Integer.parseInt(in.readLine());

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(cnt[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
		}

		System.out.println(sb.toString());
	}

//	HashMap 사용
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//		StringBuilder sb = new StringBuilder();
//
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//		int N = Integer.parseInt(in.readLine());
//		int tmp;
//
//		st = new StringTokenizer(in.readLine());
//		for (int i = 0; i < N; i++) {
//			tmp = Integer.parseInt(st.nextToken());
//
//			if (map.containsKey(tmp)) {
//				map.put(tmp, map.get(tmp) + 1);
//			} else {
//				map.put(tmp, 1);
//			}
//		}
//
//		int M = Integer.parseInt(in.readLine());
//
//		st = new StringTokenizer(in.readLine());
//		for (int i = 0; i < M; i++) {
//			tmp = Integer.parseInt(st.nextToken());
//
//			sb.append(map.containsKey(tmp) ? map.get(tmp) : "0").append(" ");
//		}
//
//		System.out.println(sb.toString());
//	}

}