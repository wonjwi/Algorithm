package week12;

import java.util.Arrays;

public class PG_그리디_구명보트 {
	
	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
//		int[] people = {70, 80, 50};
		int limit = 100;
		System.out.println(solution(people, limit));
	}

	static public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 몸무게 오름차순으로 정렬
        Arrays.sort(people);
        
        // 가장 가벼운 사람과 무거운 사람 비교
        int min = 0;
        int max = people.length-1;
        while (min <= max) {
            // 두 사람을 같이 태울수 있다면
            if (people[min]+people[max] <= limit) {
                min++;
                max--;
            } else {
                max--;
            }
            answer++;
        }
        return answer;
    }
	/*
	static public int solution(int[] people, int limit) {
        int N = people.length;
        // 몸무게별 사람수 카운팅
        int min = 242; int max = 39;
        int[] cnt = new int[limit+1];
        for (int i=0; i<N; i++) {
            min = Math.min(min, people[i]);
            max = Math.max(max, people[i]);
            cnt[people[i]]++;
        }
        // 두 사람을 태울 수 있는지 확인
        while (true) {
        	// 가장 가벼운 두 명도 태울 수 없다면
            if (min*2 > limit) break;
            // 두 사람을 태울 수 있을 때까지 max 값 갱신
            while (min+max > limit) {
                for (int i=max-1; i>=min; i--) {
                    max = i;
                    if (cnt[i] != 0) break;
                }
            }
            // 두 사람씩 태울 수 있는 만큼 빼기
            if (min == max) {
                N -= (cnt[min]/2);
                break;
            }
            if (cnt[min] < cnt[max]) {
                N -= cnt[min];
                cnt[max] -= cnt[min];
                cnt[min] = 0;
                // 새로운 min 값 찾기
                for (int i=min+1; i<=max; i++) {
                    min = i;
                    if (cnt[i] != 0) break;
                }
            } else {
                N -= cnt[max];
                cnt[min] -= cnt[max];
                cnt[max] = 0;
                // 새로운 max 값 찾기
                for (int i=max-1; i>=min; i--) {
                    max = i;
                    if (cnt[i] != 0) break;
                }
            }
        }
        return N;
    }
    */
}
