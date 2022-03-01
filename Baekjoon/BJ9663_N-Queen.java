package algorithm;

import java.io.*;

public class Main {

	static int N, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		int selected[] = new int[N];

		queen(selected, 0);
		System.out.println(answer);
	}

	private static void queen(int[] selected, int cnt) {
		if (cnt == N) {
			answer++;
			return;
		}

		Loop: for (int i = 0; i < N; i++) {
			for (int j = 1; j <= cnt; j++) {
				int idx = cnt - j;
				if (selected[idx] == i || selected[idx] == i - j || selected[idx] == i + j)
					continue Loop;
			}
			selected[cnt] = i;
			queen(selected, cnt + 1);
		}
	}

}

//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		
//        int answer[] = { 0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596 };
//		int N = Integer.parseInt(in.readLine());
//		
//		System.out.println(answer[N]);
//	}
//
//}