package com.ssafy.add;

import java.io.*;
import java.util.StringTokenizer;

/** 
 * 1733. 오목
 * 입력으로 바둑판의 상태가 주어지는데 검은 바둑알은 1, 흰 바둑알은 2, 알이 없으면 0이다.
 * 검은색 또는 흰색이 이겼는지 또는 아직 승부가 결정되지 않았는지를 판단하라. 
 */
public class JO1733_오목 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[21][21];
		for (int i = 1; i <= 19; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= 19; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		int k = 0;
		Loop:
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				// 바둑알이 있을 때만 검사 시작
				if (map[i][j] != '0') {
					// 오른쪽 위
					if (map[i+1][j-1] != map[i][j]) {
						k = 1;
						while (map[i][j] == map[i-k][j+k]) k++;
					}
					// 오른쪽
					if (k != 5 && map[i][j-1] != map[i][j]) {
						k = 1;
						while (map[i][j] == map[i][j+k]) k++;
					}
					// 오른쪽 아래
					if (k != 5 && map[i-1][j-1] != map[i][j]) {
						k = 1;
						while (map[i][j] == map[i+k][j+k]) k++;
					}
					// 아래쪽
					if (k != 5 && map[i-1][j] != map[i][j]) {
						k = 1;
						while (map[i][j] == map[i+k][j]) k++;
					}
					if (k == 5)	{
						System.out.println(map[i][j]);
						System.out.println(i+" "+j);
						break Loop; // 여러 군데서 이기는 경우 없음
					}
				}
			}
		}
		if (k != 5) System.out.println("0");
	}
}