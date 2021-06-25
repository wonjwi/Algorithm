package week19;

import java.io.*;
import java.util.*;

public class BJ7573_고기잡이 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 모눈종이 크기
		int L = Integer.parseInt(st.nextToken()); // 그물의 길이
		int M = Integer.parseInt(st.nextToken()); // 물고기의 수
		int fish[][] = new int[M][2];

		// 각 물고기의 좌표 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			fish[i][0] = Integer.parseInt(st.nextToken());
			fish[i][1] = Integer.parseInt(st.nextToken());
		}

		// 물고기의 위치별로 시작점 잡기
		int r, c, w, cnt, answer = 0;
		for (int i = 0; i < M; i++) {
			r = fish[i][0]; // 세로 위치
			
			for (int j = 0; j < M; j++) {
				c = fish[j][1]; // 가로 위치
				
				// 가능한 그물 범위 모두 탐색
				for (int h = 1; h < L / 2; h++) {
					w = L / 2 - h; // 그물 가로 길이

					// 모눈종이 크기를 벗어나면 안 됨
					if (w >= N || h >= N) continue;

					// 잡을 수 있는 물고기의 수 구하기
					cnt = 0;
					for (int k = 0; k < M; k++) {
						if (r <= fish[k][0] && fish[k][0] <= r + h && c <= fish[k][1] && fish[k][1] <= c + w) {
							cnt++;
						}
					}
					answer = Math.max(answer, cnt);
				}
			}
		}

		System.out.println(answer);
	}

}
