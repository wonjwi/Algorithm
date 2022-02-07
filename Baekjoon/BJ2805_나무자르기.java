package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int tree[] = new int[N];
		int left = 0, right = 0;

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, tree[i]);
		}

		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;

			for (int i = 0; i < N; i++) {
				sum += Math.max(0, tree[i] - mid);
			}

			if (sum < M) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(right);
	}

}