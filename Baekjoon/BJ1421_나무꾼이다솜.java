package week24;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1421_나무꾼이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int length[] = new int[N];
		int max_length = 0, tree, cut;
		long total_tree, total_cut, answer = 0;

		// 가지고 있는 나무의 길이 입력
		for (int i = 0; i < N; i++) {
			length[i] = Integer.parseInt(in.readLine());
			max_length = Math.max(max_length, length[i]);
		}

		// 나무를 길이 1부터 L까지 잘라보기
		for (int L = 1; L <= max_length; L++) {
			total_cut = total_tree = 0;
			for (int i = 0; i < N; i++) {
				// 자른 나무 개수와 자르는 횟수 구하기
				cut = tree = length[i] / L;
				// 나누어 떨어지면 한 번 덜 잘라도 됨
				if (length[i] % L == 0) {
					cut--;
				}
				// 나무를 자르는 경우가 이득일 때
				if (tree * L * W > cut * C) {
					total_tree += tree;
					total_cut += cut;
				}
			}
			// 나무를 팔아서 벌 수 있는 돈 계산
			total_tree *= (L * W); // 판매 대금
			total_cut *= C; // 나무 자르는 비용
			answer = Math.max(answer, total_tree - total_cut);
		}

		System.out.println(answer);
	}

}
