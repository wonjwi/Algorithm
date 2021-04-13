package week11;

import java.io.*;
import java.util.*;

public class BJ17281_야구 {
	
	static char[][] map;
	static int N, ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		// 각 선수가 각 이닝에서 얻는 결과 입력
		// 안타:1, 2루타:2, 3루타:3, 홈런:4, 아웃:0
		map = new char[N][10];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= 9; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		// 출전 순서 조합 만들기
		int[] order = new int[10];
		order[4] = 1; // 1번 선수는 4번 타자로 고정
		boolean[] selected = new boolean[10];
		selected[1] = true;
		makeOrder(order, selected, 1);
		
		// 얻을 수 있는 최대 점수
		System.out.println(ans);
	}

	private static void makeOrder(int[] order, boolean[] selected, int cnt) {
		// 4번 타자는 뽑혀있으니 제외
		if (cnt == 4) cnt++;
		// 나머지 순서 조합 만들기
		for (int i = 2; i <= 9; i++) {
			if (selected[i]) continue;
			order[cnt] = i;
			selected[i] = true;
			makeOrder(order, selected, cnt+1);
			selected[i] = false;
		}
		if (cnt == 9) {
			// 순서 조합으로 경기 실행
			ans = Math.max(ans, play(order));
			return;
		}
	}

	private static int play(int[] order) {
		int point = 0, inning = 0, out = 0;
		boolean[] isThere = new boolean[4];
		for (int i = 1; i <= 9; i++) {
			// 이닝이 끝났으면 종료
			if (inning == N) break;
			// 현재 타자의 현재 이닝 결과
			int curr = map[inning][order[i]]-'0';
			// 9번 타자까지 왔으면 다시 1번으로
			if (i == 9) i = 0;
			// 아웃일 경우
			if (curr == 0) {
				out++;
				if (out == 3) {
					inning++;
					out = 0;
					Arrays.fill(isThere, false);
				}
				continue;
			}
			// 홈런일 경우
			else if (curr == 4) {
				for (int j = 0; j < 4; j++) {
					if (isThere[j]) {
						isThere[j] = false;
						point++;
					}
				}
				point++;
			}
			// 안타일 경우
			else {
				// 주자들을 안타수만큼 이동
				for (int j = 3; j >= 1; j--) {
					if (isThere[j]) {
						isThere[j] = false;
						// 홈에 도착하면 점수 획득
						if (j+curr >= 4) point++;
						// 도착하지 않았으면 진루
						else isThere[j+curr] = true;
					}
				}
				// 새로운 주자 진루
				isThere[curr] = true;
			}
		}
		return point;
	}

}

//public class BJ17281_야구 {
//	
//	static char[][] map;
//	static int N, ans = 0;
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(in.readLine());
//		// 각 선수가 각 이닝에서 얻는 결과 입력
//		// 안타:1, 2루타:2, 3루타:3, 홈런:4, 아웃:0
//		map = new char[N][10];
//		for (int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
//			for (int j = 1; j <= 9; j++) {
//				map[i][j] = st.nextToken().charAt(0);
//			}
//		}
//		// 출전 순서 조합 만들기
//		int[] order = new int[10];
//		order[4] = 1; // 1번 선수는 4번 타자로 고정
//		boolean[] selected = new boolean[10];
//		selected[1] = true;
//		makeOrder(order, selected, 1);
//		
//		// 얻을 수 있는 최대 점수
//		System.out.println(ans);
//	}
//
//	private static void makeOrder(int[] order, boolean[] selected, int cnt) {
//		// 4번 타자는 뽑혀있으니 제외
//		if (cnt == 4) cnt++;
//		// 나머지 순서 조합 만들기
//		for (int i = 2; i <= 9; i++) {
//			if (selected[i]) continue;
//			order[cnt] = i;
//			selected[i] = true;
//			makeOrder(order, selected, cnt+1);
//			selected[i] = false;
//		}
//		if (cnt == 9) {
//			// 순서 조합으로 경기 실행
//			int point = play(order);
//			ans = Math.max(ans, point);
//			return;
//		}
//	}
//
//	private static int play(int[] order) {
//		int point = 0, inning = 0, out = 0;
//		Queue<Integer> q = new LinkedList<Integer>();
//		for (int i = 1; i <= 9; i++) {
//			// 이닝이 끝났으면 종료
//			if (inning == N) break;
//			// 현재 타자의 현재 이닝 결과
//			int curr = map[inning][order[i]]-'0';
//			// 9번 타자까지 왔으면 다시 1번으로
//			if (i == 9) i = 0;
//			// 아웃일 경우
//			if (curr == 0) {
//				out++;
//				if (out == 3) {
//					inning++;
//					out = 0;
//					q.clear();
//				}
//				continue;
//			}
//			// 홈런일 경우
//			else if (curr == 4) {
//				point += q.size()+1;
//				q.clear();
//			}
//			// 안타일 경우
//			else {
//				// 주자들을 안타수만큼 이동
//				int size = q.size();
//				for (int j = 0; j < size; j++) {
//					int tmp = q.poll()+curr;
//					// 홈에 도착하면 점수 획득
//					if (tmp >= 4) point++;
//					// 도착하지 않았으면 진루
//					else q.add(tmp);
//				}
//				// 새로운 주자 진루
//				q.add(curr);
//			}
//		}
//		return point;
//	}
//
//}
