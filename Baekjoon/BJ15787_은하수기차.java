package week06;

import java.io.*;
import java.util.*;

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
			int i, x;
			char order = st.nextToken().charAt(0);
			i = Integer.parseInt(st.nextToken());
			switch (order) {
			case '1':
				x = Integer.parseInt(st.nextToken());
				train[i][x] = true;
				break;
			case '2':
				x = Integer.parseInt(st.nextToken());
				train[i][x] = false;
				break;
			case '3':
				for (int j = 20; j > 1; j--) {
					train[i][j] = train[i][j-1];
				}
				train[i][1] = false;
				break;
			case '4':
				for (int j = 1; j < 20; j++) {
					train[i][j] = train[i][j+1];
				}
				train[i][20] = false;
				break;
			}
		}
		// 은하수를 건널 수 있는 기차의 수 구하기
		Set<String> set = new HashSet<String>();
		StringBuilder sb;
		for (int i = 1; i <= N; i++) {
			sb = new StringBuilder();
			for (int x = 1; x <= 20; x++) {
				sb.append(train[i][x] ? '1' : '0');
			}
			set.add(sb.toString());
		}
		System.out.println(set.size());
	}
	
}