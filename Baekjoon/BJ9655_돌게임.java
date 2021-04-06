package week10;

import java.io.*;

public class BJ9655_돌게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 돌의 개수
		// 두 사람이 번갈아가면서 돌을 1개 또는 3개 가져간다.
		// 마지막 돌을 가져가는 사람이 이긴다.
		// 게임을 상근이가 먼저 시작할 때, 이기는 사람은?
		System.out.println(N%2 == 0 ? "CY" : "SK");
	}
	
}
