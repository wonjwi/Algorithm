package ssafy.workshop;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15683_감시 {
	
	static class CCTV {
		int r, c, type;

		public CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
	
	static int N, M, answer = Integer.MAX_VALUE;
	static ArrayList<CCTV> cctv = new ArrayList<CCTV>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] dir = {{}, {1}, {1, 3}, {0, 1}, {0, 1, 3}, {0, 1, 2, 3}};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 사무실의 정보 (0은 빈 칸, 6은 벽, 1~5는 CCTV)
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0)-'0';
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					cctv.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		// 사각 지대의 최소 크기 구하기
		cctvTest(map, cctv, cctv.size(), 0);
		
		System.out.println(answer);
	}

	private static void cctvTest(int[][] map, ArrayList<CCTV> cctv, int size, int cnt) {
		if (cnt == size) {
			answer = Math.min(answer, countBlindSpot(map));
			return;
		}
		CCTV tmp = cctv.get(cnt);
		int r = tmp.r, c = tmp.c;
		int type = tmp.type;
		for (int d = 0; d < 4; d++) {
			// CCTV가 감시할 수 있는 영역을 확인
			for (int i = 0; i < dir[type].length; i++) {
				int row = r, col = c;
				while (true) {
					row += dr[(dir[type][i]+d)%4];
					col += dc[(dir[type][i]+d)%4];
					if (row < 0 || row >= N || col < 0 || col >= M || map[row][col] == 6) break;
					if (map[row][col] != 0) continue;
					map[row][col] = 7+cnt;
				}
			}
			// 다음 영역 확인
			cctvTest(map, cctv, size, cnt+1);
			// 확인한 영역 되돌리기
			for (int i = 0; i < dir[type].length; i++) {
				int row = r, col = c;
				while (true) {
					row += dr[(dir[type][i]+d)%4];
					col += dc[(dir[type][i]+d)%4];
					if (row < 0 || row >= N || col < 0 || col >= M || map[row][col] == 6) break;
					if (map[row][col] != 7+cnt) continue;
					map[row][col] = 0;
				}
			}
			if (type == 5 || (type == 2 && d == 1)) break;
		}
	}

	private static int countBlindSpot(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}

}
