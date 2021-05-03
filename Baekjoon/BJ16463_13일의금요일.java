package week14;

import java.io.*;

public class BJ16463_13일의금요일 {
	
	static int days[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		// 2019년부터 N년까지 13일의 금요일의 수
		// 2019년 1월 1일은 화요일
		int answer = 0, date = 0;
		for (int year = 2019; year <= N; year++) {
			for (int month = 1; month <= 12; month++) {
				// 13일의 금요일인지 확인
				if ((date+12)%7 == 3) answer++;
				// 해당월 일수만큼 더하기
				date += days[month];
				// 윤년인 해는 2월이 29일까지 있음
				if (month == 2 && ((year%4 == 0 && year%100 != 0) || year%400 == 0)) date++;
			}
		}
		System.out.println(answer);
	}

}
