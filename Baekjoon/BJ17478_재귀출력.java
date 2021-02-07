package com.ssafy.algo;

import java.util.Scanner;

/**
 * 17478. 재귀함수가 뭔가요? 
 * 출력을 원하는 재귀 횟수 N (1 <= N <= 50) 
 * 재귀 횟수에 따른 챗봇의 응답을 출력
 * 
 * 기저조건 : N이 0이 되면, 단위반복 : 챗봇의 응답 출력
 */
public class BJ17478_재귀출력 {
	static StringBuilder sb = new StringBuilder();

	static String str1 = "\"재귀함수가 뭔가요?\"\n";
	static String str2[] = { "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"};
	static String str3 = "라고 답변하였지.\n";
	static String answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";

	private static void chatbot(int N, int i) {
		// ---- 붙이기
		String temp = "";
		for (int j = 0; j < i; j++)
			temp += "____";
		
		// i가 N과 같아지면 정답 출력
		if (N == i) {
			sb.append(temp).append(str1);
			sb.append(temp).append(answer);
			sb.append(temp).append(str3);
			return;
		}
		// 질문 반복
		sb.append(temp).append(str1);
		sb.append(temp).append(str2[0]);
		sb.append(temp).append(str2[1]);
		sb.append(temp).append(str2[2]);
		chatbot(N, i + 1);
		sb.append(temp).append(str3);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		chatbot(N, 0);
		System.out.print(sb.toString());
	}
}
