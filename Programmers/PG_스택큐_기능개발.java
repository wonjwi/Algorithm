package week26;

import java.util.*;

public class PG_스택큐_기능개발 {

	public static void main(String[] args) {
//		int[] progresses = { 93, 30, 55 };
//		int[] speeds = { 1, 30, 5 };
		int[] progresses = { 95, 90, 99, 99, 80, 99 };
		int[] speeds = { 1, 1, 1, 1, 1, 1 };

		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	static public int[] solution(int[] progresses, int[] speeds) {
		int N = progresses.length;
		int days[] = new int[N];

		for (int i = 0; i < N; i++) {
			int k = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0) {
				k++;
			}
			days[i] = k;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		int num = days[0], cnt = 1;
		
		for (int i = 1; i < N; i++) {
			if (num < days[i]) {
				list.add(cnt);
				cnt = 1;
				num = days[i];
			} else {
				cnt++;
			}
		}
		
		list.add(cnt);

		int answer[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
