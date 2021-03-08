package week06;

import java.io.*;
import java.util.*;

public class BJ14501_퇴사 {
	
	static class Work {
		int date;
		int pay;
		
		public Work(int date, int pay) {
			this.date = date;
			this.pay = pay;
		}
	}
	static int N, maxOfPay;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		// 상담을 완료하는데 걸리는 기간과 상담을 했을 때 받을 수 있는 금액
		Work[] work = new Work[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int date = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());
			work[i] = new Work(date, pay);
		}
		
		// N일 동안 상담을 했을 때 얻을 수 있는 최대 수익 구하기
		select(work, 0, 0);
		System.out.println(maxOfPay);
	}

	private static void select(Work[] work, int cnt, int sumOfPay) {
		// 상담을 마치면 총 수익으로 최대 수익 갱신
		if (cnt == N) {
			maxOfPay = Math.max(maxOfPay, sumOfPay);
			return;
		}
		int date = work[cnt].date;
		int pay = work[cnt].pay;
		// N일을 넘지 않는 선에서 상담을 진행
		if (cnt+date <= N) {
			select(work, cnt+date, sumOfPay+pay);
		}
		select(work, cnt+1, sumOfPay);
	}

}
