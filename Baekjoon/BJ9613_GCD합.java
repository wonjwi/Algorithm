package algostudy;

import java.io.*;
import java.util.*;

// 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하기
public class BJ9613_GCD합 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] numbers = new int[n];
			for (int i = 0; i < n; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(numbers);
			long totalSum = 0;
			for (int i = 0; i < n-1; i++) {
				int M = numbers[i];
				for (int j = i+1; j < n; j++) {
					// M과 N의 공약수 찾기
					totalSum += gcd(M, numbers[j]);
				}
			}
			System.out.println(totalSum);
		}
	}
	private static long gcd(int m, int n) {
		if (m == 0) return n;
		return gcd(n%m, m);
	}
}
//public class BJ9613_GCD합 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int t = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= t; tc++) {
//			StringTokenizer st = new StringTokenizer(in.readLine());
//			int n = Integer.parseInt(st.nextToken());
//			int[] numbers = new int[n];
//			for (int i = 0; i < n; i++) {
//				numbers[i] = Integer.parseInt(st.nextToken());
//			}
//			Arrays.sort(numbers);
//			long totalSum = 0;
//			for (int i = 0; i < n-1; i++) {
//				// 첫번째 수의 약수 구하기
//				List<Integer> M = new ArrayList<Integer>();
//				int temp = numbers[i];
//				for (int j = temp; j >= 1; j--) {
//					if (temp%j == 0) M.add(j);
//				}
//				// 두번째 수 구한 뒤 공약수 찾기
//				for (int j = i+1; j < n; j++) {
//					int N = numbers[j];
//					for (int k = 0; k < M.size(); k++) {
//						if (N%M.get(k) == 0) {
//							totalSum += M.get(k);
//							break;
//						}
//					}
//				}
//			}
//			System.out.println(totalSum);
//		}
//	}
//}