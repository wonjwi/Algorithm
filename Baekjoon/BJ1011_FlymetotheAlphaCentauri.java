package week17;

import java.io.*;
import java.util.*;

public class BJ1011_FlymetotheAlphaCentauri {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T, x, y;
		T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			// x지점에서 y지점으로 이동
			st = new StringTokenizer(in.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			sb.append(find(y - x)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int find(int distance) {
		int n = (int) Math.round(Math.sqrt(distance));
		if (distance <= Math.pow(n, 2)) {
			return 2 * n - 1;
		} else {
			return 2 * n;
		}
	}

}
