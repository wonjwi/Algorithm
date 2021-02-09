package com.ssafy.add;

import java.io.*;
import java.util.StringTokenizer;

//1974. 스도쿠 검증
//가로, 세로 같은 줄에 1에서 9까지의 숫자를 한번씩만 넣어야 한다.
//3 x 3의 작은 격자 또한, 1에서 9까지의 숫자가 겹치지 않아야 한다.
//겹치는 숫자가 없을 경우, 1을 그렇지 않을 경우 0을 출력한다.
public class SW1974_스도쿠검증 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			boolean[][] garo = new boolean[9][10]; // 9줄, 1~9
			boolean[][] sero = new boolean[9][10]; // 9줄, 1~9
			boolean[][] nemo = new boolean[9][10]; // 9칸, 1~9
			boolean vaild = true;
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 9; j++) {
					int temp = Integer.parseInt(st.nextToken());
					// 이미 숫자가 선택 되어있어서 유효하지 않다.
					if (garo[j][temp] || sero[i][temp] || nemo[3*(i/3)+j/3][temp]) {
						vaild = false;
					}
					// 해당 숫자를 가로, 세로, 네모에 체크한다.
					garo[j][temp] = true;
					sero[i][temp] = true;
					nemo[3*(i/3)+j/3][temp] = true;
				}
			}
			result.append("#").append(tc).append(" ").append(vaild ? 1 : 0).append("\n");
		}
		System.out.println(result);
	}
}
