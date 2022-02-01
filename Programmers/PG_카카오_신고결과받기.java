package codingtest.kakao;

import java.util.*;

public class 카카오블라인드1 {

	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}

	static public int[] solution(String[] id_list, String[] report, int k) {
		int N = id_list.length; // 이용자 ID의 수
		String arr[] = null; // 신고한 ID 정보 담을 배열

		// 각 유저별 ID와 id_list에서의 순서 저장
		Map<String, Integer> user = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			user.put(id_list[i], i);
		}

		// 각 유저별 다른 이용자 신고 여부 저장 (이용자id-신고한id)
		boolean checked[][] = new boolean[N][N];
		for (int i = 0; i < report.length; i++) {
			arr = report[i].split(" "); // 신고 정보 배열로 분리
			checked[user.get(arr[0])][user.get(arr[1])] = true;
		}

		// 각 유저별 신고당한 횟수 계산
		int count, report_count[] = new int[N];
		for (int i = 0; i < N; i++) {
			count = 0;
			for (int j = 0; j < N; j++) {
				if (checked[j][i]) {
					count++;
				}
			}
			report_count[i] = count;
		}

		// 각 유저별 처리 결과 메일을 받은 횟수 계산
		int answer[] = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// i 유저가 신고한 j 유저의 이용이 정지 되면 메일 발송
				// k번 이상 신고되었을 경우 게시판 이용이 정지됨
				if (checked[i][j] && report_count[j] >= k) {
					answer[i]++;
				}
			}
		}

		return answer;
	}

}
