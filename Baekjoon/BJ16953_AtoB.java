package ssafy.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ16953_AtoB {
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		// A를 B로 바꾸는데 필요한 연산의 최솟값 구하기
		make(A, B, 0);
		// 최솟값에 1을 더한 값 혹 만들 수 없으면 -1 출력
		System.out.println(min == Integer.MAX_VALUE ? -1 : min+1);
	}

	private static void make(long A, long B, int cnt) {
		if (A > B) return;
		if (A == B) {
			min = Math.min(min, cnt);
			return;
		}
		make(A*2, B, cnt+1);
		make(A*10+1, B, cnt+1);
	}

}
