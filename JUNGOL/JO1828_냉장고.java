package homework;

import java.io.*;
import java.util.*;

/**
 * 1828. 냉장고
 * 보관되어야 할 온도가 각기 다른 N개의 화학 물질 C1, C2, …, Cn이 있다. 
 * 각 Ci마다 최저 보관 온도 xi와 최고 보관 온도 yi가 정해져 있다. 
 * 화학 물질들을 모두 보관하기위해 최소로 필요한 냉장고의 대수를 구하라.
 */
public class JO1828_냉장고 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] temper = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			temper[i][0] = Integer.parseInt(st.nextToken());
			temper[i][1] = Integer.parseInt(st.nextToken());
		}
		// 최저온도와 최고온도를 오름차순 정렬
		Arrays.sort(temper, (int[] t1, int[] t2) -> {
			int diff = t1[0] - t2[0];
			return diff == 0 ? t1[1] - t2[1] : diff;
		});
		int cnt = 1, low = temper[0][0], high = temper[0][1];
		for (int i = 1; i < N; i++) {
			low = temper[i][0];
			// 전체 허용 범위를 넘으면 냉장고 추가
			if (temper[i][0] > high) {
				cnt++;
				high = temper[i][1];
			} 
			// 현재 최고기온이 기존보다 낮으면 교체
			else if (temper[i][1] < high) {
				high = temper[i][1];
			}
		}
		System.out.println(cnt);
	}
}
