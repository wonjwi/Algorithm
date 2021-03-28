package ssafy.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11399_ATM {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 사람의 수
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int[] time = new int[N]; // 각 사람이 돈을 인출하는데 걸리는 시간
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		// 모든 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값
		Arrays.sort(time);
		int sum = 0, ans = 0;
		for (int i = 0; i < N; i++) {
			sum += time[i];
			ans += sum;
		}
		System.out.println(ans);
	}

}
