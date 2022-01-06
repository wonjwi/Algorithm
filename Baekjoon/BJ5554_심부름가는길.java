package algorithm;

import java.io.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int second = Integer.parseInt(in.readLine());
		second += Integer.parseInt(in.readLine());
		second += Integer.parseInt(in.readLine());
		second += Integer.parseInt(in.readLine());

		System.out.println(second / 60 + "\n" + second % 60);
	}

}