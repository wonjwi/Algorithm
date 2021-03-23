package week08;

import java.io.*;

public class BJ1676_팩토리얼0의개수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		System.out.println(N/5 + N/25 + N/125);
	}

}
