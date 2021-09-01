package week28;

import java.io.*;
import java.util.*;

public class BJ21610_마법사상어와비바라기 {

	static int dr[] = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int dc[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dr2[] = { -1, -1, 1, 1 };
	static int dc2[] = { -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][N];
		int move[][] = new int[M][2];

		// 각 바구니에 저장되어 있는 물의 양 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 구름이 이동할 방향, 거리 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			move[i][0] = Integer.parseInt(st.nextToken());
			move[i][1] = Integer.parseInt(st.nextToken());
		}

		boolean cloud[][] = new boolean[N][N];

		// 비바라기 시전 (비구름 생성)
		cloud[N - 1][0] = cloud[N - 1][1] = cloud[N - 2][0] = cloud[N - 2][1] = true;

		// M번의 구름 이동 진행
		for (int i = 0; i < M; i++) {
			// 모든 구름이 d방향으로 s칸 이동
			cloud = moveCloud(cloud, N, move[i][0], move[i][1]);

			// 구름이 있는 칸의 바구니 물의 양 +1
			addWater(cloud, map, N);

			// 물이 증가한 칸에 물복사버그 시전
			copyWater(cloud, map, N);

			// 바구니에 물이 2 이상인 칸에 구름 생성 후 물의 양 -2
			addCloud(cloud, map, N);
		}

		// 이동이 끝난 후 바구니에 들어있는 물의 양의 합
		System.out.println(sumWater(map, N));
	}

	private static void addCloud(boolean[][] cloud, int[][] map, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 앞에서 비를 내린 구름은 없애기
				if (cloud[i][j]) {
					cloud[i][j] = false;
				} else if (map[i][j] >= 2) {
					cloud[i][j] = true;
					map[i][j] -= 2;
				}
			}
		}
	}

	private static void copyWater(boolean[][] cloud, int[][] map, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) {
					// 대각선 위치의 물이 있는 바구니 수만큼 물의 양 증가
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int r = i + dr2[d];
						int c = j + dc2[d];

						// 경계를 넘어가는 칸은 제외
						if (r < 0 || r >= N || c < 0 || c >= N) continue;

						if (map[r][c] > 0) cnt++;
					}
					map[i][j] += cnt;
				}
			}
		}
	}

	private static void addWater(boolean[][] cloud, int[][] map, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) {
					map[i][j]++;
				}
			}
		}
	}

	private static boolean[][] moveCloud(boolean[][] cloud, int N, int d, int s) {
		boolean nextCloud[][] = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) {
					// 0행과 N-1행, 0열과 N-1열은 연결 되어있음
					int r = (i + dr[d] * s + s * N) % N;
					int c = (j + dc[d] * s + s * N) % N;

					nextCloud[r][c] = true;
					cloud[i][j] = false;
				}
			}
		}

		return nextCloud;
	}

	private static int sumWater(int[][] map, int N) {
		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}

		return sum;
	}

}
