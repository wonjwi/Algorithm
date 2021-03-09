package week06;

import java.util.Stack;

public class PG_카카오_인형뽑기 {
	
	class Solution {
	    public int solution(int[][] board, int[] moves) {
	    	int answer = 0;
	    	int N = board[0].length;
	    	// 인형이 몇 번째 줄까지 쌓여 있는 지 구하기
	    	int[] topRow = new int[N];
	    	for (int c = 0; c < N; c++) {
				for (int r = N-1; r >= 0; r--) {
					// 빈 칸을 만나면 값 저장 후 종료
					if (board[r][c] == 0) {
						topRow[c] = r+1;
						break;
					}
				}
			}
	    	// 뽑은 인형을 담는 바구니
	    	Stack<Integer> stack = new Stack<Integer>();
	    	// 크레인 작동시켜 인형뽑기
	    	int T = moves.length;
	        for (int i = 0; i < T; i++) {
	        	// 뽑을 인형이 있을 때
	        	int col = moves[i]-1;
	        	int top = topRow[col];
				if (top < N) {
					// 바구니의 맨 위와 같으면 터트리기
					if (!stack.empty() && stack.peek() == board[top][col]) {
						stack.pop();
						answer += 2;
					} else {
						stack.push(board[top][col]);
					}
					topRow[col]++;
				}
			}
	        return answer;
	    }
	}

}
