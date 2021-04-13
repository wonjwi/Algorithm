package ssafy.workshop;

import java.io.*;
import java.util.StringTokenizer;


public class SW4014_활주로건설 {
	
	static int N, X, map[][] = new int[20][20];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			// 지형 정보 입력
			N = Integer.parseInt(st.nextToken()); // 한 변의 크기
			X = Integer.parseInt(st.nextToken()); // 경사로의 길이
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0) - '0';
				}
			}
			// 활주로를 건설할 수 있는 경우의 수 구하기
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (make(i, 0, i, N-1)) cnt++;
				if (make(0, i, N-1, i)) cnt++;
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean make(int startR, int startC, int endR, int endC) {
		int height = map[startR][startC], len = 0; 
		for (int i = startR; i <= endR; i++) {
			for (int j = startC; j <= endC; j++) {
				// 이전과 높이가 같으면
				if (height == map[i][j]) {
					len++;
				}
				// 이전보다 1 높으면
				else if (height+1 == map[i][j]) {
					// 경사로를 세울 수 없으면
					if (len < X) return false;
					// 경사로를 세울 수 있으면
					len = 1;
					height++;
				}
				// 이전보다 1 낮으면
				else if (height-1 == map[i][j]) {
					// 경사로를 세울 수 있는지 판단
					int cnt = 0;
					if (startR == endR) {
						for (int k = j; k < N; k++) {
							if (map[i][k] != height-1 || ++cnt == X) {
								j = k;
								break;
							}
						}
					}
					else if (startC == endC) {
						for (int k = i; k < N; k++) {
							if (map[k][j] != height-1 || ++cnt == X) {
								i = k;
								break;
							}
						}
					}
					// 경사로를 세울 수 없으면
					if (cnt < X) return false;
					len = 0;
					height--;
				}
				// 높이가 1 이상 차이나면
				else return false;
			}
		}
		return true;
	}

}

//public class SW4014_활주로건설 {
//	
//	static int N, X, map[][] = new int[20][20], tmap[][] = new int[20][20];
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		
//		int T = Integer.parseInt(in.readLine());
//		for (int tc = 1; tc <= T; tc++) {
//			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
//			// 지형 정보 입력
//			N = Integer.parseInt(st.nextToken()); // 한 변의 크기
//			X = Integer.parseInt(st.nextToken()); // 경사로의 길이
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(in.readLine(), " ");
//				for (int j = 0; j < N; j++) {
//					tmap[j][i] = map[i][j] = st.nextToken().charAt(0) - '0';
//				}
//			}
//			// 활주로를 건설할 수 있는 경우의 수 구하기
//			sb.append("#").append(tc).append(" ").append(process()).append("\n");
//		}
//		System.out.println(sb.toString());
//	}
//
//	private static int process() {
//		int cnt = 0;
//		for (int i = 0; i < N; i++) {
//			if (makeRoad(map[i])) cnt++;
//			if (makeRoad(tmap[i])) cnt++;
//		}
//		return cnt;
//	}
//
//	private static boolean makeRoad(int[] road) {
//		int height = road[0], len = 0;
//		int j = 0; // 탐색 위치
//		while (j < N) {
//			// 이전과 높이가 같을 때
//			if (height == road[j]) {
//				++len;
//				++j;
//			}
//			// 이전보다 1 높으면 경사로 세울 수 있는지 판단
//			else if (height+1 == road[j]) { 
//				if (len < X) return false; // 경사로 설치 불가
//				height++;
//				len = 1;
//				++j;
//			}
//			// 이전보다 1 낮으면 경사로 세울 수 있는지 판단
//			else if (height-1 == road[j]) {
//				int cnt = 0;
//				for (int k = j; k < N; k++) {
//					if (road[k] != height-1) break;
//					if (++cnt == X) break;
//				}
//				if (cnt < X) return false; // 경사로 설치 불가
//				height--;
//				len = 0;
//				j += X;
//			}
//			// 높이가 1 넘게 차이나면
//			else return false;
//		}
//		return true;
//	}
//
//}
