package week06;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15787_은하수기차 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 좌석이 20개인 기차 N개
		int N = Integer.parseInt(st.nextToken());
		boolean[][] train = new boolean[N+1][21];
		
		// M번의 명령을 실행
		int M = Integer.parseInt(st.nextToken());
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(in.readLine());
			int i = 0, x = 0;
			char order = st.nextToken().charAt(0);
			switch (order) {
			case '1':
				i = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				train[i][x] = true;
				break;
			case '2':
				i = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				train[i][x] = false;
				break;
			case '3':
				i = Integer.parseInt(st.nextToken());
				for (int j = 20; j > 1; j--) {
					train[i][j] = train[i][j-1];
				}
				train[i][1] = false;
				break;
			case '4':
				i = Integer.parseInt(st.nextToken());
				for (int j = 1; j < 20; j++) {
					train[i][j] = train[i][j+1];
				}
				train[i][20] = false;
				break;
			}
		}
		// 은하수를 건널 수 있는 기차의 수 구하기
		int cnt = 1;
		for (int i = 2; i <= N; i++) {
			boolean isVaild = false;
			for (int j = 1; j < i; j++) {
				isVaild = false;
				for (int k = 1; k <= 20; k++) {
					// 승객 상태가 하나라도 다르면 건널 수 있음
					if (train[i][k] != train[j][k]) {
						isVaild = true;
					}
				}
				if (!isVaild) break;
			}
			if (isVaild) cnt++;
		}
		System.out.println(cnt);
	}

}
