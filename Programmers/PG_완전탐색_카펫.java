package week23;

import java.util.Arrays;

public class PG_완전탐색_카펫 {

	public static void main(String[] args) {
		// 갈색, 노란색으로 색칠된 격자의 개수
		int brown = 10, yellow = 2;
		
		// 카펫의 가로, 세로 크기 구하기
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}

	static public int[] solution(int brown, int yellow) {
		int w = 3, h = 3;
		
		while (true) {
			// 노란 격자의 수로 가로, 세로를 구할 수 있으면
			if (yellow % (h - 2) == 0) {
				// 세로에 맞는 가로 크기 구하기
				w = yellow / (h - 2) + 2;
				
				// 갈색 격자의 수가 일치하는 가로, 세로를 찾으면
				if ((w + h - 2) * 2 == brown) {
					break;
				}
			}
			h++;
		}
		
		return new int[] {w, h};
	}

}
