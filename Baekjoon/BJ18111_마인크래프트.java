package algorithm;

import java.io.*;
import java.util.*;

public class BJ18111_마인크래프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		int minTime = Integer.MAX_VALUE, minHeight = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int h = 0; h <= 256; h++) {
			int time = 0;
			int inven = B;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int tmp = map[i][j] - h;

					if (tmp > 0) {
						time += 2 * tmp;
					} else {
						time -= tmp;
					}

					inven += tmp;
				}
			}

			if (inven < 0)
				continue;

			if (time <= minTime) {
				minTime = time;
				minHeight = h;
			}
		}

		System.out.println(minTime + " " + minHeight);
	}

}