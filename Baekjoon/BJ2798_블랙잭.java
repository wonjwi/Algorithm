package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2798_블랙잭 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int num[] = new int[N];
		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		// M을 넘지 않으면서 M과 가장 가까운 수 찾기
		int tmp, result = 0;

		// 3장의 카드로 만들 수 있는 모든 경우의 수 탐색
		Loop: for (int i = 0; i < N; i++) {
			tmp = num[i];
			if (tmp > M) {
				continue;
			}
			for (int j = i + 1; j < N; j++) {
				tmp = num[i] + num[j];
				if (tmp > M) {
					continue;
				}
				for (int k = j + 1; k < N; k++) {
					tmp = num[i] + num[j] + num[k];
					if (tmp > M) {
						continue;
					}
					// M과 같은 값을 만들 수 있는 경우
					if (tmp == M) {
						result = M;
						break Loop;
					}
					// 그렇지 않으면 최대값 갱신
					result = Math.max(result, tmp);
				}
			}
		}

		System.out.println(result);
	}

}
