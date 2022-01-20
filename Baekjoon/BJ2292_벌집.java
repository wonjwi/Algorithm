package algorithm;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine()) - 1;
		int room = 1;

		while (N > 0) {
			N -= 6 * room++;
		}

		System.out.println(room);
	}

}