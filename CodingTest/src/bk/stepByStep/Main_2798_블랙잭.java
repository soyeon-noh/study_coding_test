package bk.stepByStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 아이디어 : 브루트포스
// 시간복잡도 : N < 100, M < 300,000 
// 			 하지만 최대 카드 장수가 3이어서 3중 for문을 돌려도 3N이라 괜찮다. 
// 자료형 : 전부 int 사용가능 
// 오답 이유 : total 변수의 위치 문제 
public class Main_2798_블랙잭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 일단 배열 저장 
		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int highScore = 0; // 가장 높은 점수 0초기화 
		
		// 3장을 뽑는 모든 경우의 수를 헤아리기 
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) { // 인덱스를 i+1로 하면 내부에서 중복검사할필요 없어짐 
				for(int k = j + 1 ; k < N; k++) {
					int total = 0; // 변수 위치를 제발 조심하자 
					total = numbers[i] + numbers[j] + numbers[k];
			
					if(total <= M) {
						highScore = Math.max(total, highScore);
					}
				}
			}
		}
		System.out.println(highScore);
		
	}
}
