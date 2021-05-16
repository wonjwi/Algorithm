package week15;

import java.io.*;
import java.util.*;

public class BJ2473_세용액 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		long num[] = new long[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		long answer[] = new long[3];
		long sum, min = Long.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int j = i+1, k = N-1;
			while (j < k) {
				sum = num[i] + num[j] + num[k];
				if (min > Math.abs(sum)) {
					answer[0] = num[i];
					answer[1] = num[j];
					answer[2] = num[k];
					min = Math.abs(sum);
				}
				if (sum < 0) j++;
				else k--;
			}
		}
		Arrays.sort(answer);
		System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);
	}

}
