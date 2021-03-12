package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1009_분산처리 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 데이터의 개수가 a^b일 때 마지막 데이터가 처리될 컴퓨터 번호 구하기
			// 각 숫자별 제곱수의 끝자리 구해두기
			int[][] ans = {{0, 0, 0, 0}, {1, 1, 1, 1}, {6, 2, 4, 8}, {1, 3, 9, 7}, {6, 4, 6, 4}, 
					{5, 5, 5, 5}, {6, 6, 6, 6}, {1, 7, 9, 3}, {6, 8, 4, 2}, {1, 9, 1, 9}};
			int result = ans[a%10][b%4];
			sb.append(result == 0 ? 10 : result).append("\n");
		}
		System.out.print(sb.toString());
	}

}
