package algorithm;

import java.io.*;

public class BJ1019_책페이지 {
	
	static int[] cnt = new int[10];
	static int mul = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int start = 1;
		int end = Integer.parseInt(in.readLine());
		
		while (true) {
			// 처음과 끝은 따로 계산
			while (start%10 != 0 && start <= end) {
				addCnt(start);
				start++;
			}
			while (end%10 != 9 && start <= end) {
				addCnt(end);
				end--;
			}
			if (start > end || (start == 0 && end == 0)) break;
			
			// 중간은 수식으로 계산
			start /= 10; end /= 10;
			for (int i = 0; i <= 9; i++) {
				cnt[i] += (end-start+1)*mul;
			}
			mul *= 10;
		}
		// 모두 계산 후 결과 출력
		for (int i = 0; i <= 9; i++) {
			sb.append(cnt[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static void addCnt(int n) {
		while (n != 0) {
			cnt[n%10] += mul;
			n /= 10;
		}
	}

}
