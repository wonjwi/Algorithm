package week05;

import java.io.*;
import java.util.*;

public class BJ14502_연구소 {
	
	static int N, M, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 연구소의 지도 입력 (0은 빈 칸, 1은 벽, 2는 바이러스)
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		// 벽 3개를 세우고 안전 영역의 크기 구하기
		build(map);
		System.out.println(max);
	}
	
	private static void build(char[][] map) {
		int total = N*M;
		// 첫 번째 벽 세우기
		for (int first = 0; first < total-2; first++) {
			if (map[first/M][first%M] != '0') continue;
			map[first/M][first%M] = '1';
			// 두 번째 벽 세우기
			for (int second = 0; second < total-1; second++) {
				if (map[second/M][second%M] != '0') continue;
				map[second/M][second%M] = '1';
				// 세 번째 벽 세우기
				for (int third = 0; third < total; third++) {
					if (map[third/M][third%M] != '0') continue;
					map[third/M][third%M] = '1';
					// 바이러스를 퍼뜨린 뒤 안전 영역의 크기 구하기
					max = Math.max(max, count(map));
					// 세웠던 벽 치우기
					map[third/M][third%M] = '0';
				}
				map[second/M][second%M] = '0';
			}
			map[first/M][first%M] = '0';
		}
	}

	private static int count(char[][] map) {
		// 바이러스 퍼뜨리기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '2') {
					spread(map, i, j);
				}
			}
		}
		// 안전 영역 크기 구하고 지도 되돌리기
		int safeAreaCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') safeAreaCnt++;
				else if (map[i][j] == '3') {
					map[i][j] = '0';
				}
			}
		}
		return safeAreaCnt;
	}

	private static void spread(char[][] map, int r, int c) {
		// 인접한 곳에 바이러스 퍼뜨리기
		if (r > 0 && map[r-1][c] == '0') { // 상
			map[r-1][c] = '3';
			spread(map, r-1, c);
		}
		if (r < N-1 && map[r+1][c] == '0') { // 하
			map[r+1][c] = '3';
			spread(map, r+1, c);
		}
		if (c > 0 && map[r][c-1] == '0') { // 좌
			map[r][c-1] = '3';
			spread(map, r, c-1);
		}
		if (c < M-1 && map[r][c+1] == '0') { // 우
			map[r][c+1] = '3';
			spread(map, r, c+1);
		}
	}

}
//public class BJ14502_연구소 {
//	
//	static int N, M, minSpread = Integer.MAX_VALUE;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(in.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		// 연구소의 지도 입력 (0은 빈 칸, 1은 벽, 2는 바이러스)
//		char[][] map = new char[N][M];
//		int[][] virus = new int[10][];
//		int size = 0, zeroCnt = 0;
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(in.readLine());
//			for (int j = 0; j < M; j++) {
//				map[i][j] = st.nextToken().charAt(0);
//				if (map[i][j] == '0') zeroCnt++;
//				else if (map[i][j] == '2') {
//					virus[size++] = (new int[] {i, j});
//				}
//			}
//		}
//		
//		// 벽 3개를 세우고 안전 영역의 크기 구하기
//		pick(map, virus, size, new int[3][2], 0);
//		System.out.println(zeroCnt-3-minSpread);
//	}
//	
//	private static void pick(char[][] map, int[][] virus, int size, int[][] place, int cnt) {
//		// 후보지 3개가 선택 됨
//		if (cnt == 3) {
//			// 새로운 지도 만들기
//			char[][] newMap = new char[N][M];
//			for (int i = 0; i < N; i++) {
//				System.arraycopy(map[i], 0, newMap[i], 0, M);
//			}
//			// 선택된 위치에 벽 세우기
//			for (int i = 0; i < 3; i++) {
//				int r = place[i][0];
//				int c = place[i][1];
//				newMap[r][c] = '1';
//			}
//			// 바이러스가 퍼진 뒤 안전 영역의 크기 구하기
//			Queue<int[]> queue = new LinkedList<int[]>();
//			for (int i = 0; i < size; i++) {
//				queue.add(new int[] {virus[i][0], virus[i][1]});
//			}
//			minSpread = Math.min(minSpread, spread(newMap, queue));
//			return;
//		}
//		
//		// 벽을 세울 곳 선택하기
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				// 빈 칸이 아니거나 이미 선택된 곳은 지나치기
//				if (map[i][j] != '0') continue;
//				for (int k = 0; k < cnt; k++) {
//					if (place[k][0] == i && place[k][1] == j) continue;
//				}
//				place[cnt][0] = i;
//				place[cnt][1] = j;
//				pick(map, virus, size, place, cnt+1);
//			}
//		}
//	}
//
//	private static int spread(char[][] newMap, Queue<int[]> queue) {
//		int spreadCnt = 0;
//		while (!queue.isEmpty()) {
//			// Queue에서 값을 하나 꺼냄
//			int[] data = queue.poll();
//			int r = data[0];
//			int c = data[1];
//			
//			// 퍼뜨릴 곳이 있으면 계속 퍼뜨리기
//			if (r < N-1 && newMap[r+1][c] == '0') { // 아래쪽
//				queue.add(new int[] {r+1, c});
//				newMap[r+1][c] = '2'; spreadCnt++;
//			}
//			if (c < M-1 && newMap[r][c+1] == '0') { // 오른쪽
//				queue.add(new int[] {r, c+1});
//				newMap[r][c+1] = '2'; spreadCnt++;
//			}
//			if (r > 0 && newMap[r-1][c] == '0') { // 위쪽
//				queue.add(new int[] {r-1, c});
//				newMap[r-1][c] = '2'; spreadCnt++;
//			}
//			if (c > 0 && newMap[r][c-1] == '0') { // 왼쪽
//				queue.add(new int[] {r, c-1});
//				newMap[r][c-1] = '2'; spreadCnt++;
//			}
//			if (spreadCnt >= minSpread) break;
//		}
//		return spreadCnt;
//	}
//
//}
