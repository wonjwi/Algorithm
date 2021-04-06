package week10;
/*
RRRRRRRRRR
RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
 */
import java.io.*;
import java.util.Arrays;

public class BJ2602_돌다리건너기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] paper = in.readLine().toCharArray();
		char[][] bridge = new char[2][];
		bridge[0] = in.readLine().toCharArray(); // 악마
		bridge[1] = in.readLine().toCharArray(); // 천사
		
		// 악마/천사, 현재 밟은 다리 위치, 다음 두루마리 문자 위치
		int[][][] dp = new int[2][100][20];
		
		// dp 배열 초기값 넣기
		for (int a = 0; a < 2; a++) {
			for (int i = 0; i < 100; i++) {
				Arrays.fill(dp[a][i], -1);
			}
		}
		// 다리를 건너갈 수 있는 방법의 수
		int devil = move(dp, paper, bridge, 0, 0, 0);
		int angel = move(dp, paper, bridge, 1, 0, 0);
		System.out.println(devil+angel);
	}

	private static int move(int[][][] dp, char[] paper, char[][] bridge, int a, int idx, int cnt) {
		// 다리를 끝까지 건넜다.
		if (cnt == paper.length) {
			return 1;
		}
		// 이미 시도한 경우는 확인하지 않는다.
		if (dp[a][idx][cnt] > -1) return dp[a][idx][cnt];
		
		// 한 칸씩 건너보면서 경우의 수 확인
		int total = 0;
		for (int i = idx; i < bridge[0].length; i++) {
			if (paper[cnt] == bridge[a][i]) {
				total += move(dp, paper, bridge, (a+1)%2, i+1, cnt+1);
			}
		}
		return dp[a][idx][cnt] = total;
	}
	
}
