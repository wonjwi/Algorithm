package week08;

import java.util.*;
import java.util.Map.Entry;

public class PG_카카오_메뉴리뉴얼 {
	
	static HashMap<String, Integer> map[];
	static int min, max;

	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2, 3, 4};
		
		// 메뉴 조합 횟수를 저장할 HashMap 생성
		min = course[0];
		max = course[course.length-1];
		map = new HashMap[max+1];
		for (int i = min; i <= max; i++) {
			map[i] = new HashMap<String, Integer>();
		}
		
		// 주문내역에서 메뉴 조합 횟수 세기
		for (int i = 0; i < orders.length; i++) {
			char[] tmp = orders[i].toCharArray();
			Arrays.sort(tmp);
			count(new String(tmp), "", orders[i].length(), 0, 0);
		}
		
		// 가장 많이 주문된 메뉴 조합 구하기
		List<String> ans = new ArrayList<String>();
		for (int i = 0; i < course.length; i++) {
			List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map[course[i]].entrySet());
			Collections.sort(list, new Comparator<Entry<String, Integer>>() {
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue()); // 내림차순
				}
			});
			int max = 0;
			for (Entry<String, Integer> entry : list) {
				String key = entry.getKey();
				int val = entry.getValue();
				if (max != 0 && max != val) break;
				if (val >= 2) {
					ans.add(key);
					max = val;
				}
			}
		}
		Collections.sort(ans, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int len = Math.min(o1.length(), o2.length());
				for (int i = 0; i < len; i++) {
					if (o1.charAt(i) > o2.charAt(i)) return 1;
					else if (o1.charAt(i) == o2.charAt(i)) continue;
					else return -1;
				}
				if (o1.length() > o2.length()) return 1;
				return -1;
			}
		});
		String[] answer = ans.toArray(new String[ans.size()]);
		System.out.println(Arrays.toString(answer));
	}

	private static void count(String str, String tmp, int N, int cnt, int start) {
		if (cnt == N) {
			int len = tmp.length();
			if (len < min || len > max) return;
			if (map[len].containsKey(tmp))
				map[len].put(tmp, map[len].get(tmp)+1);
			else
				map[len].put(tmp, 1);
			return;
		}
		for (int i = start; i < N; i++) {
			count(str, tmp, N, cnt+1, i+1);
			count(str, tmp+str.charAt(i), N, cnt+1, i+1);
		}
	}

}
