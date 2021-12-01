package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2920_음계 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		char prev, curr;
		boolean isAscending = false;

		prev = st.nextToken().charAt(0);

		// 1부터 시작한다면 ascending인지 검사
		if (prev == '1') {
			isAscending = true;
		}
		// 8부터 시작한다면 descending인지 검사
		// 그렇지 않다면 둘 다 아니므로 바로 종료
		else if (prev != '8') {
			System.out.println("mixed");
			return;
		}

		for (int i = 1; i < 8; i++) {
			curr = st.nextToken().charAt(0);

			// 이전 값과 현재 값을 비교해 조건을 만족하는지 검사
			if (!(isAscending && ((curr - prev) == 1)) && !(!isAscending && ((prev - curr) == 1))) {
				System.out.println("mixed");
				return;
			}
			
			prev = curr;
		}

		System.out.println(isAscending ? "ascending" : "descending");
	}
}