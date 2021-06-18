package week18;

import java.io.*;
import java.util.*;

public class BJ16987_계란으로계란치기 {

	static int N, egg[][], max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 계란들의 내구도와 무게 입력
		N = Integer.parseInt(in.readLine());
		egg = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			egg[i][0] = Integer.parseInt(st.nextToken()); // 내구도
			egg[i][1] = Integer.parseInt(st.nextToken()); // 무게
		}

		// 가장 왼쪽의 계란을 들어서 계란치기
		fight(0, 0);
		System.out.println(max);
	}

	private static void fight(int curr, int cnt) {
		// 깰 수 있는 계란의 최대 개수 갱신
		max = Math.max(max, cnt);
		
		// 가장 오른쪽 계란을 든 뒤면 계란치기 종료
		if (curr == N) return;
		
		// 손에 든 계란으로 깨지지 않은 계란치기
		for (int i = 0; i < N; i++) {
			if (curr == i || egg[i][0] <= 0) continue;
			egg[i][0] -= egg[curr][1];
			egg[curr][0] -= egg[i][1];
			
			// 깨진 계란 갯수 구하기
			int breakCnt = 0;
			breakCnt += egg[i][0] <= 0 ? 1 : 0;
			breakCnt += egg[curr][0] <= 0 ? 1 : 0;
			
			// 다음으로 들 계란 찾기
			int next = curr + 1;
			while (next < N) {
				if (egg[next][0] > 0) break;
				next++;
			}
			fight(next, cnt + breakCnt);
			
			egg[i][0] += egg[curr][1];
			egg[curr][0] += egg[i][1];
		}
	}

}
