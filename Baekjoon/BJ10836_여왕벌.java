package week11;

import java.io.*;
import java.util.StringTokenizer;

public class BJ10836_여왕벌 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int size = 2*M-1;
		int N = Integer.parseInt(st.nextToken());
		
		// 마지막 날까지의 애벌레 성장 누적합
		int[] grow = new int[size+1];
		
		// 애벌레를 N일동안 성장 시킨다.
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine(), " ");
			// 애벌레들이 자라는 정도의 개수
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			
			// 애벌레들이 자라는 정도의 시작 위치
			grow[zero]++; // 1만큼 자라기 시작하는 위치
			grow[zero+one]++; // 2만큼 자라기 시작하는 위치
		}
		// 마지막 날까지의 성장 누적합 구하기
		for (int i = 1; i < size; i++) {
			grow[i] += grow[i-1];
		}
		
		// 마지막 날 저녁의 크기
		// 첫날 아침의 크기 1 더해서 출력
		for (int i = 0; i < M; i++) {
			sb.append(grow[M-1-i] + 1).append(" ");
			for (int j = M; j < size; j++) {
				sb.append(grow[j] + 1).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}

//public class BJ10836_여왕벌 {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
//		int M = Integer.parseInt(st.nextToken());
//		int size = 2*M-1;
//		int N = Integer.parseInt(st.nextToken());
//		
//		// 첫날 아침의 애벌레 크기는 모두 1
//		int[] grow = new int[size];
//		Arrays.fill(grow, 1);
//		
//		// 애벌레를 N일동안 성장 시킨다.
//		for (int n = 0; n < N; n++) {
//			st = new StringTokenizer(in.readLine(), " ");
//			// 애벌레들이 자라는 정도의 개수
//			int zero = Integer.parseInt(st.nextToken());
//			int one = Integer.parseInt(st.nextToken());
//			
//			// 각 칸마다 애벌레들이 자라는 정도
//			one += zero;
//			for (int i = zero; i < one; i++) {
//				grow[i] += 1;
//			}
//			for (int i = one; i < size; i++) {
//				grow[i] += 2;
//			}
//		}
//		// 마지막 날 저녁의 크기 출력
//		for (int i = 0; i < M; i++) {
//			sb.append(grow[M-1-i]).append(" ");
//			for (int j = M; j < size; j++) {
//				sb.append(grow[j]).append(" ");
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb.toString());
//	}
//	
//}
