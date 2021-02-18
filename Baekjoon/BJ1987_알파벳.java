package algostudy;

import java.io.*;
import java.util.*;

/**
 * 1987. 알파벳
 * 세로 R칸, 가로 C칸에 칸마다 대문자 알파벳이 하나씩 적힌 보드가 있다.
 * 말은 상하좌우 중 한 칸으로 이동할 수 있고, 같은 알파벳이 적힌 칸은 두 번 지날 수 없다.
 * 좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하라.
 */
public class BJ1987_알파벳 {
	static int R, C, maxCnt = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		move(map, new boolean[26], 0, 0, 1);
		System.out.println(maxCnt);
	}
	private static void move(char[][] map, boolean[] alphabet, int r, int c, int cnt) {
		// 현재 알파벳 사용여부 저장
		alphabet[map[r][c]-'A'] = true;
		// 이동할 곳이 있으면 이동
		if (r > 0 && !alphabet[map[r-1][c]-'A'])
			move(map, alphabet, r-1, c, cnt+1);
		if (r < R-1 && !alphabet[map[r+1][c]-'A'])
			move(map, alphabet, r+1, c, cnt+1);
		if (c > 0 && !alphabet[map[r][c-1]-'A'])
			move(map, alphabet, r, c-1, cnt+1);
		if (c < C-1 && !alphabet[map[r][c+1]-'A'])
			move(map, alphabet, r, c+1, cnt+1);
		alphabet[map[r][c]-'A'] = false;
		// 더이상 이동할 곳이 없으면 종료
		maxCnt = Math.max(maxCnt, cnt);
		return;
	}
}