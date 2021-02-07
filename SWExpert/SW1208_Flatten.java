package com.ssafy.algo;

import java.util.Scanner;
import java.io.FileInputStream;

// 1208. [S/W 문제해결 기본] 1일차 - Flatten
// 가로 길이는 항상 100
// 모든 위치에서 상자의 높이는 1 이상 100 이하
// 덤프 횟수는 1 이상 1000 이하
// 주어진 횟수 이내에 평탄화가 끝나면 더 이상 덤프 수행이 불가하므로
// 그 때의 최고점과 최저점의 높이 차를 반환 (data에 따라 0 또는 1)
// 테스트 케이스는 총 10개
//----------------------------------------------
//for (i=0; i<N; i++) {
//	box[i] = 각 상자의 높이값;
//}
//while (true) {
//	box의 MAX 구하기;
//	box의 MIN 구하기;
//	if (dump == 0 || box[MAX i] - box[MIN i] <= 1)
//		break;
//	box[MAX i]--;
//	box[MIN i]++;
//	dump--;
//}
//print(box[MAX i] - box[MIN i]);
class SW1208_Flatten {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int N = 100;
		for (int tc = 1; tc <= T; tc++) {
			int dump = sc.nextInt(); // 덤프 횟수
			// 각 상자의 높이값 저장
			int box[] = new int[N];
			for (int i = 0; i < N; i++) {
				box[i] = sc.nextInt();
			}
			// 최고점과 최저점 구하기
			int max = 0;
			int min = 101;
			int maxI = -1;
			int minI = -1;
			while (true) {
				for (int i = 0; i < N; i++) {
					if (box[i] < min) {
						min = box[i];
						minI = i;
					}
					if (box[i] > max) {
						max = box[i];
						maxI = i;
					}
				}
				// 덤프 횟수가 0이거나 평탄화가 완료되면 종료
				if (dump == 0 || box[maxI] - box[minI] <= 1)
					break;
				// 덤프 수행
				box[maxI]--;
				max--;
				box[minI]++;
				min++;
				dump--;
			}
			// 결과 출력
			System.out.printf("#%d %d\n", tc, max - min);
		}
	}
}