package algorithm;

import java.io.*;

public class BJ9935_문자열폭발 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = in.readLine();
		String bomb = in.readLine();
		char answer[] = new char[1000000];
		int idx = 0, j, len = bomb.length(), size;
		boolean flag = false;
		
		// 문자열에서 폭발 문자열을 제거
		for (int i = 0; i < str.length(); i++) {
			answer[idx++] = str.charAt(i);
			
			// 폭발 문자열 찾기
			j = len; // 마지막 글자부터 비교
			if (i >= len - 1 && str.charAt(i) == bomb.charAt(--j)) {
				flag = true;
				size = idx - len;
				for (int k = idx - 1; k >= size; k--) {
					if (answer[k] != bomb.charAt(j--)) {
						flag = false;
						break;
					}
				}
				// 폭발 문자열과 일치하면 제거
				if (flag) {
					idx -= len;
				}
			}
		}
		
		if (idx == 0) {
			System.out.println("FRULA");
		} else {
			for (int i = 0; i < idx; i++) {
				sb.append(answer[i]);
			}
			System.out.println(sb.toString());
		}
	}

}
