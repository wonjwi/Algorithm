package week16;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2597_줄자접기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		double N = Integer.parseInt(in.readLine());
		double move = 0.0, temp;
		
		double map[][] = new double[3][2];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			
			if (map[i][0] > map[i][1]) {
				temp = map[i][0];
				map[i][0] = map[i][1];
				map[i][1] = temp;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (map[i][0] == map[i][1]) continue;
			
			N = Math.max(map[i][0], N-map[i][1]) + (map[i][1]-map[i][0])/2;
			
			move = (map[i][0]+map[i][1])/2;
			for (int j = i+1; j < 3; j++) {
				for (int k = 0; k < 2; k++) {
					if (map[j][k] > move) map[j][k] -= move;
					else map[j][k] = move - map[j][k];
				}
			}
		}
		System.out.printf("%.1f", N);
	}

}
