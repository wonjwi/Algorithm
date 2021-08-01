package week24;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2467_용액 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		int num[] = new int[N];

		// 각 용액의 특성값 입력 (오름차순)
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		// 두 용액을 혼합한 용액의 특성값 탐색
		int left = 0, right = N - 1, tmp;
		int min = Integer.MAX_VALUE, ans_left = 0, ans_right = 0;

		while (left < right) {
			tmp = num[left] + num[right];

			// 0에 가장 가까운 특성값 저장
			if (min > Math.abs(tmp)) {
				min = Math.abs(tmp);
				ans_left = num[left];
				ans_right = num[right];
			}

			// 다음 탐색 위치 조정
			if (tmp == 0) {
				break;
			}
			else if (tmp < 0) {
				left++;
			} else {
				right--;
			}
		}

		// 특성값이 가장 가까운 두 용액 출력
		System.out.println(ans_left + " " + ans_right);
	}

}

//public class BJ2467_용액 {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//
//		int N = Integer.parseInt(in.readLine());
//		int num[] = new int[N];
//		int left, right, mid, tmp, min = Integer.MAX_VALUE;
//		int answer1 = 0, answer2 = 0;
//
//		// 각 용액의 특성값 입력 (오름차순)
//		st = new StringTokenizer(in.readLine(), " ");
//		for (int i = 0; i < N; i++) {
//			num[i] = Integer.parseInt(st.nextToken());
//		}
//
//		// 시작 위치 바꿔가면서 용액의 특성값 구해보기
//		Loop: for (int i = 0; i < N - 1; i++) {
//			// 이분 탐색 시작점 초기화
//			left = i + 1;
//			right = N - 1;
//
//			while (left <= right) {
//				mid = (left + right) / 2;
//
//				// 두 용액을 혼합한 용액의 특성값
//				tmp = num[i] + num[mid];
//
//				// 0에 가장 가까운 특성값 저장
//				if (min > Math.abs(tmp)) {
//					min = Math.abs(tmp);
//					answer1 = i;
//					answer2 = mid;
//				}
//				
//				if (tmp < 0) {
//					left = mid + 1;
//				}
//				else if (tmp > 0) {
//					right = mid - 1;
//				}
//				else {
//					break Loop;
//				}
//			}
//		}
//		System.out.println(num[answer1] + " " + num[answer2]);
//	}
//
//}
