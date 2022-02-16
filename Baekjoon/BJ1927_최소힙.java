package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		Queue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(in.readLine());
			
			if (x == 0) {
				sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
			} else {
				pq.add(x);
			}
		}

		System.out.println(sb.toString());
	}

}