package week05;

import java.io.*;
import java.util.StringTokenizer;

public class BJ20363_당근키우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		// 큰 값부터 계산
		if (X < Y) {
			int tmp = X;
			X = Y;
			Y = tmp;
		}
		int sum = X + (Y/10) + Y;
		System.out.println(sum);
	}
}
