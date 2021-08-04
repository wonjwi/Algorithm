package week25;

import java.io.*;
import java.util.*;

public class BJ3190_뱀 {

	static int N, direction[][], dir, idx, hr, hc;
	static Deque<int[]> snake;
	static boolean isApple[][], isSnake[][], eatApple;
	static int dr[] = { -1, 0, 1, 0 }; // 시계방향
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine()), r, c;
		isApple = new boolean[N][N];
		isSnake = new boolean[N][N];

		// 사과의 위치를 지도에 표시
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			isApple[r][c] = true;
		}

		int L = Integer.parseInt(in.readLine());
		int direction[][] = new int[L][2];

		// 뱀의 방향 전환 정보 입력
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			direction[i][0] = Integer.parseInt(st.nextToken());
			direction[i][1] = st.nextToken().charAt(0);
		}

		int next = direction[0][0], time = 1, tmp[];
		dir = 1; // 처음에 오른쪽을 향한 상태로 시작

		snake = new ArrayDeque<int[]>();
		snake.add(new int[] { 0, 0 });

		// 게임이 끝날 때까지 뱀을 이동
		while (true) {
			eatApple = false;

			// 머리를 다음칸으로 이동하기
			if (!moveHead()) {
				break;
			}
			// 사과를 먹지 않았으면 꼬리칸 비우기
			if (!eatApple) {
				tmp = snake.pollLast();
				isSnake[tmp[0]][tmp[1]] = false;
			}
			// 방향 바꿀 시간이 되면 방향 변환
			if (time++ == next) {
				char ch = (char) direction[idx][1];
				// 문자에 따라 방향 변환
				if (ch == 'L') {
					dir = (dir + 3) % 4;
				} else {
					dir = (dir + 1) % 4;
				}
				if (idx >= L - 1) {
					continue;
				}
				next = direction[++idx][0];
			}
		}
		// 게임이 종료된 시간 출력
		System.out.println(time);
	}

	private static boolean moveHead() {
		// 뱀의 머리 이동
		hr += dr[dir];
		hc += dc[dir];

		// 벽이나 자기 몸에 부딪힌 경우 게임 종료
		if (hr < 0 || hr >= N || hc < 0 || hc >= N || isSnake[hr][hc]) {
			return false;
		}

		// 뱀의 머리가 이동한 곳 저장
		snake.addFirst(new int[] { hr, hc });
		isSnake[hr][hc] = true;

		// 이동한 곳에 사과가 있는 경우
		if (isApple[hr][hc]) {
			eatApple = true;
			isApple[hr][hc] = false;
		}

		return true;
	}

}
