package homework;
import java.io.*;
import java.util.*;

/**
 * 2493. 탑
 * 탑들은 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세워진다.
 * 레이저 신호는 지표면과 평행하게 수평 직선의 왼쪽 방향으로 발사되고,
 * 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다. 
 * 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내라.
 * -------------------------------------------------------
 * 왼쪽 방향으로 발사되므로 입력하면서 바로 결과 구하기!
 * 
 */
public class BJ2493_탑 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 탑의 개수 N과 탑들의 서로 다른 높이 입력
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		// 레이저 신호를 수신 하는 곳 구하기
		Stack<int[]> tower = new Stack<int[]>();
		int[] result = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			while (!tower.isEmpty()) {
				// 왼쪽 탑의 높이가 신호 보내는 탑보다 낮으면 제거
				if (tower.peek()[0] < temp) {
					tower.pop();
				} else {
					// 신호를 수신하는 탑의 위치 저장
					result[i] = tower.peek()[1];
					// 신호 보내는 탑을 스택에 저장
					tower.push(new int[] {temp, i});
					break;
				}
			}
			// 앞의 반복문을 돌리고 스택이 비었다면
			if (tower.isEmpty()) {
				// 탑의 위치는 0으로 하고 현재 탑을 스택에 저장
				result[i] = 0;
				tower.push(new int[] {temp, i});
			} 
		}
		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}