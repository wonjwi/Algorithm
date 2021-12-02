package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1157_단어공부 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();

		int tmp, cnt[] = new int[26];

		// 알파벳 사용된 횟수 세기
		for (int i = 0; i < str.length(); i++) {
			tmp = str.charAt(i);

			// 알파벳 대문자일 경우
			if (tmp <= 90) {
				cnt[tmp - 65]++;
			}
			// 알파벳 소문자일 경우
			else {
				cnt[tmp - 97]++;
			}

		}

		// 가장 많이 사용된 알파벳 구하기
		int maxCnt = cnt[0], result = 65;

		for (int i = 1; i < 26; i++) {
			if (maxCnt < cnt[i]) {
				maxCnt = cnt[i];
				result = 65 + i;
			}
			else if (maxCnt == cnt[i]) {
				result = 63;
			}
		}
		
		System.out.println((char) result);
	}
}