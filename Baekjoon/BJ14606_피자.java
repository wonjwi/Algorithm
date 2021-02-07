package algostudy;

import java.io.*;
import java.util.*;

/**
 * 14606. 피자 (Small)
 * N개의 피자탑 분리로 얻을 수 있는 즐거움의 총합의 최댓값을 구하라.
 * 
 * 높이가 N인 피자탑을, 높이가 1인 피자탑들로 분리시켜야 한다.
 * 피자탑들 중 하나를 고르고 고른 피자탑을 두 개의 피자탑으로 분리한다.
 * 이때, 분리된 두 피자탑의 높이의 곱만큼 즐거움을 느낀다. 
 * 계속 피자탑들을 분리해나가다가 더이상 분리할 수 있는 피자탑이 없으면 종료
 */
public class BJ14606_피자 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 피자판의 개수
		Stack<Integer> pizza = new Stack<Integer>();
		pizza.push(N);
		int maxSum = play(pizza);
		System.out.println(maxSum);
	}
	// 피자탑 중 하나를 분리하고 즐거움의 최대값 구하기
	private static int play(Stack<Integer> pizza) {
		// 스택에서 피자탑 하나 꺼내기
		int top = pizza.pop();
		// 피자탑 분리할 때 즐거움 최댓값 구하기
		// 단, 피자탑 높이가 1이면 max = 0;
		int max = 0, maxI = -1;
		if (top != 1) {
			for (int i = 1; i <= top/2; i++) {
				int temp = i * (top-i);
				if (temp > max) {
					max = temp;
					maxI = i;
				}
			}
			// 분리한 피자탑 스택에 삽입
			pizza.push(maxI);
			pizza.push(top-maxI);
		}
		// 더이상 분리할 피자탑이 없으면 종료
		if (pizza.empty()) return 0;
		return max + play(pizza);
	}
}