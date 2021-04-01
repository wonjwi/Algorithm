package week09;

import java.util.*;

public class PG_카카오_오픈채팅방 {
	
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi","Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
	    
		Map<String, String> map = new HashMap<String, String>();
		List<String[]> ans = new ArrayList<String[]>();
		String enter = "님이 들어왔습니다.";
		String leave = "님이 나갔습니다.";
	    for (String str : record) {
	    	String[] tmp = str.split(" ");
	    	switch (tmp[0].charAt(0)) {
			case 'E':
				map.put(tmp[1], tmp[2]);
				ans.add(new String[] {tmp[1], enter});
				break;
			case 'L':
				ans.add(new String[] {tmp[1], leave});
				break;
			case 'C':
				map.put(tmp[1], tmp[2]);
				break;
			}
	    }
	    
	    int size = ans.size();
	    String[] answer = new String[size];
	    for (int i = 0; i < size; i++) {
	    	String[] tmp = ans.get(i);
	    	StringBuilder sb = new StringBuilder();
	    	sb.append(map.get(tmp[0])).append(tmp[1]);
			answer[i] = sb.toString();
		}
		System.out.println(Arrays.toString(answer));
	}
	
}
