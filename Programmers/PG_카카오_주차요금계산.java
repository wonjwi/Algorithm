package codingtest.kakao;

import java.util.*;

public class 카카오블라인드3 {

	public static void main(String[] args) {
		int[] fees = { 180, 5000, 10, 600 };
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		System.out.println(Arrays.toString(solution(fees, records)));
	}

	static public int[] solution(int[] fees, String[] records) {
		// fees: 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
		// records: "시각 차량번호 내역" 형식의 문자열 배열

		// 차량별 누적 주차 시간(분) 저장
		Map<String, Integer> total_time = new HashMap<String, Integer>();
		// 차량별 입차된 시간(HH:MM -> 분) 저장
		Map<String, Integer> in_time = new HashMap<String, Integer>();

		// 자동차의 입/출차 내역으로 누적 주차 시간 계산
		String arr[], time[];
		for (int i = 0; i < records.length; i++) {
			arr = records[i].split(" ");
			// 입차 되었을 경우 (IN)
			if (arr[2].equals("IN")) {
				// 시간을 분 단위로 만들고 Map에 저장
				time = arr[0].split(":");
				int in_minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
				in_time.put(arr[1], in_minute);
			}
			// 출차 되었을 경우 (OUT)
			else {
				// 출차 시간-입차 시간으로 주차된 시간 계산
				int in_minute = in_time.get(arr[1]);
				time = arr[0].split(":");
				int out_minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

				// 주차 시간을 누적시키고 Map에서 제거
				int curr = total_time.get(arr[1]) == null ? 0 : total_time.get(arr[1]);
				total_time.put(arr[1], curr + out_minute - in_minute);
				in_time.remove(arr[1]);
			}
		}
		
		// 입차된 후 출차되지 않은 차는 23:59에 출차된 것으로 처리
		for (String car : in_time.keySet()) {
			int in_minute = in_time.get(car);
			int out_minute = 23 * 60 + 59;

			int curr = total_time.get(car) == null ? 0 : total_time.get(car);
			total_time.put(car, curr + out_minute - in_minute);
		}
		
		// 차량 번호 오름차순으로 keySet을 정렬
		Object[] keySet = total_time.keySet().toArray();
		Arrays.sort(keySet);
		
		// 차량별 누적 주차 시간으로 주차 요금 계산
		int[] answer = new int[total_time.size()];
		int fee, minute, idx = 0;
		for (Object car : keySet) {
			// 기본 시간을 제외하고 기본 요금으로 초기화
			minute = total_time.get(car) - fees[0];
			fee = fees[1];
			
			// 초과한 시간이 있으면 요금 계산
			if (minute > 0) {
				// 단위 시간으로 나누어 떨어지지 않으면 올림 처리
				fee += Math.ceil((double) minute / fees[2]) * fees[3];
			}
			// 차량별 주차 요금 저장
			answer[idx++] = fee;
		}

		return answer;
	}

}
