package ssafy.workshop;

import java.io.*;
import java.util.HashMap;

public class SW9760_PokerGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] str = in.readLine().split(" ");
			
			// 카드 핸드 입력 및 판별
			boolean isStraight = false, isFlush = false;
			boolean isFour = false, isThree = false; int pair = 0;
			HashMap<Character, Integer> suite = new HashMap<Character, Integer>();
			int[] rank = new int[14];
			for (int i = 0; i < 5; i++) {
				char p = str[i].charAt(0); // 모양
				int cnt = suite.get(p) == null ? 0 : suite.get(p);
				suite.put(p, cnt+1);
				if (cnt+1 == 5) isFlush = true;
				
				char n = str[i].charAt(1); // 숫자
				int num = 0;
				if (n == 'A') num = 1;
				else if (n == 'T') num = 10;
				else if (n == 'J') num = 11;
				else if (n == 'Q') num = 12;
				else if (n == 'K') num = 13;
				else num = n-'0';
				rank[num]++;
				cnt = rank[num];
				if (cnt == 4) isFour = true;
				if (cnt == 3) isThree = true;
				if (cnt == 2) pair++;
			}
			
			// 스트레이트 판별
			if (pair == 0 && !isThree && !isFour) {
				boolean flag = false;
				int cnt = 0;
				for (int i = 1; i <= 13; i++) {
					if (cnt == 5) break;
					if (rank[i] != 0) {
						if (!flag) flag = true;
						cnt++;
						if (i == 13 && rank[1] == 1) cnt++;
					} else {
						if (!flag) continue;
						if (i == 2) {
							i = 9; continue;
						}
						flag = false; break;
					}
				}
				if (flag && cnt == 5) isStraight = true;
			}
			
			// 카드 핸드의 종류 판별
			String answer = "High card";
			if (isStraight && isFlush) answer = "Straight Flush";
			else if (isFour) answer = "Four of a Kind";
			else if (isThree && pair == 2) answer = "Full House";
			else if (isFlush) answer = "Flush";
			else if (isStraight) answer = "Straight";
			else if (isThree) answer = "Three of a kind";
			else if (pair == 2) answer = "Two pair";
			else if (pair == 1) answer = "One pair";
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
