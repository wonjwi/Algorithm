package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int line[] = new int[K];

		for (int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(in.readLine());
		}

		Arrays.sort(line);

		long left = 1, mid = 1, right = line[K - 1];

		while (left <= right) {
			mid = (left + right) / 2;
			long sum = 0;

			for (int i = 0; i < K; i++) {
				sum += line[i] / mid;
			}

			if (sum >= N) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(right);
	}

}