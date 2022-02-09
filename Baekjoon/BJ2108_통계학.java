package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int num[] = new int[N];
		int cnt[] = new int[8001];
		int sum = 0, min = 4001, max = -4001;

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(in.readLine());
			cnt[num[i] + 4000]++;
			sum += num[i];
			min = Math.min(min, num[i]);
			max = Math.max(max, num[i]);
		}

		int maxCnt = 0, maxCntNum = 0;
		int sumCnt = 0, middleNum = 0;
		boolean flag = false;

		for (int i = 0; i <= 8000; i++) {
			if (cnt[i] == 0)
				continue;

			if (sumCnt <= N / 2) {
				sumCnt += cnt[i];
				middleNum = i;
			}

			if (maxCnt < cnt[i]) {
				maxCnt = cnt[i];
				maxCntNum = i;
				flag = true;
			} else if (maxCnt == cnt[i] && flag) {
				if (maxCntNum < i) {
					maxCntNum = i;
					flag = false;
				}
			}
		}

		System.out.println(Math.round((double) sum / N));
		System.out.println(middleNum - 4000);
		System.out.println(maxCntNum - 4000);
		System.out.println(max - min);
	}

}