package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		V -= A;
		V = Math.max(V, 0);

		System.out.println(V % (A - B) == 0 ? V / (A - B) + 1 : V / (A - B) + 2);
	}

}