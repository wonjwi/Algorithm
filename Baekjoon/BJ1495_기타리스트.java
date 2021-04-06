package week10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1495_기타리스트 {
	
	static int N, M, S, max = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 곡의 개수
		S = Integer.parseInt(st.nextToken()); // 시작 볼륨
		M = Integer.parseInt(st.nextToken()); // 최대 볼륨
		st = new StringTokenizer(in.readLine(), " ");
		
		// 시작 전에 바꿀 수 있는 볼륨의 리스트
		int[] V = new int[N];
		for (int i = 0; i < N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		// 마지막 곡을 연주할 수 있는 볼륨 중 최댓값
		boolean[][] isChecked = new boolean[N][M+1];
		DFS(V, isChecked, S, 0);
		System.out.println(max);
	}

	private static void DFS(int[] V, boolean[][] isChecked, int P, int cnt) {
		if (cnt == N) {
			max = Math.max(max, P);
			return;
		}
		if (isChecked[cnt][P]) return;
		isChecked[cnt][P] = true;
		if (P+V[cnt] <= M)
			DFS(V, isChecked, P+V[cnt], cnt+1);
		if (P-V[cnt] >= 0)
			DFS(V, isChecked, P-V[cnt], cnt+1);
	}

}
