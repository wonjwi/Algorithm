package week14;

import java.io.*;

public class BJ1013_Contact {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			// (100+1+ | 01)+ 패턴을 만족하는가?
			String wave = in.readLine();
			sb.append(pattern(wave) ? "YES\n" : "NO\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean pattern(String radio) {
		int len = radio.length();
		char state = 'A';
		for (int i = 0; i < len; i++) {
			char num = radio.charAt(i);
			state = getState(state, num);
			if (state == 'Z') return false;
		}
		if (state == 'A' || state == 'D' || state == 'G' || state == 'H') return true;
		return false;
	}

	private static char getState(char state, char num) {
		// A : 시작
		// B : 0
		// C : 1
		// D : 01
		// E : 10
		// F : 100+
		// G : 100+1
		// H : 100+1+
		// I : 100+1+0
		if (num == '0') {
			switch (state) {
			case 'A':
			case 'D':
			case 'G':
				return 'B';
			case 'C':
				return 'E';
			case 'E':
			case 'F':
			case 'I':
				return 'F';
			case 'H':
				return 'I';
			}
		}
		if (num == '1') {
			switch (state) {
			case 'A':
			case 'D':
				return 'C';
			case 'B':
				return 'D';
			case 'F':
				return 'G';
			case 'G':
			case 'H':
				return 'H';
			case 'I':
				return 'A';
			}
		}
		return 'Z';
	}

}
/*
import java.util.regex.Pattern;

public class BJ1013_Contact {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String pattern = "(100+1+|01)+";
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			// (100+1+ | 01)+ 패턴을 만족하는가?
			String wave = in.readLine();
			sb.append(Pattern.matches(pattern, wave) ? "YES\n" : "NO\n");
		}
		System.out.println(sb.toString());
	}
	
}
*/