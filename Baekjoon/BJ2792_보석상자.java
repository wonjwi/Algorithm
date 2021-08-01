package week24;

import java.io.*;
import java.util.*;

public class BJ2792_보석상자 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[M];
		int left = 1, right = 0, mid = 0, sum, answer = 0;

		// 각 색상별 보석의 개수
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			right = Math.max(right, arr[i]);
		}

		// 최솟값을 찾을 때까지 탐색
		while (left <= right) {
			// 질투심이 mid가 되도록 만들기
			mid = (left + right) / 2;
			sum = 0;
			for (int i = 0; i < M; i++) {
				sum += arr[i] / mid;
				if (arr[i] % mid != 0) {
					sum++;
				}
			}

			// 보석을 나눠줄 수 없다면 값 갱신
			if (sum > N) {
				left = mid + 1;
			} else {
				right = mid - 1;
				answer = mid;
			}
		}
		
		// 질투심의 최솟값 출력
		System.out.println(answer);
	}

}
