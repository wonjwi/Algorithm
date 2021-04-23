package week12;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1965_상자넣기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] box = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		// 한 번에 넣을 수 있는 상자의 최대 개수
		int[] LIS = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			LIS[i] = 1; // 상자를 넣어보기 시작하는 초기값
			for (int j = 0; j < i; j++) {
				if (box[j] < box[i] && LIS[i] < LIS[j]+1) {
					LIS[i] = LIS[j]+1; // 앞에 붙여서 값이 더 크면 교체
				}
			}
			max = Math.max(max, LIS[i]);
		}
		System.out.println(max);
	}

}
