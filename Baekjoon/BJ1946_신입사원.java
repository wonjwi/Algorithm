package week22;

import java.io.*;
import java.util.*;

public class BJ1946_신입사원 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		int N, document, interview, rank[], answer;
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(in.readLine());
			rank = new int[N+1];
			
			// 각 지원자의 서류심사/면접 성적 순위 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				document = Integer.parseInt(st.nextToken());
				interview = Integer.parseInt(st.nextToken());
				rank[document] = interview;
			}
			
			// 선발할 수 있는 신입사원 찾기
			interview = rank[1];
			answer = 1;
			for (int i = 2; i <= N; i++) {
				// 서류 성적이 낮으므로 면접 성적이 높아야 함
				if (interview > rank[i]) {
					answer++;
					// 면접 성적 기준을 교체
					interview = rank[i];
				} 
			}
			
			// 선발할 수 있는 신입사원의 최대 인원수
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
