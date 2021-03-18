package week07;

import java.io.*;
import java.util.*;

public class SW5648_원자소멸 {
	
	static class Atom {
		int x, y, dir, k;
		public Atom(int x, int y, int dir, int k) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.k = k;
		}
	}
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine()); // 원자들의 수
			
			// 원자들의 정보 (x위치, y위치, 이동방향, 보유에너지)
			ArrayList<Atom>  atom = new ArrayList<Atom>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				atom.add(new Atom(x, y, dir, k));
			}
			
			// 원자들을 하나씩 비교
			Set<Integer> crashSet = new HashSet<Integer>();
			for (int i = 0; i < atom.size()-1; i++) {
				Atom a = atom.get(i);
				for (int j = i+1; j < atom.size(); j++) {
					Atom b = atom.get(j);
					// 원자가 충돌하면 에너지를 방출하고 소멸
					int xPosDiff = a.x-b.x; // x좌표 값 차이
					int yPosDiff = a.y-b.y; // y좌표 값 차이
					int xDirDiff = dx[b.dir]-dx[a.dir];
					int yDirDiff = dy[b.dir]-dy[a.dir];
					// 이동방향이 같으면 만날 수 없음
					if ((dx[a.dir] != 0 && xDirDiff == 0) || (dy[a.dir] != 0 && yDirDiff == 0)) continue;
					// 언젠가 만나게 되는 경우
					if (xPosDiff*yDirDiff == yPosDiff*xDirDiff) {
						// 충돌하는 초 저장하기
						crashSet.add(Math.abs(xPosDiff)+Math.abs(yPosDiff));
					}
				}
			}
			// Set을 List로 변환 후 정렬
			List<Integer> crash = new ArrayList<Integer>(crashSet);
			Collections.sort(crash);
			
			// 원자들이 소멸되면서 방출하는 에너지의 총합 구하기
			int sum = 0;
			// 충돌이 일어나는 시간만 검사
			for (int sec : crash) {
				for (int i = 0; i < atom.size()-1; i++) {
					Atom a = atom.get(i);
					int xPos = (a.x*2 + dx[a.dir]*sec);
					int yPos = (a.y*2 + dy[a.dir]*sec);
					boolean flag = false;
					for (int j = i+1; j < atom.size(); j++) {
						Atom b = atom.get(j);
						// 원자가 충돌하면 에너지를 방출하고 소멸
						if (xPos == (b.x*2 + dx[b.dir]*sec) && yPos == (b.y*2 + dy[b.dir]*sec)) {
							flag = true;
							sum += b.k;
							atom.remove(b);
							j--;
						}
					}
					if (flag) {
						sum += a.k;
						atom.remove(a);
						i--;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}

}
