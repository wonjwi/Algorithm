package algostudy;

import java.io.*;
import java.util.*;

/**
 * 14503. 로봇청소기
 * 로봇 청소기가 청소하는 칸의 개수를 구하라.
 */
public class BJ14503_로봇청소기 {
	static int[] dr = { -1, 0, 1, 0 }; // 북동남서
	static int[] dc = { 0, 1, 0, -1 };
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		// 장소의 상태 (빈 칸은 0, 벽은 1)
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		int cnt = 0;
		Loop:
		while (true) {
			// 현재 위치를 청소
			map[r][c] = '2'; cnt++;
			// 왼쪽방향부터 차례대로 탐색 진행
			int k = 0;
			while (true) {
				d = (d-1 + 4) % 4; k++;
				int row = r + dr[d];
				int col = c + dc[d];
				// 청소할 곳이 있으면 전진해서 청소
				if (map[row][col] == '0') {
					r = row;
					c = col;
					break;
				}
				// 네 방향 모두 청소를 할 수 없을 경우
				else if (k == 4) {
					r -= dr[d];
					c -= dc[d];
					// 뒤쪽이 벽이면 작동을 멈춤
					if (map[r][c] == '1') {
						break Loop;
					}
					// 벽이 아니면 한 칸 후진 후 재탐색
					else k = 0;
				}
			}
		}
		System.out.println(cnt);
	}
}