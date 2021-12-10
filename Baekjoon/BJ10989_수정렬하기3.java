package algorithm;

import java.io.*;
import java.util.*;

public class BJ10989_수정렬하기3 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int cnt[] = new int[10001], tmp;

		for (int i = 0; i < N; i++) {
			cnt[Integer.parseInt(in.readLine())]++;
		}

		for (int i = 1; i <= 10000; i++) {
			tmp = cnt[i];
			for (int j = 0; j < tmp; j++) {
				sb.append(i).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}