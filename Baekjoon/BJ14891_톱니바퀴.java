package algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14891_톱니바퀴 {
	
	static int K, pointer[] = new int[5];
	static boolean magnet[][] = new boolean[5][8];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 1~4번 자석의 자성 정보
		for (int i = 1; i <= 4; i++) {
			String str = in.readLine();
			for (int j = 0; j < 8; j++) {
				if (str.charAt(j) == '1') magnet[i][j] = true;
				else magnet[i][j] = false;
			}
		}
		Arrays.fill(pointer, 0); // 화살표 위치 인덱스
		
		// 자석을 회전시키는 회전 정보
		K = Integer.parseInt(in.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			rotate(num, dir);
		}
		
		// 최종 자석 상태로 점수 계산
		System.out.println(getPoint());
	}

	private static int getPoint() {
		int answer = 0;
		for (int i = 1; i <= 4; i++) {
			if (magnet[i][pointer[i]]) answer += Math.pow(2, i-1);
		}
		return answer;
	}

	private static void rotate(int num, int dir) {
		boolean flag[] = new boolean[5];
		flag[num] = true;
		
		// 맞붙은 자석들을 확인
		int idx = num;
		for (int i = num-1; i >= 1; i--) {
			if (magnet[i][(pointer[i]+2)%8] != magnet[idx][(pointer[idx--]+6)%8]) flag[i] = true;
			else break;
		}
		idx = num;
		for (int i = num+1; i <= 4; i++) {
			if (magnet[idx][(pointer[idx++]+2)%8] != magnet[i][(pointer[i]+6)%8]) flag[i] = true;
			else break;
		}
		
		// 자석들을 회전 시킴
		for (int i = 1; i <= 4; i++) {
			if (!flag[i]) continue;
			pointer[i] += Math.abs(num-i)%2 == 1 ? dir : -dir;
			if (pointer[i] < 0) pointer[i] = 7;
			else if (pointer[i] >= 8) pointer[i] = 0;
		}
	}

}
