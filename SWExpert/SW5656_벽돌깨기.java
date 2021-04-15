package ssafy.homework;

import java.io.*;
import java.util.*;

public class SW5656_벽돌깨기 {
	
	static int N, W, H, ans;
	static int[][] input = new int[15][12];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 구슬 발사 횟수
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			// 초기 상태 입력
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < W; j++) {
					input[i][j] = st.nextToken().charAt(0)-'0';
				}
			}
			ans = Integer.MAX_VALUE;
			select(input, 0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static boolean select(int[][] map, int cnt) {
		int count = getCount(map);
		// 쏠 벽돌이 없으면 종료
		if (count == 0) {
			ans = 0;
			return true;
		}
		// 구슬을 N번 다 쐈으면 종료
		if (cnt == N) {
			ans = Math.min(ans, count);
			return false;
		}
		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) {
			// 원본 배열 복사해서 사용
			setBegin(map, newMap);
			// 해당 열의 최상단 찾기
			int top = 0;
			while (top < H && newMap[top][c] == 0) ++top;
			// 벽돌이 하나도 없으면 들어갈 필요 없음
			if (top == H) continue;
			// 선택한 벽돌 깨기
			shoot(newMap, top, c); 
			// 빈 공간 정리
			down(newMap); 
			// 다음 쏠 곳 선택
			if (select(newMap, cnt+1)) return true; 
		}
		return false;
	}

	private static void setBegin(int[][] map, int[][] newMap) {
		for (int r = 0; r < H; r++) {
			System.arraycopy(map[r], 0, newMap[r], 0, W);
		}
	}

	private static int getCount(int[][] map) {
		int cnt = 0;
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				if (map[r][c] != 0) cnt++;
			}
		}
		return cnt;
	}
	
	private static void down(int[][] map) {
		for (int c = 0; c < W; c++) {
			int zero = -1;
			for (int r = H-1; r >= 0; r--) {
				if (map[r][c] == 0) {
					zero = r;
					for (int row = r-1; row >= 0; row--) {
						if (map[row][c] != 0) {
							map[zero][c] = map[row][c];
							map[row][c] = 0;
							break;
						}
					}
				}
			}
		}
	}
	
//	private static List<Integer> list = new ArrayList<Integer>();
//	private static void down(int[][] map) {
//		for (int c = 0; c < W; c++) {
//			// 벽돌을 리스트에 넣기
//			for (int r = H-1; r >= 0; r--) {
//				if (map[r][c] > 0) { // 벽돌이면
//					list.add(map[r][c]);
//					map[r][c] = 0;
//				}
//			}
//			// 리스트에 담긴 벽돌 꺼내서 아래부터 채우기
//			int r = H-1;
//			for (int b : list) {
//				map[r--][c] = b;
//			}
//			list.clear();
//		}
//	}

	private static void shoot(int[][] map, int targetR, int targetC) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {targetR, targetC});
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			
			int size = map[r][c];
			if (size == 0) continue;
			map[r][c] = 0;
			
			// 상하좌우로 size만큼 연쇄 반응
			for (int i = 1; i < size; i++) {
				for (int j = 0; j < 4; j++) {
					int row = r + dr[j]*i;
					int col = c + dc[j]*i;
					if (row < 0 || row >= H || col < 0 || col >= W) continue;
					if (map[row][col] > 1) queue.add(new int[] {row, col});
					else map[row][col] = 0;
				}
			}
		}
	}
	
}
