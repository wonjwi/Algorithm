package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		int H, W, N, floor, room;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());

			H = Integer.parseInt(st.nextToken()); // 호텔의 층 수
			W = Integer.parseInt(st.nextToken()); // 각 층의 방 수
			N = Integer.parseInt(st.nextToken()); // 손님의 순서

			floor = N % H == 0 ? H : N % H;
			room = N % H == 0 ? N / H : N / H + 1;

			sb.append(floor).append(room < 10 ? "0" : "").append(room).append("\n");
		}

		System.out.println(sb.toString());
	}

}