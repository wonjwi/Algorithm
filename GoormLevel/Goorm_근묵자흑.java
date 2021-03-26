package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Goorm_근묵자흑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// N개의 정수 입력
		st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if (num[i] < min) {
				min = num[i];
				idx = i;
			}
		}
		if ((N-1)%(K-1) == 0) {
			System.out.println((N-1)/(K-1));
			return;
		}
		int right = N-1-idx; // 오른쪽에 있는 숫자 개수
		int cnt = 0;
		cnt += (idx/(K-1)) + ((idx%(K-1) == 0) ? 0 : 1);
		cnt += (right/(K-1)) + ((right%(K-1) == 0) ? 0 : 1);
		System.out.println(cnt);
	}

}
