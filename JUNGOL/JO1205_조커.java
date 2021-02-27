package algorithm;

import java.io.*;
import java.util.*;

public class JO1205_조커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int[] num = new int[N];
		int jokerCnt = 0; // 조커 카드의 개수
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if (num[i] == 0) jokerCnt++;
		}
		// 카드 오름차순 정렬
		Arrays.sort(num);
		// 가장 긴 길이의 스트레이트 만들기
		int max = 0, stCnt = 0, joker = jokerCnt;
		for (int i = jokerCnt; i < N; i++) {
			stCnt = 1; joker = jokerCnt;
			for (int j = i+1; j < N; j++) {
				int tmp = num[j]-num[j-1];
				if (tmp == 1) {
					stCnt++;
				}
				else if (tmp == 0) {
					continue;
				}
				else if (joker > 0) {
					if (tmp-1 <= joker) {
						stCnt += tmp;
						joker -= tmp-1;
					}
					else {
						stCnt += joker;
						joker = 0;
						break;
					}
				}
				else break;
			}
			max = Math.max(max, stCnt+joker);
		}
		max = Math.max(max, joker);
		System.out.println(max);
	}
}
