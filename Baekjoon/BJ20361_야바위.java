package algopractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 20361. 일우는 야바위꾼
 * 게임이 끝난 후 공이 몇 번째 위치의 컵에 있어야 하는지 정수로 출력
 */
public class BJ20361_야바위 {
	
	public static void main(String[] args) throws Exception {
		// Input Data를 입력 받을 BufferedReader 생성
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader에서 입력 받은 한 줄을 StringTokenizer로 구분자별로 쪼갠다.
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		// 종이컵의 수 입력
		int N = Integer.parseInt(st.nextToken());
		// 정답 종이컵 번호
		int X = Integer.parseInt(st.nextToken());
		// 컵의 위치를 맞바꾸는 횟수
		int K = Integer.parseInt(st.nextToken());
		// 컵의 위치를 K번 맞바꾼다.
		for (int i = 0; i < K; i++) {
			// BufferedReader에서 입력 받은 한 줄을 StringTokenizer로 구분자별로 쪼갠다.
			st = new StringTokenizer(in.readLine(), " ");
			// 바꾼 두 컵의 위치 A, B
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// A가 정답이었으면 바뀐 위치 B를 X에 저장한다.
			if (A == X) X = B;
			// B가 정답이었으면 바뀐 위치 A를 X에 저장한다.
			else if (B == X) X = A;
		}
		// 게임 종료 후 정답 종이컵의 위치를 출력
		System.out.println(X);
	}

}