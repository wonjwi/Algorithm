package week14;

import java.io.*;
import java.util.*;

public class BJ1043_거짓말 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 진실을 아는 사람의 수와 번호
		st = new StringTokenizer(in.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		boolean truth[] = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < T; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			truth[tmp] = true;
			queue.add(tmp);
		}
		// 같은 파티에 참석한 사람들
		Set<Integer> adj[] = new HashSet[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new HashSet<Integer>();
		}
		// 파티에 오는 사람의 수와 번호
		int party[][] = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int len = Integer.parseInt(st.nextToken());
			for (int j = 0; j < len; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				party[i][j] = tmp;
				// 같은 파티에 참석한 사람들 목록에 추가
				for (int k = 0; k < j; k++) {
					adj[tmp].add(party[i][k]);
					adj[party[i][k]].add(tmp);
				}
			}
		}
		// 진실을 아는(들은) 사람 갱신
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int i : adj[tmp]) {
				// 진실을 몰랐던 사람이라면
				if (!truth[i]) {
					truth[i] = true;
					queue.add(i);
				}
			}
		}
		// 지민이가 거짓말을 할 수 있는 파티 개수
		int answer = M;
		for (int i = 0; i < M; i++) {
			for (int j = 0, len = party[i].length; j < len; j++) {
				// 진실을 알거나 들은 사람이 파티에 참석한다면
				if (truth[party[i][j]]) {
					answer--; break;
				}
			}
		}
		System.out.println(answer);
	}

}
