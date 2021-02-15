package algostudy;

import java.io.*;
import java.util.*;

//5430. AC
//AC는 정수 배열에 연산을 하기 위해 만든 언어로 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.
//함수 R은 배열에 있는 숫자의 순서를 뒤집는 함수이고, D는 첫 번째 숫자를 버리는 함수이다. 
//배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하라
public class BJ5430_AC {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String p = in.readLine(); // 수행할 함수
			
			// 주어진 배열 저장
			int n = Integer.parseInt(in.readLine());
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str.substring(1, str.length()-1), ",");
			LinkedList<String> x = new LinkedList<String>();
			for (int i = 0; i < n; i++)
				x.add(st.nextToken());
//			if (n == 0) { // 숫자가 하나도 없는데 D가 없다면 []출력
//				if(!p.contains("D")) {
//					System.out.println("[]");
//				}
//			}
			
			// 함수 실행
			boolean flag = false; // 뒤집음 여부
			boolean error = false; // 에러 여부
			for (int i = 0; i < p.length(); i++) {
				if (error) break; // 에러가 나면 멈춤
				switch (p.charAt(i)) {
				case 'R':
					flag = flag ? false : true;
					break;
				case 'D':
					// 배열이 비어있으면 에러 발생
					if (x.size() <= 0) error = true;
					// 뒤집혀 있으면 끝을 아니면 앞을 제거
					else if (flag) x.remove(x.size()-1);
					else x.remove(0);
					break;
				}
			}
			if (error) sb.append("error\n");
			else {
				sb.append("[");
				if (flag) {
					while (!x.isEmpty()) sb.append(x.pollLast()).append(",");
				}
				else {
					while (!x.isEmpty()) sb.append(x.pollFirst()).append(",");
				}
				if (sb.lastIndexOf(",") == sb.length()-1) sb.setLength(sb.length()-1);
				sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
}