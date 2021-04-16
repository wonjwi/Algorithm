package week11;

import java.io.*;
import java.util.StringTokenizer;

public class BJ6987_월드컵 {
	
	static int[][] map = new int[6][3];
	static boolean ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 4; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			// 입력으로 주어진 결과 : 승, 무승부, 패
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = st.nextToken().charAt(0) - '0';
				}
			}
			// 각 국가별로 조별리그 실행
			ans = false;
			playGame(0, 1);
			// 가능한 결과는 1, 불가능한 결과는 0
			System.out.print((ans ? 1 : 0) + " ");
		}
	}

	private static void playGame(int i, int j) {
		// 모든 경기가 이뤄짐
		if (i == 5) {
			if (checkMap()) ans = true;
			return;
		}
		
		// i는 승, j는 패
		if (map[i][0] > 0 && map[j][2] > 0) {
			map[i][0]--; 
			map[j][2]--;
			if (j < 5) playGame(i, j+1);
			else playGame(i+1, i+2); 
			map[i][0]++; 
			map[j][2]++;
		}
		// i, j가 무승부
		if (map[i][1] > 0 && map[j][1] > 0) {
			map[i][1]--; 
			map[j][1]--;
			if (j < 5) playGame(i, j+1);
			else playGame(i+1, i+2); 
			map[i][1]++; 
			map[j][1]++;
		}
		// i는 패, j는 승
		if (map[i][2] > 0 && map[j][0] > 0) {
			map[i][2]--; 
			map[j][0]--;
			if (j < 5) playGame(i, j+1);
			else playGame(i+1, i+2); 
			map[i][2]++; 
			map[j][0]++;
		}
	}

	private static boolean checkMap() {
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				sum += map[i][j];
			}
		}
		if (sum == 0) return true;
		return false;
	}

}
