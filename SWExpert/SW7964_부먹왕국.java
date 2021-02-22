package week04;

import java.io.*;
import java.util.StringTokenizer;

public class SW7964_부먹왕국 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken()); // 도시 수
			int D = Integer.parseInt(st.nextToken()); // 이동 제한 거리
			// 1은 차원 관문이 남아있음, 0은 파괴 당한 것
			st = new StringTokenizer(in.readLine());
			char[] city = new char[N+2];
			// 0번 위치와 N+1번 위치에는 차원 관문이 존재
			city[0] = '1'; city[N+1] = '1';
			for (int i = 1; i <= N; i++) {
				city[i] = st.nextToken().charAt(0);
			}
			// 추가로 건설 해야 하는 차원관문의 최소 개수
			int cnt = 0;
			// 모든 차원 관문이 직접적으로 이동 가능하고 모든 도시 이동이 되어야 함
			int idx = 0;
			for (int i = 1; i <= N; i++) {
				if (city[i] == '1') idx = i;
				else if (i == idx+D) {
					city[i] = '1';
					cnt++;
					idx = i;
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}
