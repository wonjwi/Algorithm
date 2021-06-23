package week19;

import java.io.*;

// 수학
public class BJ1484_다이어트 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int G = Integer.parseInt(in.readLine());
		boolean flag = false;

		for (int i = 1; i < Math.sqrt(G); i++) {
			// 현재 몸무게로 가능하면 출력
			if (G % i == 0 && (i + G / i) % 2 == 0) {
				flag = true;
				sb.insert(0, "\n").insert(0, (i + G / i) / 2);
			}
		}
		
		if (flag)
			System.out.println(sb.toString());
		else
			System.out.println(-1);
	}

}

/*
// 두 포인터
public class BJ1484_다이어트 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int G = Integer.parseInt(in.readLine());
		int real = (int) Math.ceil(Math.sqrt(G));
		int memory = 1;
		boolean flag = false;

		while (true) {
			// 현재 몸무게로 가능하면 출력
			if (Math.pow(real, 2) == Math.pow(memory, 2) + G) {
				flag = true;
				sb.append(real).append("\n");
				real++;
				memory++;
			} else if (Math.pow(real, 2) > Math.pow(memory, 2) + G) {
				// 가능한 범위가 끝나면 종료
				if (real == memory + 1) break;
				memory++;
			} else {
				real++;
			}
		}
		
		if (flag)
			System.out.println(sb.toString());
		else
			System.out.println(-1);
	}

}
*/