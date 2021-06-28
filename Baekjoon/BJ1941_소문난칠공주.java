package week19;

import java.io.*;
import java.util.Arrays;

public class BJ1941_소문난칠공주 {

	static char map[];
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		map = new char[25];
		for (int i = 0; i < 5; i++) {
			String str = in.readLine();
			for (int j = 0; j < 5; j++) {
				map[i * 5 + j] = str.charAt(j);
			}
		}

		// 소문난 칠공주를 결성할 수 있는 경우의 수
		seven(new int[7], 0, 0, 0);
		System.out.println(answer);
	}

	private static void seven(int[] combi, int cnt, int yCnt, int start) {
		// 임도연파가 많아지면 종료
		if (yCnt >= 4) return;

		// 소문난 칠공주를 결성하면 종료
		if (cnt == 7) {
			// 서로 인접해있는지 확인
			boolean flag;
			int a[], b[];
			for (int i = 0; i < 7; i++) {
				flag = false;
				a = new int[] { combi[i] / 5, combi[i] % 5 };
				for (int j = 0; j < 7; j++) {
					b = new int[] { combi[j] / 5, combi[j] % 5 };
					if (Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]) == 1) {
						flag = true;
						break;
					}
				}
				// 인접한 사람이 하나도 없으면
				if (!flag) return;
			}
			System.out.println(Arrays.toString(combi));
			answer++;
			return;
		}

		for (int i = start; i < 25; i++) {
			combi[cnt] = i;
			seven(combi, cnt + 1, yCnt + (map[i] == 'Y' ? 1 : 0), i + 1);
		}
	}

}
