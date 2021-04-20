package week12;

public class PG_카카오_단체사진찍기 {
	
	static int N, answer;
	static int[] a, b;
	static char[] sign;
	static int[] dis;

	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
//		String[] data = {"M~C<2", "C~M>1"};
		
		N = n; // 조건의 개수
		a = new int[N]; // 해당 프렌즈
		b = new int[N]; // 상대방
		sign = new char[N]; // =, <, >
		dis = new int[N]; // 서로의 거리
		
		for (int i = 0; i < N; i++) {
			a[i] = data[i].charAt(0)-'A';
	        b[i] = data[i].charAt(2)-'A';
	        sign[i] = data[i].charAt(3);
	        dis[i] = data[i].charAt(4)-'0'+1;
		}
		int[] kakao = {'A','C','F','J','M','N','R','T'};
		for (int i = 0; i < 8; i++) kakao[i] -= 'A';
		
		// 8!이므로 순열을 모두 구해본다.
		answer = 0;
		permut(kakao, new boolean[8], new int[26], 0);
        System.out.println(answer);
	}

	private static void permut(int[] kakao, boolean[] selected, int[] arr, int cnt) {
		if (cnt == 8) {
			if (isPossible(arr)) answer++;
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (selected[i]) continue;
			selected[i] = true;
			arr[kakao[i]] = cnt; // 프렌즈 위치 저장
			permut(kakao, selected, arr, cnt+1);
			selected[i] = false;
		}
	}

	private static boolean isPossible(int[] arr) {
		for (int i = 0; i < N; i++) {
			// 두 프렌즈 사이의 거리
			int tmp = Math.abs(arr[a[i]]-arr[b[i]]);
			// 조건에 맞지 않으면 false return;
			switch (sign[i]) {
			case '=':
				if (tmp != dis[i]) return false;
				break;
			case '<':
				if (tmp >= dis[i]) return false;
				break;
			case '>':
				if (tmp <= dis[i]) return false;
				break;
			}
		}
		return true;
	}

}
