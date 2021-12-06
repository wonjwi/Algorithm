package algorithm;

import java.io.*;
import java.util.*;

public class BJ1181_단어정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		// 중복 입력을 받지 않기 위해 Set 사용
		HashSet<String> words = new HashSet<String>();

		for (int i = 0; i < N; i++) {
			words.add(in.readLine());
		}

		// List와 Comparator를 이용하여 정렬
		ArrayList<String> list = new ArrayList<String>(words);

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});

		// 조건에 맞게 출력
		for (String str : list) {
			sb.append(str).append("\n");
		}

		System.out.println(sb.toString());
	}

}