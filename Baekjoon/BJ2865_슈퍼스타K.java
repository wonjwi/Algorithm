package week10;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2865_슈퍼스타K {
	
	static class Stat implements Comparable<Stat> {
		int i; // 참가자 번호
		double s; // 장르별 능력
		public Stat(int i, double s) {
			this.i = i;
			this.s = s;
		}
		@Override
		public int compareTo(Stat o) {
			if (this.s < o.s) return 1;
			else return -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 참가자 수
		int M = Integer.parseInt(st.nextToken()); // 장르의 수
		int K = Integer.parseInt(st.nextToken()); // 본선 진출 명수
		
		PriorityQueue<Stat> pq = new PriorityQueue<Stat>();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int i = Integer.parseInt(st.nextToken());
				double s = Double.parseDouble(st.nextToken());
				pq.add(new Stat(i, s));
			}
		}
		
		// 본선에 총 K명 진출
		boolean[] isSelected = new boolean[N+1];
		double result = 0;
		for (int i = 0; i < K; i++) {
			Stat tmp = pq.poll();
			// 한 사람이 여러 장르를 부를 수 없음
			if (isSelected[tmp.i]) {
				i--; continue;
			}
			isSelected[tmp.i] = true;
			result += tmp.s;
		}
		
		// 본선 참가자의 능력의 합 소수점 첫째자리까지 출력
		System.out.println(Math.round(result*10)/10.0);
	}
	
}
