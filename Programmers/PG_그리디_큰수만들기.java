package week08;

public class PG_그리디_큰수만들기 {
	
	public static void main(String[] args) {
		String number = "99999999";
		int k = 4;
		
		// String을 char 배열로 변환
		char[] arr = number.toCharArray();
		
		// 제일 큰 숫자 만들기
		StringBuilder num = new StringBuilder();
		int start = 0, max = -1, idx = -1;
		int total = arr.length-k;
		while (k > 0) {
			// 범위 내에서 가장 큰 숫자 찾기
			max = -1; idx = -1;
			for (int i = start; i <= start+k; i++) {
				if (i < arr.length && max < arr[i]) {
					max = arr[i];
					idx = i;
				}
			}
			num.append(max-'0');
			if (num.length() == total) break;
			k -= (idx-start);
			start = idx+1;
		}
		if (num.length() < total) {
			for (int i = idx+1; i < arr.length; i++) {
				num.append(arr[i]);
			}
		}
		
		System.out.println(num.toString());
	}
	
//	import java.util.LinkedList;
//
//	class Solution {
//	    public String solution(String number, int k) {
//	        // String을 char로 변환 후 리스트에 넣기
//	        char[] arr = number.toCharArray();
//	        LinkedList<Character> num = new LinkedList<Character>();
//	        for (int i = 0; i < arr.length; i++) {
//	            num.add(arr[i]);
//	        }
//	        // 앞 뒤 숫자 비교하면서 정리
//	        int i = 0;
//	        while (true) {
//	            if (num.get(i) < num.get(i+1)) {
//	                num.remove(i); k--; i--;
//	            }
//	            else i++;
//	            if (i < 0 || i >= num.size()-1) i = 0;
//	            if (k == 0) break;
//	        }
//	        // while문 종료되면 숫자로 변환
//	        String answer = "";
//	        for (char c : num) {
//	            answer += c;
//	        }
//	        return answer;
//	    }
//	}

}
