package algopractice;

import java.io.*;
import java.util.Arrays;

//2309. 일곱 난쟁이
//아홉 개의 수 중 합이 100이 되는 일곱 개의 수를 오름차순으로 출력하라.
public class BJ2309_일곱난쟁이 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = new int[9];
		int totalSum = 0;
		for (int i = 0; i < 9; i++) {
			numbers[i] = Integer.parseInt(in.readLine());
			totalSum += numbers[i];
		}
		Arrays.sort(numbers);
		int target = totalSum-100;
		Loop:
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if (numbers[i]+numbers[j] == target) {
					numbers[i] = -1;
					numbers[j] = -1;
					break Loop;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (numbers[i] == -1) continue;
			System.out.println(numbers[i]);
		}
	}
}
//public class BJ2309_일곱난쟁이 {
//	static int[] result = new int[7];
//	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		int[] numbers = new int[9];
//		for (int i = 0; i < 9; i++) {
//			numbers[i] = Integer.parseInt(in.readLine());
//		}
//		search(numbers, new boolean[9], 0, 0, 0);
//		for (int i = 0; i < 7; i++) {
//			System.out.println(result[i]);
//		}
//	}
//	private static void search(int[] numbers, boolean[] checked, int cnt, int start, int sum) {
//		if (cnt == 7) {
//			if (sum == 100) {
//				int idx = 0;
//				for (int i = 0; i < 9; i++) {
//					if (checked[i]) result[idx++] = numbers[i];
//				}
//				Arrays.sort(result);
//				return;
//			}
//		}
//		for (int i = start; i < 9; i++) {
//			if (checked[i]) continue;
//			checked[i] = true;
//			search(numbers, checked, cnt+1, i+1, sum+numbers[i]);
//			checked[i] = false;
//		}
//	}
//}