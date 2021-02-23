package week04;

import java.io.*;

//4
//11111
//09
//110011
//1
public class SW4789_공연기획 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			// 0~9 만으로 이루어진 문자열
			char[] peopleNum = in.readLine().trim().toCharArray();
			int len = peopleNum.length;
			int clapPeople = 0; // 박수치는 사람 수
			int employ = 0; // 고용된 사람 수
			for (int need = 0; need < len; need++) {
				int pNum = peopleNum[need]-'0'; // i명 이상이 박수를 칠 때 박수를 치는 관객수
				if (need <= clapPeople) {
					clapPeople += pNum;
				} else {
					employ += (need-clapPeople);
					clapPeople += (pNum+need-clapPeople);
				}
			}
			sb.append(employ).append("\n");
		}
		System.out.println(sb.toString());
	}
}
