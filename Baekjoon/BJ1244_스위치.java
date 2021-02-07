package homework;

import java.io.*;
import java.util.*;

/**
 * 1244. 스위치 켜고 끄기
 * 
 * 스위치 상태: '1'은 켜져 있음, '0'은 꺼져 있음
 * 남학생: 받은 수의 배수에 해당하는 번호의 스위치 상태를 바꾼다.
 * 여학생: 받은 수를 중심으로 좌우가 대칭인 최대 구간의 모든 스위치 상태를 바꾼다.
 */
public class BJ1244_스위치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int numOfSwitch = Integer.parseInt(in.readLine()); // 스위치 개수
		char state[] = new char[numOfSwitch + 1]; // 스위치의 상태
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= numOfSwitch; i++) {
			state[i] = st.nextToken().charAt(0);
		}
		int numOfStudent = Integer.parseInt(in.readLine()); // 학생수
		for (int i = 0; i < numOfStudent; i++) {
			String arr[] = in.readLine().split(" ");
			int gender = Integer.parseInt(arr[0]);
			int switchNum = Integer.parseInt(arr[1]);
			if (gender == 1) { // 남학생
				for (int j = switchNum; j <= numOfSwitch; j += switchNum) {
					state[j] = state[j] == '1' ? '0' : '1';
				}
			} else if (gender == 2) { // 여학생
				int start = switchNum - 1;
				int end = switchNum + 1;
				while (start > 0 && end <= numOfSwitch) {
					if (state[start] == state[end]) {
						state[start] = state[start] == '1' ? '0' : '1';
						state[end] = state[end] == '1' ? '0' : '1';
						start--;
						end++;
					} else {
						break;
					}
				}
				state[switchNum] = state[switchNum] == '1' ? '0' : '1';
			}
		}
		int i = 1;
		while (i <= numOfSwitch) {
			sb.append(state[i]).append(" ");
			if (i++ % 20 == 0) // 20개마다 줄바꿈
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}