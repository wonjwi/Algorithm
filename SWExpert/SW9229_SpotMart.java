package homework;

import java.io.*;
import java.util.*;

/** 9229. 한빈이와 Spot Mart 
 * 한빈이가 들고 갈 수 있는 과자 봉지의 무게 합 최대를 출력
 */
class SW9229_SpotMart {
	static int N;
	static int M;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken()); // 과자 봉지의 개수
			M = Integer.parseInt(st.nextToken()); // 무게 합 제한
			// 각 과자봉지의 무게
			int[] weight = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			// 과자봉지 무게 합 최대 구하기
			int maxSum = findMaxSum(weight, 0, -1, 0, 0);
			// 무게 합 최댓값 결과 출력
			sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int findMaxSum(int[] weight, int sum, int maxSum, int count, int start) {
		// 두 봉지만 들 수 있다
		if (count == 2) { 
			if (sum <= M && sum > maxSum) maxSum = sum;
			return maxSum;
		}
		for (int i = start; i < N; i++) {
			maxSum = findMaxSum(weight, sum+weight[i], maxSum, count+1, i+1);
		}
		return maxSum;
	}
}