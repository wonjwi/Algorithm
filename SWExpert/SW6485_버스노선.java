package week04;

import java.io.*;
import java.util.StringTokenizer;

public class SW6485_버스노선 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			// 번호가 min 이상 max 이하인 모든 정류장을 다님
			int N = Integer.parseInt(in.readLine());
			int[] min = new int[N];
			int[] max = new int[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				min[i] = Integer.parseInt(st.nextToken());
				max[i] = Integer.parseInt(st.nextToken());
			}
			// 각 정류장에 다니는 버스 노선의 수
			int P = Integer.parseInt(in.readLine());
			int[] bus = new int[P];
			for (int j = 0; j < P; j++) {
				int temp = Integer.parseInt(in.readLine());
				for (int i = 0; i < N; i++) {
					if (temp >= min[i] && temp <= max[i]) bus[j]++;
				}
				sb.append(bus[j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
