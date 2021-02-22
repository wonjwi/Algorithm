package week04;

import java.io.*;

public class SW5356_세로로말해요 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			// 단어 다섯 개 가로로 입력
			char[][] word = new char[5][];
			int[] length = new int[5];
			for (int i = 0; i < 5; i++) {
				word[i] = in.readLine().toCharArray();
				length[i] = word[i].length;
			}
			// 단어의 길이는 1 이상 15 이하
			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 5; i++) {
					if (j >= length[i] || word[i][j] == '\u0000') continue;
					sb.append(word[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
