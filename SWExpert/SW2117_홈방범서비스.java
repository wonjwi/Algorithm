package week07;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW2117_홈방범서비스 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// 도시정보 입력 (1은 집, 0은 빈 칸)
			char[][] map = new char[N][N];
			ArrayList<int[]> house = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
					if (map[i][j] == '1') {
						house.add(new int[] {i, j});
					}
				}
			}
			// 보안회사가 얻을 수 있는 최대 수익
			int maxProfit = house.size() * M;
			// 탐색 할 K의 범위 구하기
			int maxK = 1;
			while (true) {
				int cost = maxK*maxK + (maxK-1)*(maxK-1);
				if (cost > maxProfit) {
					maxK--; break;
				}
				maxK++;
			}
			// 손해를 보지 않으면서 가장 많은 집에 서비스를 제공하는 영역 찾기
			int[] cnt;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 각 위치에서 K마다 포함되는 집의 수 카운팅
					cnt = new int[maxK+1];
					for (int[] h : house) {
						int r = h[0];
						int c = h[1];
						int tmp = Math.abs(r-i)+Math.abs(c-j)+1;
						if (tmp <= maxK) cnt[tmp]++;
					}
					// 가능한 K가 있다면 결과값 찾기
					for (int k = 1; k <= maxK; k++) {
						int cost = k*k + (k-1)*(k-1);
						int houseCnt = 0;
						for (int l = 1; l <= k; l++) {
							houseCnt += cnt[l];
						}
						if (cost <= houseCnt*M) {
							ans = Math.max(ans, houseCnt);
						}
					}
				}
			}
			// 조건을 만족할 때 서비스를 제공 받는 집들의 수 출력
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

}
