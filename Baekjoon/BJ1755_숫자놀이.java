package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1755_숫자놀이 {
	
	// 정수와 문자열을 함께 저장할 클래스
	static class Num implements Comparable<Num> {
		int num;
		String word;
		public Num(int num, String word) {
			super();
			this.num = num;
			this.word = word;
		}
		@Override
		public int compareTo(Num o) {
			// 숫자를 조건에 맞게 사전순으로 정렬
			return this.word.compareTo(o.word);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 입력 받은 문장 공백 단위로 쪼개기
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		// 입력 받은 값을 정수로 변환해서 저장하기
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// zero one two three four five six seven eight nine 문자열 배열
		String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		
		// 정수와 문자열을 함께 저장할 클래스 배열 생성
		Num[] num = new Num[N-M+1]; 
		for (int i = M; i <= N; i++) {
			// 숫자를 하나씩 읽은 것을 문자열로 만들기
			String tmp = (i/10 != 0) ? str[i/10]+" " : ""; // 십의 자리
			tmp += str[i%10]; // 일의 자리
			// 사전 순으로 정렬하기 위해 숫자와 문자열을 함께 저장
			num[i-M] = new Num(i, tmp);
		}
		
		// 숫자를 조건에 맞게 사전순으로 정렬
		Arrays.sort(num);
		
		// M 이상 N 이하의 정수를 한 줄에 10개씩 출력
		for (int i = 1; i <= num.length; i++) {
			sb.append(num[i-1].num).append(" ");
			// 10개 출력 시마다 줄 바꿈
			if (i%10 == 0) sb.append("\n");
		}
		// StringBuilder 출력
		System.out.println(sb.toString());
	}

}
