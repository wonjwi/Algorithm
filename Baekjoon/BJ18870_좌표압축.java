package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int num[] = new int[N];
		int sort[] = new int[N], idx = 0;
		Set<Integer> set = new HashSet<>();

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());

			if (set.contains(num[i]))
				continue;

			set.add(num[i]);
			sort[idx++] = num[i];
		}

		// 입력된 만큼만 가져와서 정렬
		sort = Arrays.copyOf(sort, idx);
		Arrays.sort(sort);

		// binarySearch 이용
		for (int i = 0; i < N; i++) {
			sb.append(Arrays.binarySearch(sort, num[i])).append(" ");
		}
		
		// Map 이용
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < idx; i++) {
//			map.put(sort[i], i);
//		}
//
//		for (int i = 0; i < N; i++) {
//			sb.append(map.get(num[i])).append(" ");
//		}

		System.out.println(sb.toString());
	}

}