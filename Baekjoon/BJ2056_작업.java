package week18;

import java.io.*;
import java.util.*;

public class BJ2056_작업 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		int time[] = new int[N + 1];
		int preCnt, maxTime, num;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			// 해당 작업에 걸리는 시간
			time[i] = Integer.parseInt(st.nextToken());
			
			// 선행 관계에 있는 작업들의 개수와 번호
			preCnt = Integer.parseInt(st.nextToken());
			maxTime = 0;
			for (int j = 0; j < preCnt; j++) {
				num = Integer.parseInt(st.nextToken());
				maxTime = Math.max(maxTime, time[num]);
			}
			// 선행 작업들에 걸리는 시간 더하기
			time[i] += maxTime;
		}
		Arrays.sort(time);
		System.out.println(time[N]);
	}

}
