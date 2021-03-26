package week08;

import java.io.*;
import java.util.StringTokenizer;

public class BJ18429_근손실 {
	
	static int N, K, total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 각 운동 키트의 중량 증가량
		st = new StringTokenizer(in.readLine(), " ");
		int[] kit = new int[N];
		for (int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		permutation(kit, new boolean[N], 0, 0);
		System.out.println(total);
	}

	private static void permutation(int[] kit, boolean[] selected, int cnt, int weight) {
		if (cnt == N) {
			total++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (selected[i] || weight+kit[i]-K < 0) continue;
			selected[i] = true;
			permutation(kit, selected, cnt+1, weight+kit[i]-K);
			selected[i] = false;
		}
	}

}
