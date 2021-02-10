package homework;

import java.io.*;
import java.util.*;

//16935. 배열 돌리기 3
//크기가 N×M인 배열이 있을 때, 배열에 연산을 R번 적용하려고 한다.
public class BJ16935_배열돌리기3 {
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken()); // 연산의 수
		// 입력 배열 저장
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// R번의 연산을 실행 (1~6번 중 R개가 주어짐)
		st = new StringTokenizer(in.readLine());
		for (int r = 0; r < R; r++) {
			switch (st.nextToken()) {
			case "1":
				upDownReverse(arr);
				break;
			case "2":
				leftRightReverse(arr);
				break;
			case "3":
				arr = rightRotate(arr);
				break;
			case "4":
				arr = leftRotate(arr);
				break;
			case "5":
				arr = quarterMove1(arr);
				break;
			case "6":
				arr = quarterMove2(arr);
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static int[][] quarterMove2(int[][] arr) {
		int[][] move = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i/(N/2) == 0) {
					// 1번 그룹
					if (j/(M/2) == 0)
						move[i+N/2][j] = arr[i][j];
					// 2번 그룹
					else 
						move[i][j-M/2] = arr[i][j];
				} else {
					// 3번 그룹
					if (j/(M/2) == 1)
						move[i-N/2][j] = arr[i][j];
					// 4번 그룹
					else
						move[i][j+M/2] = arr[i][j];
				}
			}
		}
		return move;
	}
	private static int[][] quarterMove1(int[][] arr) {
		int[][] move = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i/(N/2) == 0) {
					// 1번 그룹
					if (j/(M/2) == 0)
						move[i][j+M/2] = arr[i][j];
					// 2번 그룹
					else 
						move[i+N/2][j] = arr[i][j];
				} else {
					// 3번 그룹
					if (j/(M/2) == 1)
						move[i][j-M/2] = arr[i][j];
					// 4번 그룹
					else
						move[i-N/2][j] = arr[i][j];
				}
			}
		}
		return move;
	}
	private static int[][] leftRotate(int[][] arr) {
		int[][] rotate = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rotate[M-1-j][i] = arr[i][j];
			}
		}
		// M 값과 N 값 바꾸기
		int temp = M; M = N; N = temp;
		return rotate;
	}
	private static int[][] rightRotate(int[][] arr) {
		int[][] rotate = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rotate[j][N-1-i] = arr[i][j];
			}
		}
		// M 값과 N 값 바꾸기
		int temp = M; M = N; N = temp;
		return rotate;
	}
	private static void leftRightReverse(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M/2; j++) {
				int temp = arr[i][M-1-j];
				arr[i][M-1-j] = arr[i][j];
				arr[i][j] = temp;
			}
		}
	}
	private static void upDownReverse(int[][] arr) {
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[N-1-i][j];
				arr[N-1-i][j] = temp;
			}
		}
	}
}