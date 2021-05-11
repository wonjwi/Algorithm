package week15;

import java.io.*;
import java.util.*;

public class BJ15685_드래곤커브 {
	
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,-1,0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(in.readLine());
		boolean[][] map = new boolean[101][101];
		List<Integer> curve = null;
		
		// 드래곤 커브의 정보로 커브 만들기
		int x, y, d, g, size;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			// 0세대 드래곤 커브
			curve = new ArrayList<Integer>();
			map[x][y] = true;
			x += dx[d];
			y += dy[d];
			map[x][y] = true;
			curve.add((d+1)%4);
			
			// 1~g세대 드래곤 커브
			for (int j = 0; j < g; j++) {
				size = curve.size();
				for (int k = size-1; k >= 0; k--) {
					d = curve.get(k);
					x += dx[d];
					y += dy[d];
					map[x][y] = true;
					curve.add((d+1)%4);
				}
			}
		}
		// 꼭짓점이 모두 드래곤 커브의 일부인 1x1 정사각형 개수
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) count++;
			}
		}
		System.out.println(count);
	}

}
