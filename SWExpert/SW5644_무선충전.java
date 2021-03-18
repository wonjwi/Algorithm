package week07;

import java.io.*;
import java.util.StringTokenizer;

public class SW5644_무선충전 {
	
	static class BC {
		int x, y, C, P;
		public BC(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			C = c;
			P = p;
		}
	}
	
	static int M, A;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			// A와 B의 이동 정보 입력 (0: 이동 안 함, 1: 상, 2: 우, 3: 하, 4: 좌)
			char[][] move = new char[2][M];
			for (int k = 0; k < 2; k++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int i = 0; i < M; i++) {
					move[k][i] = st.nextToken().charAt(0);
				}
			}
			
			// BC의 정보 입력
			BC[] bc = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				bc[i] = new BC(x, y, C, P);
			}
			
			// 모든 사용자의 충전량 합의 최대값 구하기
			// A는 (1, 1)에서 출발, B는 (10, 10)에서 출발
			int[] Apos = {1, 1}, Bpos = {10, 10};
			int sum = 0;
			for (int i = 0; i <= M; i++) {
				// 현재 위치에서 최대 충전량 구하기
				int maxA = 0, maxB = 0, maxAIdx = -1, maxBIdx = -1, nextA = 0, nextB = 0;
				for (int j = 0; j < A; j++) {
					// BC의 충전 범위 안이면 접속할 수 있음
					if (bc[j].C >= ( Math.abs(Apos[0]-bc[j].x) + Math.abs(Apos[1]-bc[j].y) )) {
						// 접속할 수 있는 것 여러 개면 가장 큰 것
						if (maxA < bc[j].P) {
							if (maxA > 0) nextA = maxA;
							maxA = bc[j].P;
							maxAIdx = j;
						}
						else {
							nextA = Math.max(nextA, bc[j].P);
						}
					}
				}
				for (int j = 0; j < A; j++) {
					// BC의 충전 범위 안이면 접속할 수 있음
					if (bc[j].C >= ( Math.abs(Bpos[0]-bc[j].x) + Math.abs(Bpos[1]-bc[j].y) )) {
						// A가 접속하지 않는 것 중 가장 큰 것
						if (maxB < bc[j].P) {
							if (maxB > 0) nextB = maxB;
							maxB = bc[j].P;
							maxBIdx = j;
						}
						else {
							nextB = Math.max(nextB, bc[j].P);
						}
					}
				}
				// 둘이 같은 BC를 공유할 때 처리
				if (maxAIdx == maxBIdx) {
					// A에게 차선책이 있을 때
					if (nextA > 0) {
						// B에게 차선책이 있고 더 클 때
						if (nextA < nextB) maxB = nextB;
						else maxA = nextA;
					}
					// A에게 차선책이 없을 때
					else {
						// B에게 차선책이 있을 때
						if (nextB > 0) maxB = nextB;
						else maxA = 0;
					}
				}
				sum += (maxA + maxB);
				
				if (i == M) break;
				
				// 다음 방향으로 이동
				switch (move[0][i]) {
				case '1':
					Apos[1]--;
					break;
				case '2':
					Apos[0]++;
					break;
				case '3':
					Apos[1]++;
					break;
				case '4':
					Apos[0]--;
					break;
				}
				switch (move[1][i]) {
				case '1':
					Bpos[1]--;
					break;
				case '2':
					Bpos[0]++;
					break;
				case '3':
					Bpos[1]++;
					break;
				case '4':
					Bpos[0]--;
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}

}
