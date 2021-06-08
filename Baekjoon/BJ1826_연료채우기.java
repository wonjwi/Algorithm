package week17;

import java.io.*;
import java.util.*;

public class BJ1826_연료채우기 {

	static class OilStation {
		int distance, oil;

		public OilStation(int distance, int oil) {
			this.distance = distance;
			this.oil = oil;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N, distance, oil, L, P, cnt = 0;
		N = Integer.parseInt(in.readLine());
		
		// 갖고 있는 연료로 들를 수 있는 주유소
		PriorityQueue<OilStation> curr = new PriorityQueue<OilStation>(new Comparator<OilStation>() {
			@Override
			public int compare(OilStation o1, OilStation o2) {
				if (o1.oil == o2.oil)
					return o1.distance - o2.distance;
				return o2.oil - o1.oil;
			}
		});
		
		// 아직 들를 수 없는 주유소
		PriorityQueue<OilStation> next = new PriorityQueue<OilStation>(new Comparator<OilStation>() {
			@Override
			public int compare(OilStation o1, OilStation o2) {
				if (o1.distance == o2.distance)
					return o2.oil - o1.oil;
				return o1.distance - o2.distance;
			}
		});

		// 주유소까지의 거리, 채울 수 있는 연료의 양
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			distance = Integer.parseInt(st.nextToken());
			oil = Integer.parseInt(st.nextToken());
			next.add(new OilStation(distance, oil));
		}
		
		// 마을까지의 거리, 트럭에 있던 연료의 양
		st = new StringTokenizer(in.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		// 갈 수 있는 주유소 중 가장 연료가 많은 곳 들르기
		while (L > P) {
			while (!next.isEmpty() && next.peek().distance <= P) {
				curr.add(next.poll());
			}
			if (curr.isEmpty()) {
				System.out.println(-1);
				return;
			}
			P += curr.poll().oil;
			cnt++;
		}
		System.out.println(cnt);
	}

}

//public class BJ1826_연료채우기 {
//
//	static class OilStation implements Comparable<OilStation> {
//		int distance, oil;
//
//		public OilStation(int distance, int oil) {
//			this.distance = distance;
//			this.oil = oil;
//		}
//
//		@Override
//		public int compareTo(OilStation o) {
//			if (this.oil == o.oil)
//				return this.distance - o.distance;
//			return o.oil - this.oil;
//		}
//	}
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//
//		int N, distance, oil, L, P, cnt = 0;
//		N = Integer.parseInt(in.readLine());
//		OilStation[] arr = new OilStation[N];
//		boolean[] visited = new boolean[N];
//
//		// 주유소까지의 거리, 채울 수 있는 연료의 양
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(in.readLine(), " ");
//			distance = Integer.parseInt(st.nextToken());
//			oil = Integer.parseInt(st.nextToken());
//			arr[i] = new OilStation(distance, oil);
//		}
//
//		// 마을까지의 거리, 트럭에 있던 연료의 양
//		st = new StringTokenizer(in.readLine(), " ");
//		L = Integer.parseInt(st.nextToken());
//		P = Integer.parseInt(st.nextToken());
//
//		// 연료를 많이 채울 수 있는 순으로 정렬
//		Arrays.sort(arr);
//
//		int idx = 0;
//		while (L > P) {
//			if (!visited[idx] && arr[idx].distance <= P) {
//				P += arr[idx].oil;
//				visited[idx] = true;
//				idx = 0;
//				cnt++;
//			}
//			else if (++idx >= N) {
//				System.out.println(-1);
//				return;
//			}
//		}
//		System.out.println(cnt);
//	}
//
//}
