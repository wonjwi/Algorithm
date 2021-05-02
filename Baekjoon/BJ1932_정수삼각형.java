package week13;

import java.io.*;
import java.util.*;

public class BJ1932_정수삼각형 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(in.readLine());
		int map[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 가장자리의 값 미리 구하기
		for (int i = 1; i < n; i++) {
			map[i][0] += map[i-1][0];
			map[i][i] += map[i-1][i-1];
		}
		// 현재 선택된 수의 대각선 왼쪽/오른쪽에서 선택
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				map[i][j] += Math.max(map[i-1][j-1], map[i-1][j]);
			}
		}
		// 합이 최대가 되는 경로의 합
		Arrays.sort(map[n-1]);
		System.out.println(map[n-1][n-1]);
	}

}
/*
public class BJ1932_정수삼각형 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(in.readLine());
		int map[][] = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 현재 선택된 수의 대각선 왼쪽/오른쪽에서 선택
				map[i][j] += Math.max(map[i-1][j-1], map[i-1][j]);
			}
		}
		// 합이 최대가 되는 경로의 합
		Arrays.sort(map[n]);
		System.out.println(map[n][n]);
	}
	
}
*/