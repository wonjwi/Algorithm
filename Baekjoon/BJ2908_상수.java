package algorithm;

import java.io.*;

public class BJ2908_상수 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char arr[] = in.readLine().toCharArray(); // 두 수 입력

		// 실제 숫자 값으로 변환
		for (int i = 0; i < arr.length; i++) {
			arr[i] -= '0';
		}

		// 두 수를 거꾸로 뒤집기
		int num1 = arr[2] * 100 + arr[1] * 10 + arr[0];
		int num2 = arr[6] * 100 + arr[5] * 10 + arr[4];

		// 뒤집은 후 더 큰 숫자 출력
		System.out.println(num1 > num2 ? num1 : num2);
	}

}
