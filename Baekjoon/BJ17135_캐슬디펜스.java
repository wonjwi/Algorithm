package com.ssafy.algo;

import java.io.*;
import java.util.*;

public class BJ17135_캐슬디펜스 {
	static int max = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		// 0은 빈 칸, 1은 적이 있는 칸
		char[][] map = new char[N][M];
		ArrayList<int[]> enemy = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				char temp = st.nextToken().charAt(0);
				map[i][j] = temp;
				if (temp == '1') enemy.add(new int[] {i, j});
			}
		}
		combination(map, N, M, D, enemy, new int[3], 0, 0);
		System.out.println(max);
	}
	private static void combination(char[][] map, int N, int M, int D, ArrayList<int[]> enemy, int[] shooter, int cnt, int start) {
		// 궁수 3명 배치 완료
		if (cnt == 3) {
			defense(map, N, M, D, (ArrayList<int[]>)enemy.clone(), shooter, 0, 0);
			return;
		}
		for (int i = start; i < M; i++) {
			shooter[cnt] = i;
			combination(map, N, M, D, enemy, shooter, cnt+1, i+1);
		}
	}
	private static void defense(char[][] map, int N, int M, int D, ArrayList<int[]> enemy, int[] shooter, int die, int move) {
		// 적이 성이 있는 칸에 도착하면 게임에서 제외
		for (int i = 0; i < enemy.size(); i++) {
			if (enemy.get(i)[0]+move >= N) {
				enemy.remove(i); i--;
			}
		}
		// 모든 적이 없어지면 게임 종료
		if (enemy.isEmpty()) {
			max = Math.max(max, die);
			return;
		}
		// 가장 가깝고 왼쪽에 있는 적을 찾기
		ArrayList<int[]> shootEnemy = new ArrayList<int[]>();
		for (int i = 0; i < 3; i++) {
			int minIdx = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < enemy.size(); j++) {
				int temp = N-(enemy.get(j)[0]+move) + Math.abs(shooter[i]-enemy.get(j)[1]);
				if (temp < min) {
					min = temp;
					minIdx = j;
				}
				else if (temp == min && enemy.get(j)[1] < enemy.get(minIdx)[1]) {
					minIdx = j;
				}
			}
			// 사거리 안의 적이면 공격
			if (min <= D)
				shootEnemy.add(enemy.get(minIdx));
		}
		// 공격받은 적은 게임에서 제외
		for (int i = 0; i < shootEnemy.size(); i++) {
			if (enemy.remove(shootEnemy.get(i))) die++;
		}
		// 게임 진행을 반복
		defense(map, N, M, D, enemy, shooter, die, move+1);
	}
}
