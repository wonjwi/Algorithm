package week05;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ13164_행복유치원 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 유치원생들의 키 차이 구하기
		int[] diff = new int[N-1];
		st = new StringTokenizer(in.readLine());
		int prev = Integer.parseInt(st.nextToken());
		diff[0] = 0;
		for (int i = 0; i < N-1; i++) {
			int curr = Integer.parseInt(st.nextToken());
			diff[i] = curr-prev;
			prev = curr;
		}
		// K개의 조로 나누어 티셔츠 맞추기
		// 티셔츠 비용의 최소: 차이가 작은 값을 N-K개 만큼 더하기
		Arrays.sort(diff); // 오름차순 정렬
		int sum = 0;
		for (int i = 0; i < N-K; i++) {
			sum += diff[i];
		}
		System.out.println(sum);
	}
}

//public class BJ13164_행복유치원 {
//	static int N, K, min = Integer.MAX_VALUE;
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(in.readLine());
//		N = Integer.parseInt(st.nextToken());
//		K = Integer.parseInt(st.nextToken());
//		// 유치원생들의 키
//		int[] kids = new int[N];
//		st = new StringTokenizer(in.readLine());
//		for (int i = 0; i < N; i++) {
//			kids[i] = Integer.parseInt(st.nextToken());
//		}
//		// K개의 조로 나누어 티셔츠 맞추기
//		pick(kids, 0, 0, 0, 0);
//		// 티셔츠 비용의 최소 출력
//		System.out.println(min);
//	}
//	private static void pick(int[] kids, int sum, int first, int cnt, int start) {
//		if (sum >= min) return;
//		if (cnt == K-1) {
//			sum += kids[N-1]-kids[first];
//			min = Math.min(min, sum);
//			return;
//		}
//		// 각 조의 마지막 사람 뽑기 (마지막-첫번째 사람 키)
//		for (int i = start; i < N; i++) {
//			pick(kids, sum+kids[i]-kids[first], i+1, cnt+1, i+1);
//		}
//	}
//}
