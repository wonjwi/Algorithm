package ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ12871_무한문자열 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 알파벳 소문자로 이루어진 문자열 s, t
		String s = in.readLine();
		String t = in.readLine();
		// 두 문자열의 길이를 50 이상으로 맞추기
		while (s.length() < 100) s += s;
		while (t.length() < 100) t += t;
		// 두 문자열이 같은 문자열을 만드는지 검사
		boolean flag = true;
		for (int i = 0; i < 100; i++) {
			if (s.charAt(i) != t.charAt(i)) flag = false;
		}
		System.out.println(flag ? 1 : 0);
	}

}
