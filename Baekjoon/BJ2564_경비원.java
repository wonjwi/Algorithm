package algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2564_경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(in.readLine()); // 상점의 개수
		int[][] store = new int[N][2]; // 위치한 방향, 경계로부터 거리
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			store[i][0] = Integer.parseInt(st.nextToken());
			store[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine()); // 동근이의 위치
		int dir = Integer.parseInt(st.nextToken());
		int loc = Integer.parseInt(st.nextToken());
		// 동근이의 각 상점 사이의 최단 거리 구하기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int storeDir = store[i][0];
			int storeLoc = store[i][1];
			// 위치한 방향이 같을 때
			if (dir == storeDir) {
				sum += Math.abs(loc-storeLoc);
			}
			// 동근이가 북쪽이나 남쪽
			else if (dir<=2) {
				// 상점이 북쪽이나 남쪽
				if (storeDir<=2) {
					int left = loc+storeLoc+R;
					int right = 2*C-loc-storeLoc+R;
					sum += Math.min(left, right);
				}
				// 상점이 서쪽
				else if (storeDir == 3) {
					if (dir == 1) { // 북서
						sum += loc+storeLoc;
					}
					else { // 남서
						sum += loc+R-storeLoc;
					}
				}
				// 상점이 동쪽
				else if (storeDir == 4) {
					if (dir == 1) { // 북동
						sum += C-loc+storeLoc;
					}
					else { // 남동
						sum += C-loc+R-storeLoc;
					}
				}
			}
			// 동근이가 동쪽이나 서쪽
			else if (dir>2) {
				// 상점이 동쪽이나 서쪽
				if (storeDir>2) {
					int top = loc+storeLoc+C;
					int down = 2*R-loc-storeLoc+C;
					sum += Math.min(top, down);
				}
				// 상점이 북쪽
				else if (storeDir == 1) {
					if (dir == 3) { // 서북
						sum += loc+storeLoc;
					}
					else { // 동북
						sum += loc+C-storeLoc;
					}
				}
				// 상점이 남쪽
				else if (storeDir == 2) {
					if (dir == 3) { // 서남
						sum += R-loc+storeLoc;
					}
					else { // 동남
						sum += R-loc+C-storeLoc;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
