import java.io.*;
import java.util.*;

public class Main {
	
	static class Member implements Comparable<Member> {
		int age, idx;
		String name;

		public Member(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Member o) {
			if (this.age < o.age) {
				return -1;
			} else if (this.age == o.age) {
				return this.idx - o.idx;
			}
			return 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Member> pq = new PriorityQueue<Member>();
		int age;
		String name;
		
		for (int i = 0; i < N; i++) {
			// 정보 입력 받기
			st = new StringTokenizer(in.readLine());
			age = Integer.parseInt(st.nextToken());
			name = st.nextToken();
			
			// 우선순위큐에 정보 입력
			pq.add(new Member(i, age, name));
		}
		
		// 주어진 조건대로 출력
		Member tmp;
		while(!pq.isEmpty()) {
			tmp = pq.poll();
			
			sb.append(tmp.age).append(" ").append(tmp.name).append("\n");
		}

		System.out.println(sb.toString());
	}

}