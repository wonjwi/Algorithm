package com.ssafy.workshop;

import java.io.*;
import java.util.*;

public class BJ2636_치즈 {
	
	static class Cheeze {
		int r, c;
		public Cheeze(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int sero = Integer.parseInt(st.nextToken());
		int garo = Integer.parseInt(st.nextToken());
		
		// 초기 치즈 정보 입력
		boolean[][] map = new boolean[sero][garo];
		for (int i = 0; i < sero; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < garo; j++) {
				map[i][j] = st.nextToken().charAt(0) == '1' ? true : false;
			}
		}
		// 판의 가장자리부터 출발
		Queue<Cheeze> air = new LinkedList<Cheeze>();
		for (int i = 0; i < sero; i++) {
			air.add(new Cheeze(i, 0));
			air.add(new Cheeze(i, garo-1));
		}
		for (int j = 1; j < garo-1; j++) {
			air.add(new Cheeze(0, j));
			air.add(new Cheeze(sero-1, j));
		}
		// 치즈 테두리 찾기
		Queue<Cheeze> cheeze = new LinkedList<Cheeze>();
		boolean[][] visited = new boolean[sero][garo];
		int cnt = 0; // 치즈조각 수
		int time = 0; // 흐른 시간
		while (true) {
			cnt = air.size();
			while (!air.isEmpty()) {
				Cheeze tmp = air.poll();
				int r = tmp.r;
				int c = tmp.c;
					for (int i = 0; i < 4; i++) {
						int row = r+dr[i];
						int col = c+dc[i];
						if (row < 0 || row >= sero || col < 0 || col >= garo || visited[row][col]) continue;
						if (map[row][col]) {
							cheeze.add(new Cheeze(row, col));
							map[row][col] = false; // 치즈 녹이기
						} else {
							air.add(new Cheeze(row, col));
						}
						visited[row][col] = true;
					}
			}
			// 더 이상 제거할 치즈가 없다면 종료
			if (cheeze.size() == 0) break;
			time++;
			
			// cheeze의 data를 air로 옮기기
			while (!cheeze.isEmpty()) {
				air.add(cheeze.poll());
			}
		}
		System.out.println(time+"\n"+cnt);
	}

}
