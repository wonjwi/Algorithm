package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1152_단어의개수 {

	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim(), " ");
		System.out.println(st.countTokens());
	}

}
