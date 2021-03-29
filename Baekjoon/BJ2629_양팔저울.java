package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2629_양팔저울 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		// 추의 개수 (30 이하)
		int N = Integer.parseInt(in.readLine());
		// 가벼운 것부터 차례로 주어진 추의 무게 입력
		st = new StringTokenizer(in.readLine(), " ");
		int[] weight = new int[N]; // 추의 무게를 저장할 배열
		int max = 0; // 측정 할 수 있는 최대값 구하기
		for (int i = 0; i < N; i++) {
			// 입력 받은 값을 정수로 변환해서 저장하기
			weight[i] = Integer.parseInt(st.nextToken());
			max += weight[i]; // 추 무게의 합
		}
		
		// 추를 이용해 확인 할 수 있는 무게 미리 구하기
		boolean[][] possible = new boolean[N+1][max+1]; // 최대값으로 배열 생성
		make(possible, weight, 0, N, 0);
		
		// 무게를 확인하고자 하는 구슬의 개수 (7 이하)
		int M = Integer.parseInt(in.readLine());
		// 확인하고자 하는 구슬들의 무게 입력
		st = new StringTokenizer(in.readLine(), " ");
		int[] ball = new int[M]; // 구슬의 무게를 저장할 배열
		for (int i = 0; i < M; i++) {
			// 입력 받은 값을 정수로 변환해서 저장하기
			ball[i] = Integer.parseInt(st.nextToken());
		}
		
		// 구슬의 무게를 확인할 수 있는 지 검사
		for (int i = 0; i < M; i++) {
			// 확인이 가능하면 Y, 아니면 N을 차례로 출력
			boolean flag = false;
			if (ball[i] <= max) {
				for (int j = 1; j <= N; j++) {
					flag = possible[j][ball[i]];
					if (flag) break;
				}
			}
			sb.append(flag ? "Y " : "N ");
		}
		// StringBuilder 출력
		System.out.println(sb.toString());
	}
	
	private static void make(boolean[][] possible, int[] weight, int cnt, int N, int curr) {
		// 이미 있는 값이면 가지치기
		if (possible[cnt][curr]) return;
		// 만들어진 무게에 true 체크
		possible[cnt][curr] = true; 
		// 놓아볼 수 있는 추를 다 쓰면 종료
		if (cnt == N) return;
		
		// 왼쪽에 놓기, 오른쪽에 놓기, 놓지 않기 모두 시도
		make(possible, weight, cnt+1, N, curr+weight[cnt]);
		make(possible, weight, cnt+1, N, Math.abs(curr-weight[cnt]));
		make(possible, weight, cnt+1, N, curr);
	}
	
}
