package week12;

import java.util.PriorityQueue;

public class PG_카카오_경주로건설 {
	
	private static int N;
    private static int[] dr = {0, 1, 0, -1};
    private static int[] dc = {1, 0, -1, 0};
	
    private static class Car implements Comparable<Car> {
        int r, c, dir, sum;
        
        public Car(int r, int c, int dir, int sum) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.sum = sum;
		}
        @Override
        // 최소 비용부터 탐색
		public int compareTo(Car o) {
			return this.sum-o.sum;
		}
    }
	
	public static void main(String[] args) {
//		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
//		int[][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		int[][] board = {
				{0, 0, 1, 0, 1, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 1, 1, 0, 1},
				{1, 0, 0, 0, 0, 1, 1, 0, 1, 0},
				{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 1, 0, 1, 1},
				{0, 0, 1, 0, 1, 1, 0, 1, 0, 1},
				{0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
				{1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0, 1, 0}
				};
		System.out.println(solution(board));
	}

	static public int solution(int[][] board) {
		N = board.length;
        // 경주로 건설
        return build(0, 0, board);
    }
	
	private static int build(int i, int j, int[][] board) {
		int answer = 0;
		
		// 네 방향으로 방문체크
		int[][][] minSum = new int[N][N][4];
		
		// 출발점에서 출발
		minSum[i][j][3] = minSum[i][j][2] = minSum[i][j][1] = minSum[i][j][0] = -1;
		PriorityQueue<Car> queue = new PriorityQueue<Car>();
		if (board[i][j+1] == 0) {
			queue.add(new Car(i, j+1, 0, 100)); // 오른쪽
			minSum[i][j+1][0] = 100;
		}
		if (board[i+1][j] == 0) {
			queue.add(new Car(i+1, j, 1, 100)); // 아래
			minSum[i+1][j][1] = 100;
		}
		
		while (!queue.isEmpty()) {
			Car tmp = queue.poll();
			int r = tmp.r;
			int c = tmp.c;
			int dir = tmp.dir;
			int sum = tmp.sum;
			
			// 도착점에 도착하면 종료
			if (r == N-1 && c == N-1) {
				answer = sum;
				break;
			}
			// 도착하지 않았으면 계속 진행
			for (int d=0; d<4; d++) {
				int row = r+dr[d];
				int col = c+dc[d];
				int s = sum + (d == dir ? 100 : 600); // 코너 필요한지 체크
				if (row<0 || row>=N || col<0 || col>=N || board[row][col] == 1 ||
						// 현재 지점에 대한 비용이 더 작을 때만 계속 진행
						(minSum[row][col][d] != 0 && minSum[row][col][d] <= s)) continue;
				queue.add(new Car(row, col, d, s));
				minSum[row][col][d] = s;
			}
		}
		return answer;
	}

}
