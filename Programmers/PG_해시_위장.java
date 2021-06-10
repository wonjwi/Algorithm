package week17;

import java.util.HashMap;

public class PG_해시_위장 {

	public static void main(String[] args) {
//		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
//				{ "green_turban", "headgear" } };
		String[][] clothes = { { "crowmask", "face" }, { "bluesunglasses", "face" }, { "smoky_makeup", "face" } };
		System.out.println(solution(clothes));
	}

	static public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int len = clothes.length;
		for (int i = 0; i < len; i++) {
			map.put(clothes[i][1], map.containsKey(clothes[i][1]) ? map.get(clothes[i][1]) + 1 : 1);
		}
		int answer = 1;
		for (String key : map.keySet()) {
			answer *= map.get(key) + 1;
		}
		return answer - 1;
	}

}
