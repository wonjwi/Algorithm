package week18;

import java.io.*;
import java.util.*;

public class BJ14226_이모티콘 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 만들어야 하는 이모티콘 개수
		int S = Integer.parseInt(in.readLine());

		int answer = -1, temp[], cnt, time, copy;
		boolean visited[][] = new boolean[S + 1][S + 1];

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 1, 1, 1 });
		visited[1][1] = true;

		while (!queue.isEmpty()) {
			temp = queue.poll();
			cnt = temp[0]; // 이모티콘 개수
			time = temp[1]; // 걸린 시간
			copy = temp[2]; // 복사한 이모티콘 개수

			// 이모티콘이 S개가 되면 종료
			if (cnt == S) {
				answer = time;
				break;
			}

			// 이모티콘을 모두 복사해서 클립보드에 저장
			if (cnt <= S && !visited[cnt][cnt]) {
				queue.add(new int[] { cnt, time + 1, cnt });
				visited[cnt][cnt] = true; // 방문 체크
			}

			// 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
			if (cnt + copy <= S && !visited[cnt + copy][copy]) {
				queue.add(new int[] { cnt + copy, time + 1, copy });
				visited[cnt + copy][copy] = true; // 방문 체크
			}

			// 화면에 있는 이모티콘 중 하나를 삭제
			if (cnt <= S && cnt > 2 && !visited[cnt - 1][copy]) {
				queue.add(new int[] { cnt - 1, time + 1, copy });
				visited[cnt - 1][copy] = true; // 방문 체크
			}
		}

		System.out.println(answer);
	}

}
