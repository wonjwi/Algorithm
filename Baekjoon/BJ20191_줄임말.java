package week15;

import java.io.*;

public class BJ20191_줄임말 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine().trim();
		String T = in.readLine().trim();
		
		int slen = S.length(), tlen = T.length();
		boolean alpha[] = new boolean[26];
		for (int i = 0; i < tlen; i++) {
			alpha[T.charAt(i)-'a'] = true;
		}
		
		int si = 0, ti = 0, n = 1;
		while (true) {
			if (!alpha[S.charAt(si)-'a']) {
				System.out.println(-1);
				return;
			}
			if (S.charAt(si) == T.charAt(ti++)) si++;
			if (si == slen) break;
			if (ti == tlen) {
				n++;
				ti = 0;
			}
		}
		System.out.println(n);
	}

}
