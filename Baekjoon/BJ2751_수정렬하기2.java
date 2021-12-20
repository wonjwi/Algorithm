package algorithm;

import java.io.*;

public class BJ2751_수정렬하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		boolean checked[] = new boolean[2000001];

		for (int i = 0; i < N; i++) {
			checked[Integer.parseInt(in.readLine()) + 1000000] = true;
		}

		for (int i = 0; i <= 2000000; i++) {
			if (checked[i]) {
				sb.append(i - 1000000).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}