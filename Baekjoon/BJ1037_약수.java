package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		int min = Integer.MAX_VALUE, max = 0, x;

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(st.nextToken());

			min = Math.min(min, x);
			max = Math.max(max, x);
		}

		System.out.println(min * max);
	}

}