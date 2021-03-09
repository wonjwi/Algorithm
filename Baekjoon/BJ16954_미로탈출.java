package week06;

import java.io.*;

public class BJ16954_미로탈출 {
	
	static int result = 0;
	static int[] dr = {-1, -1, 0, -1, 1,  0, 1,  1, 0};
	static int[] dc = { 1,  0, 1, -1, 1, -1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 체스판의 상태 입력 (.은 빈 칸, #은 벽)
		char[][] map = new char[8][8];
		for (int i = 0; i < 8; i++) {
			map[i] = in.readLine().toCharArray();
		}
		// 가장 왼쪽 아랫 칸에서 출발
		move(map, 0, 7, 0);
		
		// 도착할 수 있으면 1, 없으면 0 출력
		System.out.println(result);
	}

	private static void move(char[][] map, int time, int r, int c) {
		// 8번을 버티면 벽이 없으므로 무조건 가능
		if (time == 8) {
			result = 1;
			return;
		}
		// 벽이 캐릭터가 있는 칸으로 이동하면 더 이상 이동 불가
		if (r-time >= 0 && map[r-time][c] == '#') {
			return;
		}
		// 인접한 곳이나 대각선으로 한 칸 이동하거나 멈춰있기
		for (int i = 0; i < 9; i++) {
			int mr = r+dr[i];
			int mc = c+dc[i];
			// 경계를 넘는 곳이나 방문한 곳으로 이동 안 함
			if (mr < 0 || mc < 0 || mr >= 8 || mc >= 8) continue;
			// 벽으로 이동 불가 (벽은 time 칸만큼 내려간 상태)
			if (mr-time >= 0 && map[mr-time][mc] == '#') continue;
			move(map, time+1, mr, mc);
		}
	}

}
