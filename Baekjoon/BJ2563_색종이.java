package homework;

import java.io.*;
import java.util.*;

//2563. 색종이
//가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지 위에 
//가로, 세로의 크기가 10인 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 
//색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하라.
public class BJ2563_색종이 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 색종이의 수
		boolean[][] paper = new boolean[100][100]; // 도화지
		int area = 0; // 색종이가 붙은 영역의 넓이
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken()); // 왼쪽과의 거리
			int y = Integer.parseInt(st.nextToken()); // 아래쪽과의 거리
			// 색종이가 도화지 밖으로 나가는 경우 없으므로 인덱스 확인 X
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					// 이미 붙은 영역이면 지나치고 아니면 확인
					if (paper[x+j][y+i]) continue;
					else {
						paper[x+j][y+i] = true;
						area++;
					}
				}
			}
		}
		System.out.println(area);
	}
}