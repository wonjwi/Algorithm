package week14;

import java.io.*;
import java.util.*;

public class BJ1931_회의실배정 {
	
	static class Meeting implements Comparable<Meeting> {
		int start, end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meeting o) {
			// 끝나는 시간이 같다면 시작 시간이 빠른 회의부터
			if (this.end == o.end) return this.start-o.start;
			// 끝나는 시간이 빠른 회의부터
			else return this.end-o.end;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		
		// 각 회의의 시작 및 끝나는 시간 입력
		PriorityQueue<Meeting> queue = new PriorityQueue<Meeting>();
		int start, end;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			queue.add(new Meeting(start, end));
		}
		// 회의실을 사용할 수 있는 회의의 최대 개수
		int prev = 0, count = 0;
		for (int i = 0; i < N; i++) {
			Meeting tmp = queue.poll();
			// 회의실을 사용할 수 있다면
			if (prev <= tmp.start) {
				count++;
				prev = tmp.end;
			}
		}
		System.out.println(count);
	}

}
