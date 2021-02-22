package week03;

import java.io.*;
import java.util.*;

public class BJ13410_거꾸로구구단 {
	static int minDistance = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dan = new int[K+1];
		for (int i = 1; i <= K; i++) {
			int reverse = 0;
			int temp = i*N;
			while (temp > 0) {
				reverse = reverse*10 + temp%10;
				temp /= 10;
			}
			dan[i] = reverse;
		}
		Arrays.sort(dan);
		System.out.println(dan[K]);
	}
}