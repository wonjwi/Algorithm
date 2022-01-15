package boj.contest;

import java.io.*;
import java.util.StringTokenizer;

public class hello2022_a {

	static boolean selected[];
	static int N, d, answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		selected = new boolean[d];

		for (int i = 1; i < d; i++) {
			selected[i] = true;
			find(1, i + "");
			selected[i] = false;
		}

		System.out.println(answer);
	}

	private static void find(int cnt, String str) {
		if (answer > 0) {
			return;
		}

		if (cnt == d) {
			int num = Integer.parseInt(str, d);

			if (num > N)
				answer = num;

			return;
		}

		for (int i = 0; i < d; i++) {
			if (selected[i])
				continue;

			selected[i] = true;
			find(cnt + 1, str + i);
			selected[i] = false;
		}
	}

}

//public class hello2022_a {
//
//	static boolean flag;
//	static int answer, max;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(in.readLine());
//
//		int N = Integer.parseInt(st.nextToken());
//		int d = Integer.parseInt(st.nextToken());
//
//		String str = "";
//		for (int i = d - 1; i >= 0; i--) {
//			str += i;
//		}
//		max = Integer.parseInt(str, d);
//
//		while (N < max) {
//			check(++N, d);
//
//			if (flag) {
//				break;
//			}
//		}
//
//		System.out.println(flag ? N : "-1");
//	}
//
//	public static void check(int num, int d) {
//		boolean checked[] = new boolean[d];
//
//		while (num > 0) {
//			if (checked[num % d]) {
//				return;
//			}
//			checked[num % d] = true;
//			num /= d;
//		}
//
//		for (int i = 0; i < d; i++) {
//			if (!checked[i]) {
//				return;
//			}
//		}
//
//		flag = true;
//	}
//
//}