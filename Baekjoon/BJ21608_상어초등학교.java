package week21;

import java.io.*;
import java.util.*;

public class BJ21608_상어초등학교 {

	static class Seat implements Comparable<Seat> {
		int r, c, likeCnt, emptyCnt;

		public Seat(int r, int c, int likeCnt, int emptyCnt) {
			this.r = r;
			this.c = c;
			this.likeCnt = likeCnt;
			this.emptyCnt = emptyCnt;
		}

		@Override
		public int compareTo(Seat o) {
			if (this.likeCnt == o.likeCnt) {
				if (this.emptyCnt == o.emptyCnt) {
					if (this.r == o.r) {
						return this.c - o.c;
					} else {
						return this.r - o.r;
					}
				} else {
					return o.emptyCnt - this.emptyCnt;
				}
			} else {
				return o.likeCnt - this.likeCnt;
			}
		}
	}

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		int like[][] = new int[N * N + 1][4]; // 좋아하는 학생 번호
		int map[][] = new int[N][N]; // 학생들의 자리 배치 상황
		int num, r, c, likeCnt, emptyCnt;
		PriorityQueue<Seat> pq = new PriorityQueue<Seat>();

		for (int n = 1; n <= N * N; n++) {
			st = new StringTokenizer(in.readLine(), " ");

			num = Integer.parseInt(st.nextToken());

			// 좋아하는 학생 4명의 번호 저장
			for (int i = 0; i < 4; i++) {
				like[num][i] = Integer.parseInt(st.nextToken());
			}

			pq.clear(); // 초기화

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 자리가 이미 배치된 곳은 탐색 안 함
					if (map[i][j] > 0) continue;

					// 주변 자리 배치 상황 탐색
					emptyCnt = likeCnt = 0;

					for (int d = 0; d < 4; d++) {
						r = i + dr[d];
						c = j + dc[d];
						
						if (r < 0 || r >= N || c < 0 || c >= N) continue;
						
						// 인접한 칸이 비어있는지 확인
						if (map[r][c] == 0) {
							emptyCnt++;
						} 
						// 비어있지 않으면 좋아하는 학생 있는지 확인
						else {
							for (int k = 0; k < 4; k++) {
								if (map[r][c] == like[num][k]) {
									likeCnt++;
									break;
								}
							}
						}
					}

					pq.add(new Seat(i, j, likeCnt, emptyCnt));
				}
			}
			
			// 가장 우선 순위가 높은 위치에 자리 배치
			Seat tmp = pq.poll();
			map[tmp.r][tmp.c] = num;
		}
		
		int answer = 0;
		
		// 자리 배치가 끝나면 학생의 만족도 계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 주변 자리 배치 상황 탐색
				num = map[i][j];
				likeCnt = 0;
				
				for (int d = 0; d < 4; d++) {
					r = i + dr[d];
					c = j + dc[d];
					
					if (r < 0 || r >= N || c < 0 || c >= N) continue;
					
					for (int k = 0; k < 4; k++) {
						if (map[r][c] == like[num][k]) {
							likeCnt++;
							break;
						}
					}
				}
				answer += Math.pow(10, likeCnt - 1);
			}
		}
		System.out.println(answer);
	}

}
