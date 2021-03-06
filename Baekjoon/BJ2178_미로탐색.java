package week05;

import java.io.*;
import java.util.*;

public class BJ2178_미로탐색 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 미로 입력 (1은 이동 가능, 0은 이동 불가능)	
		char[][] map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		// (1,1)에서 (N,M)까지의 최단거리 구하기 -> BFS 이용
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0, 0, 1});
		while (true) {
			// Queue에서 값을 하나 꺼냄
			int[] data = queue.poll();
			int r = data[0];
			int c = data[1];
			int distance = data[2];
			
			// 도착지에 도착했으면 이동거리 출력
			if (r == N-1 && c == M-1) {
				System.out.println(distance);
				break;
			}
			
			// 도착하지 못했으면 계속해서 탐색
			if (r < N-1 && map[r+1][c] == '1') { // 아래쪽
				queue.add(new int[] {r+1, c, distance+1});
				map[r+1][c] = '0';
			}
			if (c < M-1 && map[r][c+1] == '1') { // 오른쪽
				queue.add(new int[] {r, c+1, distance+1});
				map[r][c+1] = '0';
			}
			if (r > 0 && map[r-1][c] == '1') { // 위쪽
				queue.add(new int[] {r-1, c, distance+1});
				map[r-1][c] = '0';
			}
			if (c > 0 && map[r][c-1] == '1') { // 왼쪽
				queue.add(new int[] {r, c-1, distance+1});
				map[r][c-1] = '0';
			}
		}
	}

}
