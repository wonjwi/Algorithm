package week09;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2502_떡먹는호랑이 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int D = Integer.parseInt(st.nextToken()); // 할머니가 넘어온 날
		int K = Integer.parseInt(st.nextToken()); // 그 날 호랑이에게 준 떡의 개수
		
		// 첫 날에 준 떡의 개수 A, 둘째 날에 준 떡의 개수 B
		// K = x*A + y*B에서 날짜마다의 x, y 값 미리 구하기
		int x=-1, x1=1, x2=0, y=-1, y1=0, y2=1;
		for (int i = 3; i <= D; i++) {
			x = x1+x2;
			y = y1+y2;
			x1 = x2; x2 = x;
			y1 = y2; y2 = y;
		}
		// 찾은 x, y 값을 이용해서 A, B 값 찾기
		int A = 1, B = 1;
		while (true) {
			if ((K-x*A)%y == 0) {
				B = (K-x*A)/y;
				break;
			}
			A++;
		}
		System.out.println(A+"\n"+B);
	}
	
}
