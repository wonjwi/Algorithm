package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(in.readLine());
		boolean num[] = new boolean[21];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			char oper = st.nextToken().charAt(1);

			if (oper == 'l') {
				for (int j = 1; j <= 20; j++) {
					num[j] = true;
				}
			} else if (oper == 'm') {
				for (int j = 1; j <= 20; j++) {
					num[j] = false;
				}
			} else {
				int x = Integer.parseInt(st.nextToken());

				switch (oper) {
				case 'd':
					num[x] = true;
					break;
				case 'e':
					num[x] = false;
					break;
				case 'h':
					sb.append(num[x] ? 1 : 0).append("\n");
					break;
				case 'o':
					num[x] = !num[x];
					break;
				}
			}
		}

		System.out.println(sb.toString());
	}

}

// 비트마스킹
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//		StringBuilder sb = new StringBuilder();
//
//		int M = Integer.parseInt(in.readLine());
//		int bit = 0;
//
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(in.readLine());
//			char oper = st.nextToken().charAt(1);
//
//			if (oper == 'l') {
//				bit = (1 << 20) - 1;
//			} else if (oper == 'm') {
//				bit &= 0;
//			} else {
//				int x = Integer.parseInt(st.nextToken());
//
//				switch (oper) {
//				case 'd':
//					bit |= (1 << x - 1);
//					break;
//				case 'e':
//					bit &= ~(1 << x - 1);
//					break;
//				case 'h':
//					sb.append((bit & (1 << x - 1)) == 0 ? 0 : 1).append("\n");
//					break;
//				case 'o':
//					bit ^= (1 << x - 1);
//					break;
//				}
//			}
//		}
//
//		System.out.println(sb.toString());
//	}
//
//}