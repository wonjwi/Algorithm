package week18;

import java.io.*;
import java.util.*;

public class BJ14719_빗물 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine(), " ");
		
		int block[] = new int[W];
		int left[] = new int[W];
		int right[] = new int[W];
		int leftTop = 0, rightTop = 0, top, total = 0;
		
		for (int i = 0; i < W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		// 왼쪽에 있는 블록 중 가장 큰 높이
		for (int i = 0; i < W - 1; i++) {
			leftTop = Math.max(leftTop, block[i]);
			left[i + 1] = leftTop;
		}
		// 오른쪽에 있는 블록 중 가장 큰 높이
		for (int i = W - 1; i > 0; i--) {
			rightTop = Math.max(rightTop, block[i]);
			right[i - 1] = rightTop;
		}
		for (int i = 0; i < W; i++) {
			top = Math.min(left[i], right[i]);
			if (top > block[i]) {
				total += top - block[i];
			}
		}
		System.out.println(total);
	}

}
