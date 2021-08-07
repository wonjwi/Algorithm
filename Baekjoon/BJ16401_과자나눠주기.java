package week25;

import java.io.*;
import java.util.*;

public class BJ16401_과자나눠주기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int snack[] = new int[N], max = 1;

		// 과자의 길이 입력
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, snack[i]);
		}

		int min = 1, mid = 0, cnt, answer = 0;
		boolean flag;

		// 나눠줄 수 있는 과자의 최대 길이 구하기
		while (min <= max) {
			mid = (min + max) / 2;

			cnt = 0;
			flag = false;

			// mid만큼 과자를 나눠줄 수 있는지 확인
			for (int i = 0; i < N; i++) {
				cnt += snack[i] / mid;
				if (cnt >= M) {
					flag = true;
					break;
				}
			}
			
			// 결과에 따라 min, max 값 조정
			if (flag) {
				min = mid + 1;
				answer = mid;
			} else {
				max = mid - 1;
			}
		}

		System.out.println(answer);
	}

}
