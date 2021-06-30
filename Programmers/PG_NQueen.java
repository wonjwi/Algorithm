package week20;

public class PG_NQueen {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	static int answer;

	static public int solution(int n) {
		answer = 0;

		// n개의 퀸을 배치
		nQueen(new int[n], 0, n);

		return answer;
	}

	private static void nQueen(int[] map, int cnt, int n) {
		// n개의 퀸 배치 완료
		if (cnt == n) {
			answer++;
			return;
		}
		// 퀸을 배치할 수 있는 위치(열) 찾기
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			// 기존에 배치된 퀸들의 위치 탐색
			for (int j = 0; j < cnt; j++) {
				// 같은 위치에 있거나 대각선 위치에 있다면 불가
				if (map[j] == i || Math.abs(cnt - j) == Math.abs(i - map[j])) {
					flag = false;
					break;
				}
			}
			// i번째 열에 퀸 배치 가능
			if (flag) {
				map[cnt] = i;
				nQueen(map, cnt + 1, n);
			}
		}
	}

}
