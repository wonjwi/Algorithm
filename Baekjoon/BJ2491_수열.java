package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2491_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int aCnt = 1, dCnt = 1;
		int maxACnt = 1, maxDCnt = 1;
		for (int i = 1; i < N; i++) {
			if (num[i-1] <= num[i]) { // 오름차
				aCnt++;
			} else { // 종료
				maxACnt = Math.max(aCnt, maxACnt);
				aCnt = 1;
			}
			if (num[i-1] >= num[i]) { // 내림차
				dCnt++;
			} else { // 종료
				maxDCnt = Math.max(dCnt, maxDCnt);
				dCnt = 1;
			}
		}
		maxACnt = Math.max(aCnt, maxACnt);
		maxDCnt = Math.max(dCnt, maxDCnt);
		System.out.println(Math.max(maxACnt, maxDCnt));
	}
}
