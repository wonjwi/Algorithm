package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2675_문자열반복 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스의 개수
		int R; // 반복 횟수
		String S; // 문자열
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			R = Integer.parseInt(st.nextToken()); // 반복 횟수
			S = st.nextToken();
			
			// 문자열 S의 각 문자를 R번 반복한 문자열 출력
			for (int j = 0; j < S.length(); j++) {
				for (int k = 0; k < R; k++) {
					sb.append(S.charAt(j));
				}
			}
			sb.append("\n");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}

}
