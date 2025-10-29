package bk.unknown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 비트 마스킹
// 2^N 만큼의 부분집합이 존재
// 
public class Main_2961_노소연 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		// 신맛 *, 쓴맛 + 을 각 재료마다 담을 배열 생성
		// 		인덱스 0이 신맛, 1이 쓴맛
		int[][] arr = new int[N][2]; // 2는 넣, 뻇을 표시하는 boolean
		for(int i= 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());// 신맛
			arr[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}
		
		
		// 부분집합의 경우의 수 구하기
		int lth = 1<<N; // 2의 n승
		// 가장 적은 차이를 담을 변수
		int minDiff = Integer.MAX_VALUE;
		// 재료를 무조건 1개이상 넣어야한다고 했으므로 공집합 제외
		// 이제 부분집합 수만큼 돌려보자.
		for(int i = 1; i < lth; i++) {
			// 신맛은 곱이니까 초기값을 1, 쓴맛은 덧셈이니까 초기값을 0으로 잡음
			int sour = 1, bitter = 0;
			// 부분집합에 재료가 뭐들어 재료수만큼 for문돌려 확인해보기
			for(int j = 0; j < N; j++) { // 재료 수만큼 for문 
				if((i & 1<<j) != 0) { // j번째 재료가 들어갔니? 
					sour *= arr[j][0]; // 그럼 신맛 추가
					bitter += arr[j][1]; // 쓴맛도 추가
				}
				
			}
			// 이 부분집합 요리의 신쓴 차이를 확인해보자
			// 	절댓값 사용 잊지말기
			int diff = Math.abs(sour - bitter);
			// 가장 차이 적은 차이값을 저장
			minDiff = Math.min(minDiff, diff);
		}
		System.out.println(minDiff);
		
	}
}
