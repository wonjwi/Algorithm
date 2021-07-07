package week21;

import java.io.*;
import java.util.*;

public class BJ1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A, B, kevin[][] = new int[N+1][N+1];

		// 친구 관계 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			kevin[B][A] = kevin[A][B] = 1;
		}
		
		// 케빈 베이컨 게임 진행 (플로이드-와샬)
		for (int i = 1; i <= N; i++) {
			for (int start = 1; start <= N; start++) {
				for (int end = 1; end <= N; end++) {
					// 서로 친구일 때만 경유 가능
					if (kevin[start][i] == 0 || kevin[i][end] == 0) continue;
					if (kevin[start][end] == 0 || kevin[start][i] + kevin[i][end] < kevin[start][end]) {
						kevin[end][start] = kevin[start][end] = kevin[start][i] + kevin[i][end];
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE, answer = 0;
		
		// 케빈 베이컨 수 구하기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				kevin[i][0] += kevin[i][j];
			}
			if (kevin[i][0] < min) {
				min = kevin[i][0];
				answer = i;
			}
		}

		// 케빈 베이컨 수가 가장 작은 사람
		System.out.println(answer);
	}

}
