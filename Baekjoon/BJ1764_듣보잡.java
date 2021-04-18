package week11;

import java.io.*;
import java.util.*;

public class BJ1764_듣보잡 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> list = new HashSet<String>();
		ArrayList<String> result = new ArrayList<String>();
		int count = 0;
		
		// 듣도 못한 사람
		for (int i = 0; i < N; i++) {
			list.add(in.readLine().trim());
		}
		// 보도 못한 사람
		for (int i = 0; i < M; i++) {
			String name = in.readLine().trim();
			// 듣보잡 저장
			if (list.contains(name)) {
				result.add(name);
				count++;
			};
		}
		sb.append(count).append("\n");
		
		// 듣보잡 목록 정렬
		Collections.sort(result);
		
		// 듣보잡 목록 출력
		for (String str : result) {
			sb.append(str).append("\n");
		}
		System.out.println(sb.toString());
	}

}
