package week06;

public class PG_스택큐_주식가격 {
	
	class Solution {
	    public int[] solution(int[] prices) {
	    	int len = prices.length;
	        int[] answer = new int[len];
	        for (int i = 0; i < len; i++) {
	        	int curr = prices[i];
	        	int cnt = 0;
				for (int j = i; j < len-1; j++) {
					if (curr <= prices[j]) cnt++;
					else break;
				}
				answer[i] = cnt;
			}
	        return answer;
	    }
	}

}
