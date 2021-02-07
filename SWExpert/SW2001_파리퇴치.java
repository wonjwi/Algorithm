package homework;

import java.io.*;
import java.util.StringTokenizer;

/** 2001. 파리 퇴치
 * N x N 배열 안의 숫자는 해당 영역에 존재하는 파리의 개수를 의미
 * M x M 크기의 파리채를 한 번 내리쳐 최대한 많은 파리를 죽이자
 */
class SW2001_파리퇴치 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// 파리의 개수 입력
			int[][] fly = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 죽은 파리의 최다 마리수 구하기
			int max = 0;
			for (int i = 0; i < N-M+1; i++) {
				for (int j = 0; j < N-M+1; j++) {
					int temp = 0;
					for (int i2 = 0; i2 < M; i2++) {
						for (int j2 = 0; j2 < M; j2++) {
							temp += fly[i+i2][j+j2];
						}
					}
					if (temp > max) {
						max = temp;
					}
				}
			}
			// 결과 출력
			System.out.println("#" + tc + " " + max);
		}
	}
}