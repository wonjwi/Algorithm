package week16;

import java.io.*;
import java.util.StringTokenizer;

public class BJ13305_주유소 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int distance[] = new int[N];
		int price[] = new int[N];
		int prev = Integer.MAX_VALUE;
		long answer = 0;
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N-1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
//			도로로 이동할 때 1km마다 기름 1리터 사용
			if (price[i] < prev) {
				answer += (long)distance[i]*price[i];
				prev = price[i];
			} else {
				answer += (long)distance[i]*prev;
			}
		}
		System.out.println(answer);
	}

}
