package ssafy.workshop;

import java.io.*;
import java.util.StringTokenizer;

public class SW2115_벌꿀채취 {
	
	static int N, M, C, maxSum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			// 벌통마다 채취할 수 있는 꿀의 양
			int map[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 꿀을 채취하여 얻을 수 있는 최대 수익
			sb.append("#").append(tc).append(" ").append(getMaxBenefit(map)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int getMaxBenefit(int[][] map) {
		int answer = 0, aBenefit = 0, bBenefit = 0;
		
		// 가능한 경우의 수에 대해 미리 계산 해두기
		int[][] maxValue = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				maxSum = 0;
				makeMaxSubset(map, i, j, 0, 0, 0);
				maxValue[i][j] = maxSum;
			}
		}
		// 일꾼 A의 선택
		// 첫 행부터 마지막 행까지
		for (int i = 0; i < N; i++) {
			// 첫 열부터 연속된 M개의 채취가 가능한 열까지
			for (int j = 0; j <= N-M; j++) {
				// 선택된 M개의 벌통에서 얻을 수 있는 최대 이익
				aBenefit = maxValue[i][j];
				
				// 일꾼 B의 선택
				// A와 같은 행의 뒤쪽 열에서 선택
				bBenefit = 0;
				for (int j2 = j+M; j2 <= N-M; j2++) {
					bBenefit = Math.max(bBenefit, maxValue[i][j2]);
				}
				// A의 다음 행부터 마지막 행까지
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N-M; j2++) {
						bBenefit = Math.max(bBenefit, maxValue[i2][j2]);
					}
				}
				answer = Math.max(answer, aBenefit+bBenefit);
			}
		}
		return answer;
	}

	private static void makeMaxSubset(int[][] map, int i, int j, int cnt, int sum, int powerSum) {
		// 채취할 수 있는 양을 초과할 때
		if (sum > C) return;
		// 마지막 벌통까지 선택/비선택 완료
		if (cnt == M) {
			maxSum = Math.max(maxSum, powerSum);
			return;
		}
		// 해당 위치의 벌통 선택
		makeMaxSubset(map, i, j+1, cnt+1, sum+map[i][j], powerSum+(map[i][j]*map[i][j]));
		// 해당 위치의 벌통 비선택
		makeMaxSubset(map, i, j+1, cnt+1, sum, powerSum);
	}

}
