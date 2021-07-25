package week23;

import java.io.*;
import java.util.Stack;

public class BJ6198_옥상정원꾸미기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int cnt; long answer = 0;
		int height[] = new int[N];
		Stack<int[]> building = new Stack<int[]>();

		// 각 빌딩의 높이 입력
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(in.readLine());
		}

		// 벤치마킹이 가능한 빌딩의 수 구하기
		for (int i = N - 1; i >= 0; i--) {
			cnt = 0;
			while (!building.isEmpty()) {
				// 옥상을 확인할 수 있는 경우
				if (building.peek()[0] < height[i]) {
					// 확인할 수 있는 옥상의 수 카운팅
					cnt += building.pop()[1] + 1;
				} else {
					break;
				}
			}
			// 확인할 수 있는 총 옥상의 수 스택에 저장
			building.add(new int[] { height[i], cnt });
			answer += cnt;
		}
		System.out.println(answer);
	}

}
