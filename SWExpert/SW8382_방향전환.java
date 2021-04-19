package ssafy.workshop;

import java.io.*;
import java.util.*;

public class SW8382_방향전환 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 가로 이동과 세로 이동을 번갈아가면 할 때
			// (x1, y1) -> (x2, y2) 이동하는데 필요한 횟수
			int a = Math.abs(x1-x2);
			int b = Math.abs(y1-y2);
			int ans = (Math.max(a, b))*2;
			ans += Math.abs(a-b)%2 == 0 ? 0 : -1;
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

}
