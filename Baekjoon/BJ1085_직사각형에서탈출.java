package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1085_직사각형에서탈출 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int min = 0;

		if (x < w - x) {
			min = x;
		} else {
			min = w - x;
		}
		if (y < h - y) {
			min = min < y ? min : y;
		} else {
			min = min < h - y ? min : h - y;
		}

		System.out.println(min);
	}

}
