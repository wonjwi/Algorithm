package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Goorm_사은품교환 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split(" ");
			long N = Long.parseLong(str[0]); // 시즌 한정 음료 쿠폰 수
			long M = Long.parseLong(str[1]); // 일반 음료 쿠폰 수
			// 보유한 쿠폰으로 교환할 수 있는 최대 상품의 수
			long total = Math.min(N/5, (N+M)/12);
			sb.append(total).append("\n");
		}
		System.out.println(sb.toString());
	}

}
