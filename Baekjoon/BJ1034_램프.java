package week22;

import java.io.*;
import java.util.*;

public class BJ1034_램프 {
	
	static int N, M, K;
	static boolean map[][], visit[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		visit = new boolean[N];
		String str = null;
		
		// N x M 램프의 상태 입력
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) == '1';
			}
		}
		
		// 스위치를 누를 횟수
		K = Integer.parseInt(in.readLine());
		
		// 스위치를 K번 누른 후 켜져있는 행의 최댓값 찾기
		int answer = 0;
		for (int i = 0; i < N; i++) {
			// 이미 확인한 행은 지나치기
			if (visit[i]) continue;
			visit[i] = true;
			
			// 점수가 될 수 있는 행이라면
			if (possible(i)) {
				// 상태가 일치하는 행의 개수를 계산
				answer = Math.max(answer, same(i));
			}
		}
		System.out.println(answer);
	}

	// 스위치를 K번 눌러서 켜진 상태가 되는 행 찾기
	private static boolean possible(int row) {
		int zeroCnt = 0;
		for (int j = 0; j < M; j++) {
			if (!map[row][j]) {
				zeroCnt++;
			}
		}
		// 꺼진 램프가 K개 이하이면서 짝/홀수 여부가 같으면
		if (zeroCnt <= K && zeroCnt % 2 == K % 2) {
			return true;
		}
		return false;
	}

	private static int same(int row) {
		int cnt = 1; // 비교할 행 포함
		
		boolean flag;
		for (int i = row+1; i < N; i++) {
			flag = true;
			for (int j = 0; j < M; j++) {
				if (map[row][j] != map[i][j]) {
					flag = false;
					break;
				}
			}
			// 상태가 일치할 경우
			if (flag) {
				visit[i] = true;
				cnt++;
			}
		}
		return cnt;
	}
	
}
