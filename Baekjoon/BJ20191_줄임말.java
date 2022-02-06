package week15;

import java.io.*;

public class BJ20191_줄임말 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String S = in.readLine();
		String T = in.readLine();
		int slen = S.length(), tlen = T.length();

		// 줄임말을 만들 수 있는지 검사
		boolean alpha[] = new boolean[26];

		for (int i = 0; i < tlen; i++) {
			alpha[T.charAt(i) - 'a'] = true;
		}

		for (int i = 0; i < slen; i++) {
			if (!alpha[S.charAt(i) - 'a']) {
				System.out.println(-1);
				return;
			}
		}

		// 알파벳이 처음 등장하는 인덱스 저장
		int next[][] = new int[26][tlen];

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < tlen; j++) {
				if (T.charAt(j) - 'a' == i) {
					next[i][j] = 1;
				}
			}

			int idx = -1;
			for (int j = tlen - 1; j >= 0; j--) {
				if (next[i][j] == 1) {
					idx = j;
				}
				next[i][j] = idx;
			}
		}

		// 줄임말을 만드는 최소의 n 찾기
		int pointerS = 0, pointerT = 0, cnt = 0;

		while (pointerS < slen) {
			// T에서 해당 알파벳이 등장하는 다음 위치
			pointerT = next[S.charAt(pointerS) - 'a'][pointerT];

			if (pointerT == -1) {
				cnt++;
				pointerT = 0;
			} else {
				// T 끝까지 왔으면 처음으로 돌리기
				if (++pointerT == tlen) {
					cnt++;
					pointerT = 0;
				}
				pointerS++;
			}
		}

		if (pointerT != 0)
			cnt++;

		System.out.println(cnt);
	}

}
