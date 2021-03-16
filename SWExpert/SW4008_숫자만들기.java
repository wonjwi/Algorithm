package week07;

import java.io.*;
import java.util.StringTokenizer;

public class SW4008_숫자만들기 {
	
	static int N, max, min;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			
			// 연산자 카드의 개수 (+, -, *, / 순)
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int plus = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			int multi = Integer.parseInt(st.nextToken());
			int divi = Integer.parseInt(st.nextToken());
			
			// 수식에 들어가는 N개의 숫자 (순서 변경 불가)
			st = new StringTokenizer(in.readLine(), " ");
			int[] numbers = new int[N];
			for (int i = 0; i < N; i++) {
				numbers[i] = st.nextToken().charAt(0)-'0';
			}
			// 연산자 카드를 이용해 수식을 만들기
			// 1. 수식은 연산자 카드를 모두 사용해서 완성
			// 2. 숫자와 숫자 사이에 연산자 1개만 들어가야 함
			// 3. 연산자는 우선 순위 따지지 않고 차례대로 계산
			// 4. 나눗셈을 할 때 소수점 이하는 버리기
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			permutation(numbers, plus, minus, multi, divi, 0, 0);
			sb.append("#").append(tc).append(" ").append(max-min).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void permutation(int[] numbers, int plus, int minus, int multi, int divi, int cnt, int sum) {
		if (cnt == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		// 제일 앞의 숫자는 그냥 넣기!
		if (cnt == 0) {
			permutation(numbers, plus, minus, multi, divi, cnt+1, sum+numbers[cnt]);
		}
		// 연산자 카드가 남아있으면 계산 시도
		if (plus > 0) {
			permutation(numbers, plus-1, minus, multi, divi, cnt+1, sum+numbers[cnt]);
		}
		if (minus > 0) {
			permutation(numbers, plus, minus-1, multi, divi, cnt+1, sum-numbers[cnt]);
		}
		if (multi > 0) {
			permutation(numbers, plus, minus, multi-1, divi, cnt+1, sum*numbers[cnt]);
		}
		if (divi > 0) {
			permutation(numbers, plus, minus, multi, divi-1, cnt+1, sum/numbers[cnt]);
		}
	}

}
