package week19;

import java.io.*;
import java.util.*;

public class BJ10434_행복한소수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int P = Integer.parseInt(in.readLine());
		int M, sum, tmp;
		boolean isNotPrime[] = new boolean[10001];
		String answer;
		
		// 제한범위 내에서 소수 구하기
		isNotPrime[1] = true;
		for (int i = 2; i <= 100; i++) {
			if (isNotPrime[i]) continue;
			for (int j = i + i; j <= 10000; j += i) {
				isNotPrime[j] = true;
			}
		}
		
		for (int tc = 1; tc <= P; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			sb.append(st.nextToken()).append(" ");
			M = Integer.parseInt(st.nextToken());
			sb.append(M).append(" ");
			
			// 행복한 소수인지 판정
			answer = "NO";
			if (!isNotPrime[M]) { // 소수일 때만 탐색
				// 자리수의 제곱을 큐에 저장
				Queue<Integer> queue = new LinkedList<Integer>();
				while (M > 0) {
					tmp = M % 10;
					queue.add(tmp * tmp);
					M /= 10;
				}
				// 행복한 수인지 판정
				while (true) {
					sum = 0;
					while (!queue.isEmpty()) {
						sum += queue.poll();
					}
					// 합이 1인 수는 행복한 수
					if (sum < 10) {
						if (sum == 1 || sum == 7) answer = "YES";
						break;
					}
					// 그렇지 않으면 계속 탐색
					while (sum > 0) {
						tmp = sum % 10;
						queue.add(tmp * tmp);
						sum /= 10;
					}
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
