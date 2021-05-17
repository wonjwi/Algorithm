package week16;

import java.io.*;

public class BJ1436_영화감독숌 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int answer = 666;
		while (true) {
			if ((answer+"").contains("666")) N--;
			if (N == 0) break;
			answer++;
		}
		System.out.println(answer);
	}

}
