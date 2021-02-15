package homework;

import java.io.*;

//3040. 백설 공주와 일곱 난쟁이
//아홉 개의 수 중 합이 100이 되는 일곱 개의 수를 찾아라.
public class BJ3040_일곱난쟁이 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = new int[9];
		for (int i = 0; i < 9; i++) {
			numbers[i] = Integer.parseInt(in.readLine());
		}
		if (search(numbers, new boolean[9], 0, 0, 0)) return;
	}
	private static boolean search(int[] numbers, boolean[] checked, int cnt, int start, int sum) {
		if (cnt == 7) {
			if (sum == 100) {
				for (int i = 0; i < 9; i++) {
					if (checked[i]) System.out.println(numbers[i]);
				}
				return true;
			}
		}
		for (int i = start; i < 9; i++) {
			if (checked[i]) continue;
			checked[i] = true;
			search(numbers, checked, cnt+1, i+1, sum+numbers[i]);
			checked[i] = false;
		}
		return false;
	}
}