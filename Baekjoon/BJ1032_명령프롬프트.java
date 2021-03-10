package algorithm;

import java.io.*;

public class BJ1032_명령프롬프트 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		// 파일 이름 입력
		String str[] = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = in.readLine();
		}
		// 패턴 구하기
		int len = str[0].length();
		String result = "";
		for (int i = 0; i < len; i++) {
			boolean fail = false;
			for (int j = 1; j < N; j++) {
				if (str[j-1].charAt(i) != str[j].charAt(i)) {
					fail = true; 
					break;
				}
			}
			if (fail) result += '?';
			else result += str[0].charAt(i);
		}
		System.out.println(result);
	}

}
