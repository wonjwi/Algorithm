package codingtest.programmers;

public class PG_월코챌_음양더하기 {
	
	public static void main(String[] args) {
//		int[] absolutes = {4,7,12};
//		boolean[] signs = {true,false,true};
		int[] absolutes = {1,2,3};
		boolean[] signs = {false,false,true};
		int answer = 0;
		int len = absolutes.length;
		for (int i=0; i<len; i++) {
			if (signs[i]) answer += absolutes[i];
			else answer -= absolutes[i];
		}
		System.out.println(answer);
	}

}
