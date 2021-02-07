package algostudy;

import java.io.*;
import java.util.*;

/** 11866. 요세푸스 문제 0
 * N명의 사람(1~N번)이 원을 이루면서 앉아있고, K번째 사람을 제거하는 것을 반복한다.
 * 이때 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
 * 양의 정수 N과 K(≤ N) 가 주어지면 (N, K)-요세푸스 순열을 구하라.
 */
public class BJ11866_요세푸스0 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> person = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			person.add(i);
		}
		StringBuilder josephus = new StringBuilder();
		josephus.append("<");
		int start = 0;
		for (int i = 0; i < N-1; i++) {
			// 앞에 삭제된 다음부터 K번째 사람 제거
			start = (start+(K-1)) % (N-i);
			josephus.append(person.remove(start)).append(", ");
		}
		josephus.append(person.get(0)).append(">");
		System.out.println(josephus);
	}
}

//=================================================================================
//public class BJ11866_요세푸스0 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(in.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		
//		List<Integer> person = new LinkedList<Integer>();
//		for (int i = 1; i <= N; i++) {
//			person.add(i);
//		}
//		StringBuilder josephus = new StringBuilder();
//		josephus.append("<");
//		for (int i = 0; i < N-1; i++) {
//			// 1부터 K-1번째 사람들 뒤로 옮기기
//			for (int j = 0; j < K-1; j++)
//				person.add(person.remove(0));
//			// 앞에 남은 K번째 사람을 제거
//			josephus.append(person.remove(0)).append(", ");
//		}
//		josephus.append(person.get(0)).append(">");
//		System.out.println(josephus);
//	}
//}