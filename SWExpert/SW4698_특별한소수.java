package week04;

import java.io.*;
import java.util.*;

//2
//3 10 30
//7 1 1000000
public class SW4698_특별한소수 {
	private static boolean prime(int n) {
		if (n%2 == 0 && n != 2) return false;
		for (int i = 3; i <= Math.sqrt(n); i++) {
			if (n%i == 0) return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 1000000 이하의 소수를 미리 구해둔다.
		int[] primeList = new int[1000000];
		int idx = 0;
		for (int i = 2; i <= 1000000; i++) {
			if (prime(i)) {
				primeList[idx++] = i;
			}
		}
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			char D = st.nextToken().charAt(0);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// D가 포함된 특별한 소수의 개수 구하기
			int cnt = 0;
			for (int i : primeList) {
				if (i < A) continue;
				if (i > B) break;
				String str = i+"";
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j) == D) {
						cnt++; break;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}
