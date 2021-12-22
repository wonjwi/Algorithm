package algorithm;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 사이트 주소와 비밀번호 입력
		HashMap<String, String> map = new HashMap<>();
		String address, password;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());

			address = st.nextToken();
			password = st.nextToken();

			map.put(address, password);
		}

		// 사이트에 해당하는 비밀번호 출력
		for (int i = 0; i < M; i++) {
			address = in.readLine();
			password = map.get(address);

			sb.append(password).append("\n");
		}

		System.out.println(sb.toString());
	}

}