package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234_노소연 {

	static int N, ans; // 무게추 수, 경우의 수 저장
	static int[] W; // 무게추 무게 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st;
		for(int tc = 1; tc < T; tc++) {
			N = Integer.parseInt(br.readLine()); // 무게추 수 입력
			W = new int[N]; // 무게추 수 에 맞춰 무게 수 배열 생성
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				W[i] = Integer.parseInt(st.nextToken());
			} // 입력끝
			ans = 0;
            getChoo(0,0,0,0);
            System.out.println("#" + tc + " " + ans);
			}
		}
	
	// depth 건드리고 있는 추의 수
	// left, right : 각각 저울에 올려놓은 추의 총합
	static void getChoo(int depth, int check, int left, int right) {
		if (left < right)
			return;
		if (depth == N) {
			// 왼쪽 올린친구와 오른쪽 올린 친구를 나누어서 비교 분석 한뒤에 가능한 경우에만 올림
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			// 사용한 추를 또 사용이 가능한가? -> 불가능 추는 1개씩만 존재한다.
			// 추를 사용했나 or 안했나
			if ((check & (1 << i)) != 0)
				continue;
			getChoo(depth + 1, check | (1 << i), left + W[i], right);
			getChoo(depth + 1, check | (1 << i), left, right + W[i]);
		}

	}
}
