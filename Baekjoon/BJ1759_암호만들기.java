package algostudy;

import java.io.*;
import java.util.*;

/** 1759. 암호 만들기 - C개 중 조건을 맞춰 L개 뽑는 조합
 * 암호는 서로 다른 L개의 알파벳 소문자들 중 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
 * 알파벳은 증가하는 순서로 배열되어있을 때, C개의 알파벳 문자들로 가능성 있는 암호들을 모두 구하라.
 */
public class BJ1759_암호만들기 {
	private static StringBuilder result = new StringBuilder();
	private static int L;
	private static int C;	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		char[] alphabet = new char[C];
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alphabet);
		
		// 알파벳 문자들로 가능한 암호 구하기
		char[] password = new char[L];
		makePassword(alphabet, password, 0, 0, 0);
		System.out.print(result);		
	}

	private static void makePassword(char[] alphabet, char[] password, int count, int moeum, int start) {
		if (count == L) {
			// 암호가 완성되면 조건에 맞는지 검사
			if (moeum >= 1 && moeum <= L-2) {
				for (int i = 0; i < L; i++) {
					result.append(password[i]);
				}
				result.append("\n");
			}
			return;
		}
		for (int i = start; i < C; i++) {
			char temp = alphabet[i];
			boolean isMoeum = false;
			if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
				isMoeum = true;
				moeum++;
			}
			password[count] = temp;
			makePassword(alphabet, password, count+1, moeum, i+1);
			if (isMoeum) moeum--;
		}
	}
}