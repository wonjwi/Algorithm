package week20;

import java.util.*;

public class PG_탐색_여행경로 {

	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		System.out.println(Arrays.toString(solution(tickets)));
	}

	static List<String> answerList;

	static public String[] solution(String[][] tickets) {
		boolean visited[] = new boolean[tickets.length];
		answerList = new ArrayList<String>();

		// ICN 공항에서 출발하는 경로 탐색
		DFS(tickets, visited, "ICN", "ICN", 0);

		// 알파벳 순서가 앞서는 경로 찾기
		Collections.sort(answerList);
		String[] answer = answerList.get(0).split(" ");
		return answer;
	}

	private static void DFS(String[][] tickets, boolean[] visited, String curr, String route, int cnt) {
		// 여행경로를 완성
		if (cnt == tickets.length) {
			answerList.add(route);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			// 아직 사용하지 않았으면서 현재 위치에서 출발하는 항공권
			if (!visited[i] && tickets[i][0].equals(curr)) {
				visited[i] = true;
				// 다음 여행경로 탐색
				DFS(tickets, visited, tickets[i][1], route + " " + tickets[i][1], cnt + 1);
				visited[i] = false;
			}
		}
		return;
	}

}
