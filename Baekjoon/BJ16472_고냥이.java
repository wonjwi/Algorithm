package week22;

import java.io.*;

public class BJ16472_고냥이 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();

		int len = str.length();
		int left = 0, i = 1, cnt = 1, answer = 1;
		int alpha[] = new int[26];
		alpha[str.charAt(0) - 'a']++;

		while (left < i && i < len) {
			int tmp = str.charAt(i++) - 'a';

			if (alpha[tmp] == 0) {
				cnt++;
			}
			alpha[tmp]++;

			while (cnt > N) {
				tmp = str.charAt(left++) - 'a';
				alpha[tmp]--;

				if (alpha[tmp] == 0) {
					cnt--;
				}
			}

			answer = Math.max(answer, i - left);
		}

		System.out.println(answer);
	}

}