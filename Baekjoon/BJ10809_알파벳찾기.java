package algorithm;

import java.io.*;

public class BJ10809_알파벳찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = in.readLine();
		for (int i = 'a'; i <= 'z'; i++) {
			sb.append(str.indexOf(i)).append(" ");
		}
		System.out.println(sb.toString());
	}

}
