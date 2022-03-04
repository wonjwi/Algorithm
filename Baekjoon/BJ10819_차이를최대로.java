package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int A[] = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A); // 오름차순 정렬

		int large = N - 1, small = N / 2 - 1, answer = 0;

		for (int i = 0; i < N - 1; i++) {
			if (small < 0) {
				answer += Math.max(A[large] - A[N / 2], A[N / 2] - A[N / 2 - 1]);
			} else if (i % 2 == 0) {
				answer += A[large] - A[small--];
			} else {
				answer += A[large--] - A[small];
			}
		}

		System.out.println(answer);
	}

}

//public class Main {
//
//	static int N, A[], answer = 0;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//		N = Integer.parseInt(in.readLine());
//		A = new int[N];
//
//		StringTokenizer st = new StringTokenizer(in.readLine());
//		for (int i = 0; i < N; i++) {
//			A[i] = Integer.parseInt(st.nextToken());
//		}
//
//		make(new int[N], new boolean[N], 0);
//
//		System.out.println(answer);
//	}
//
//	private static void make(int[] arr, boolean[] checked, int cnt) {
//		if (cnt == N) {
//			calc(arr);
//			return;
//		}
//
//		for (int i = 0; i < N; i++) {
//			if (checked[i])
//				continue;
//
//			arr[cnt] = A[i];
//			checked[i] = true;
//			make(arr, checked, cnt + 1);
//			checked[i] = false;
//		}
//	}
//
//	private static void calc(int[] arr) {
//		int sum = 0;
//
//		for (int i = 1; i < N; i++) {
//			sum += Math.abs(arr[i - 1] - arr[i]);
//		}
//
//		answer = Math.max(answer, sum);
//	}
//
//}