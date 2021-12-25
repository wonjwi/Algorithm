package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String pokemon[] = new String[N + 1];
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			pokemon[i] = in.readLine();
			map.put(pokemon[i], i);
		}

		String tmp;
		int num;

		for (int i = 0; i < M; i++) {
			tmp = in.readLine();

			if (map.containsKey(tmp)) {
				sb.append(map.get(tmp)).append("\n");
			} else {
				num = Integer.parseInt(tmp);
				sb.append(pokemon[num]).append("\n");
			}
		}

		System.out.println(sb.toString());
	}

}