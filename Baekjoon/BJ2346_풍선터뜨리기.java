package algostudy;

import java.io.*;
import java.util.*;

//2346. 풍선 터뜨리기
//N개의 풍선 안에 -N부터 N까지의 수가 적혀있는 종이가 들어 있다.
//풍선들을 규칙에 맞게 터뜨릴 때 터진 풍선의 번호를 차례로 나열하라.
public class BJ2346_풍선터뜨리기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		Queue<int[]> balloon = new LinkedList<int[]>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			int[] temp = {i, Integer.parseInt(st.nextToken())};
			balloon.offer(temp);
		}
		while (true) {
			// 가장 앞에 있는 풍선을 터뜨린다.
			int[] temp = balloon.poll();
			sb.append(temp[0]).append(" "); // 번호 출력
			// 풍선이 다 터졌으면 종료한다.
			if (balloon.isEmpty()) break;
			int move = 0;
			if (temp[1] < 0)
				move = balloon.size()+1 - (Math.abs(temp[1]) % balloon.size());
			else 
				move = temp[1];
			// 이동 횟수-1만큼 앞에서 빼서 뒤로 넣는다.
			for (int j = 0; j < move-1; j++) {
				balloon.offer(balloon.poll());
			}
		}
		System.out.println(sb);
	}
}