package algorithm;

import java.io.*;
import java.util.*;

public class BJ4153_직각삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int num[] = new int[3];
		int a, b;

		while (true) {
			st = new StringTokenizer(in.readLine());

			num[0] = Integer.parseInt(st.nextToken());
			num[1] = Integer.parseInt(st.nextToken());
			num[2] = Integer.parseInt(st.nextToken());

			if (num[0] == 0 && num[1] == 0 && num[2] == 0) {
				System.out.println(sb.toString());
				break;
			}

			Arrays.sort(num);
			a = num[0] * num[0] + num[1] * num[1];
			b = num[2] * num[2];

			if (a == b) {
				sb.append("right").append("\n");
			} else {
				sb.append("wrong").append("\n");
			}
		}
	}

}