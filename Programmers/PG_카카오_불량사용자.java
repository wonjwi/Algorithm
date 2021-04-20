package week12;

import java.util.*;

public class PG_카카오_불량사용자 {
	
	static int answer;
	static HashSet<HashSet<String>> result;
	
	public static void main(String[] args) {
//		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//		String[] banned_id = {"fr*d*", "abc1**"};
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		
		int len1 = banned_id.length;
		int len2 = user_id.length;
		ArrayList<String> candidate[] = new ArrayList[len1];
		for (int i = 0; i < len1; i++) {
			candidate[i] = new ArrayList<String>();
		}
		for (int i = 0; i < len1; i++) {
			String str1 = banned_id[i];
			for (int j = 0; j < len2; j++) {
				String str2 = user_id[j];
				if (str1.length() != str2.length()) continue;
				boolean flag = true;
				for (int k = 0, len = str1.length(); k < len; k++) {
					if (str1.charAt(k) == '*') continue;
					if (str1.charAt(k) != str2.charAt(k)) {
						flag = false; break;
					}
				}
				if (flag) candidate[i].add(str2);
			}
		}
		result = new HashSet<HashSet<String>>();
		permut(candidate, len1, 0, new String[len1]);
		
		answer = result.size();
		System.out.println(answer);
	}

	private static void permut(ArrayList<String>[] candidate, int N, int cnt, String[] list) {
		if (cnt == N) {
			HashSet<String> set = new HashSet<String>();
			for (int i = 0; i < N; i++) {
				set.add(list[i]);
			}
			if (set.size() == N) result.add(set);
			return;
		}
		for (int i = 0; i < candidate[cnt].size(); i++) {
			list[cnt] = candidate[cnt].get(i);
			permut(candidate, N, cnt+1, list);
		}
	}

}
