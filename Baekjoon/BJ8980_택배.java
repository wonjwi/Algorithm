package week13;

import java.io.*;
import java.util.*;

public class BJ8980_택배 {
	
	static class Delivery implements Comparable<Delivery> {
		int from, to, cnt;
		public Delivery(int from, int to, int cnt) {
			this.from = from;
			this.to = to;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Delivery o) {
			if (this.to == o.to) return this.from-o.from;
			else return this.to-o.to;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(in.readLine());
		
		// 보내는 박스 정보 입력 후 정렬
		Delivery info[] = new Delivery[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			info[i] = new Delivery(from, to, cnt);
		}
		Arrays.sort(info);
		
		// 1번 마을부터 마지막 마을까지 가면서 배송
		int box[] = new int[N+1];
		int max, possible, total = 0;
		for (int i = 0; i < M; i++) {
			int from = info[i].from;
			int to = info[i].to;
			int cnt = info[i].cnt;
			max = 0;
			// 지나가는 구간에 이미 실린 박스의 최댓값
			for (int j = from; j < to; j++) {
				max = Math.max(max, box[j]);
			}
			// 실을 수 있는 박스 수
			possible = Math.min(C-max, cnt);
			total += possible;
			for (int j = from; j < to; j++) {
				box[j] += possible;
			}
		}
		// 배송할 수 있는 최대 박스 수
		System.out.println(total+box[N]);
	}

}
/*
public class BJ8980_택배 {
	
	static class Box implements Comparable<Box> {
		int to, cnt;
		public Box(int to, int cnt) {
			this.to = to;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Box o) {
			return this.to-o.to;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(in.readLine());
		
		// 보내는 박스 정보 입력 후 정렬
		List<Box> list[] = new ArrayList[N];
		for (int i = 1; i < N; i++) {
			list[i] = new ArrayList<Box>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			list[from].add(new Box(to, cnt));
		}
		for (int i = 1; i < N; i++) {
			Collections.sort(list[i]);
		}
		// 1번 마을부터 마지막 마을까지 가면서 배송
		int delivery[] = new int[N+1];
		int truck = 0, total = 0;
		for (int i = 1; i < N; i++) {
			// i 마을에 택배 배송
			truck -= delivery[i];
			total += delivery[i];
			for (Box b : list[i]) {
				int to = b.to;
				int cnt = b.cnt;
				// 트럭 용량만큼만 실을 수 있음
				if (truck+cnt > C) {
					// 배송지가 더/ 먼 곳의 박스 빼기
					int tmp = C-truck;
					for (int j = N; j > to; j--) {
						if (delivery[j] > 0) {
							tmp += delivery[j];
							delivery[j] = 0;
							if (tmp >= cnt) {
								delivery[j] = tmp-cnt;
								tmp = cnt;
								break;
							}
						}
					}
					truck -= tmp - (C-truck);
					// 박스들 중 일부만 배송
					if (truck+cnt > C) {
						delivery[to] += (C-truck);
						truck = C;
						break;
					}
				}
				truck += cnt;
				delivery[to] += cnt;
			}
		}
		// 배송할 수 있는 최대 박스 수
		System.out.println(total+delivery[N]);
	}

}
*/