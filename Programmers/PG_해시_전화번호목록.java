package week09;

import java.util.Arrays;

public class PG_해시_전화번호목록 {
	
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
	    boolean answer = true;
	    
	    Arrays.sort(phone_book); // 사전순 정렬
	    
	    int len = phone_book.length;
	    for (int i = 0; i < len-1; i++) {
	    	// 한 번호와 다음 번호를 비교
	    	int len1 = phone_book[i].length();
	    	int len2 = phone_book[i+1].length();
	    	// 뒷 번호가 앞 번호보다 짧으면 패스
	    	if (len1 > len2) continue;
			// 한 번호가 다른 번호의 접두사
	    	if (phone_book[i+1].startsWith(phone_book[i])) {
				answer = false;
				break;
			}
		}
	    
		System.out.println(answer);
	}
	
}

//class Solution {
//    public boolean solution(String[] phone_book) {
//        boolean answer = true;
//        
//        Arrays.sort(phone_book); // 사전순 정렬
//	    
//	    int len = phone_book.length;
//	    for (int i = 0; i < len-1; i++) {
//	    	int len1 = phone_book[i].length();
//	    	String str1 = phone_book[i];
//	    	// 한 번호와 다음 번호를 비교
//			int len2 = phone_book[i+1].length();
//			String str2 = phone_book[i+1];
//			boolean flag = true;
//			if (len1 < len2) {
//				for (int k = 0; k < len1; k++) {
//					if (str1.charAt(k) != str2.charAt(k)) {
//						flag = false;
//						break;
//					}
//				}
//			} else {
//				for (int k = 0; k < len2; k++) {
//					if (str1.charAt(k) != str2.charAt(k)) {
//						flag = false;
//						break;
//					}
//				}
//			}
//			// 한 번호가 다른 번호의 접두사
//			if (flag) {
//				answer = false;
//				break;
//			}
//		}
//        
//        return answer;
//    }
//}