package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int coin[] = new int[N];
		int answer = 0, idx = N - 1;

		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}

		while (K > 0) {
			answer += K / coin[idx];
			K %= coin[idx--];
		}

		System.out.println(answer);
	}

}