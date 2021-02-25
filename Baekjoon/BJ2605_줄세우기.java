package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ2605_줄세우기 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (list.isEmpty()) list.add(i);
			else {
				tmp = list.size()-tmp;
				list.add(tmp, i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}
}
