package codingtest.kakao;

public class 카카오블라인드2 {

	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		System.out.println(solution(n, k));
	}

	static public int solution(int n, int k) {
		StringBuilder sb = new StringBuilder();

		// 양의 정수 n을 k진수로 변환
		String convert_num = conversion(n, k);

		// 변환된 수 안에 있는 조건을 만족하는 소수의 개수
		int answer = 0;
		for (int i = 0, N = convert_num.length(); i < N; i++) {
			// 0으로 나뉠 때 기준으로 소수 판단
			if (convert_num.charAt(i) == '0') {
				if (sb.length() > 0 && isPrime(Long.parseLong(sb.toString()))) {
					answer++;
				}
				sb.setLength(0); // StringBuilder 초기화
			} else {
				sb.append(convert_num.charAt(i));
			}
		}
		// 마지막 숫자가 남아있을 경우 처리
		if (sb.length() > 0 && isPrime(Long.parseLong(sb.toString()))) {
			answer++;
		}

		return answer;
	}

	private static boolean isPrime(long long_num) {
		int num = Math.min((int) long_num, Integer.MAX_VALUE - 1);
		
		// 입력 받은 값이 int 범위 이내라면
		if (long_num == num) {
			// 소수가 아닌 수 저장할 배열
			boolean isNotPrime[] = new boolean[num + 1];
			isNotPrime[0] = isNotPrime[1] = true;
			
			// 에라토스테네스의 체로 소수 찾기
			for (int i = 2; i * i <= num; i++) {
				if (isNotPrime[i]) { // 이미 걸러진 값 패스
					continue;
				}
				for (int j = i * i; j <= num; j += i) {
					isNotPrime[j] = true;
				}
			}
		
			return !isNotPrime[num];
		}
		// 입력 받은 값이 int 범위를 초과한다면
		else {
			// 반복문으로 소수 판별 (제곱근까지만 진행)
			for (long i = 2; i * i <= long_num; i++) {
	            if (long_num % i == 0) {
	                return false;
	            }
	        }
	        return true;
		}
	}

	private static String conversion(int num, int k) {
		StringBuilder sb = new StringBuilder();

		// k로 나눈 나머지를 이용해서 진법 변환
		while (num > 0) {
			sb.insert(0, num % k);
			num /= k;
		}

		return sb.toString();
	}

}
