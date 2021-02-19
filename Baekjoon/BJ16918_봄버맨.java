package algostudy;

import java.io.*;
import java.util.*;

public class BJ16918_봄버맨 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		// R×C 격자판의 초기 상태 (빈 칸은 . 폭탄은 O)
		char[][] map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		if (N%2 != 0) {
			for (int n = 0; n < N; n++) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						// 진행중인 폭탄을 처리
						switch (map[i][j]-'O') {
						case 0:
						case 1:
							// 마지막이면 폭탄 모양으로 만듦
							if (n == N-1) map[i][j] = 'O';
							else map[i][j]++;
							break;
							// 폭탄은 3초 후 폭발, 그 칸과 인접한 네 칸이 모두 빈 칸이 됨
						case 2:
							map[i][j] = '.';
							if (i > 0 && map[i-1][j] != 'Q') map[i-1][j] = '.';
							if (i+1 < R && map[i+1][j] != 'Q') map[i+1][j] = '.';
							if (j > 0 && map[i][j-1] != 'Q') map[i][j-1] = '.';
							if (j+1 < C && map[i][j+1] != 'Q') map[i][j+1] = '.';
							break;
						}
						// 봄버맨은 2초 간격으로 모든 빈 칸에 폭탄을 설치
						if (n%2 == 1) {
							if (map[i][j] == '.') map[i][j] = 'O';
						}
					}
				}
			}
			// N초가 지난 후 격자판 상태를 출력
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		else {
			// N초가 지난 후 격자판 상태를 출력
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append('O');
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}