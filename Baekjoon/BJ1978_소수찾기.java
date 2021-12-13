package algorithm;

import java.io.*;
import java.util.*;

public class BJ1978_소수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		int num, answer = 0;

		// 소수 판별용 배열 만들기
		boolean isNotPrime[] = new boolean[1001];
		isNotPrime[0] = isNotPrime[1] = true;
		for (int i = 2; i <= 100; i++) {
			for (int j = i + i; j <= 1000; j += i) {
				isNotPrime[j] = true;
			}
		}

		// 주어진 수들 중 소수의 개수 세기
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if (!isNotPrime[num]) {
				answer++;
			}
		}

		System.out.println(answer);
	}

}