package week05;

import java.io.*;
import java.util.*;

// 나중에 https://yabmoons.tistory.com/495 참고해서 다시 짜보기!
public class BJ19236_청소년상어 {
	
	static int maxSum;
	static int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1}; // 반시계 방향 8방 탐색 
	static int[] dc = {0, 0, -1, -1, -1, 0, 1, 1, 1}; // ↑, ↖, ←, ↙, ↓, ↘, →, ↗
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 물고기들의 시작 상태 
		int[][][][] map = new int[16][4][4][2];
		int[][][] fish = new int[16][17][2];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			for (int j = 0; j < 4; j++) {
				map[0][i][j][0] = Integer.parseInt(st.nextToken()); // 번호 
				map[0][i][j][1] = Integer.parseInt(st.nextToken()); // 방향 
				fish[0][map[0][i][j][0]][0] = i; // 번호마다 위치 저장 
				fish[0][map[0][i][j][0]][1] = j;
			}
		}
		
		// (0, 0)의 물고기를 먹기
		int[] shark = {0, 0, map[0][0][0][1]}; // 행, 열, 방향 
		int sum = map[0][0][0][0];
		fish[0][map[0][0][0][0]][0] = -1;
		map[0][0][0][0] = 0;
		
		// 물고기들이 순서대로 이동
		moveFish(map, fish, shark, 0, sum);
		
		// 상어가 먹을 수 있는 물고기 번호 합의 최댓값
		System.out.println(maxSum);
	}

	private static void moveShark(int[][][][] map, int[][][] fish, int[] shark, int cnt, int sum) {
		// 물고기의 이동이 끝나면 상어가 이동 
		int r = shark[0];
		int c = shark[1];
		int d = shark[2];
		for (int distance = 1; distance <= 3; distance++) {
			int mr = r + dr[d]*distance;
			int mc = c + dc[d]*distance;
			// 공간의 경계를 넘거나 빈 칸이면 이동 불가  
			if (mr < 0 || mr >= 4 || mc < 0 || mc >= 4) {
				// 이동할 수 있는 칸이 없으면 집으로 가기
				maxSum = Math.max(maxSum, sum);
				return;
			} else if (map[cnt-1][mr][mc][0] == 0) {
				maxSum = Math.max(maxSum, sum);
				continue;
			}
			// 이동 경로 기록하고 물고기 먹기 
			shark[0] = mr;
			shark[1] = mc;
			shark[2] = map[cnt-1][mr][mc][1];
			int num = map[cnt-1][mr][mc][0];

			// 이전 맵과 물고기 복사하기
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[cnt][i][j][0] = map[cnt-1][i][j][0];
					map[cnt][i][j][1] = map[cnt-1][i][j][1];
				}
			}
			for (int i = 1; i <= 16; i++) {
				fish[cnt][i][0] = fish[cnt-1][i][0];
				fish[cnt][i][1] = fish[cnt-1][i][1];
			}
			
			fish[cnt][num][0] = -1;
			map[cnt][mr][mc][0] = 0;
			// 상어가 물고기를 먹은 뒤 물고들이 이동
			moveFish(map, fish, shark, cnt, sum+num);
		}
	}

	private static void moveFish(int[][][][] map, int[][][] fish, int[] shark, int cnt, int sum) {
		// 물고기들이 순서대로 이동 
		for (int i = 1; i <= 16; i++) {
			int r = fish[cnt][i][0];
			int c = fish[cnt][i][1];
			// 해당 번호의 물고기가 없으면 패스 
			if (r < 0) continue;
			// 갖고 있는 방향으로 이동
			int dir = map[cnt][r][c][1];
			int d = dir;
			while (true) {
				int mr = r + dr[d];
				int mc = c + dc[d];
				// 공간의 경계를 넘거나 상어가 있으면 방향을 바꾸면서 시도 
				if (mr < 0 || mr >= 4 || mc < 0 || mc >= 4 || (mr==shark[0] && mc==shark[1])) {
					d = d%8 + 1;
					if (d == dir) break;
					continue;
				}
				// 이동할 수 있는 칸이 있으면 이동
				fish[cnt][i][0] = mr;
				fish[cnt][i][1] = mc;
				fish[cnt][map[cnt][mr][mc][0]][0] = r;
				fish[cnt][map[cnt][mr][mc][0]][1] = c;
				map[cnt][r][c][0] = map[cnt][mr][mc][0];
				map[cnt][r][c][1] = map[cnt][mr][mc][1];
				map[cnt][mr][mc][0] = i;
				map[cnt][mr][mc][1] = d;
				break;
			}
		}
		moveShark(map, fish, shark, cnt+1, sum);
	}
	
}
