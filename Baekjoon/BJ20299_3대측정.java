package algopractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** 20299. 3대 측정
 * VIP 클럽에 가입이 가능한 팀의 수와 VIP 회원들의 레이팅을 입력받은 순서대로 출력
 */
public class BJ20299_3대측정 {
	
	public static void main(String[] args) throws Exception {
		// Input Data를 입력 받을 BufferedReader 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader에서 입력 받은 한 줄을 StringTokenizer로 구분자별로 쪼갠다.
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int count = 0;
		// VIP 클럽에 가입이 가능한 회원들의 레이팅 List
		List<Integer> members = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			// VIP 클럽에 가입한 회원들의 레이팅 배열
			int[] score = new int[3];
			// VIP 클럽에 신청한 회원들의 레이팅 합 초기화
			int sumOfScore = 0;
			for (int j = 0; j < 3; j++) {
				int temp = Integer.parseInt(st.nextToken());
				// 최소 레이팅을 충족하지 못하면 PASS
				if (temp < L) {
					sumOfScore = -1;
					break;
				}
				score[j] = temp;
				sumOfScore += temp;
			}
			// 클럽 가입 조건을 충족할 경우 List에 추가
			if (sumOfScore >= K) {
				count++;
				for (int j = 0; j < 3; j++) {
					members.add(score[j]);
				}
			}
		}
		StringBuilder result = new StringBuilder();
		result.append(count).append("\n");
		for (int s : members) {
			result.append(s).append(" ");
		}
		System.out.println(result);
	}
	
}