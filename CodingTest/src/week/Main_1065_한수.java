package week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 이해
 * - 양의 정수 X
 * - 각 자리가 등차수열을 이룬다면 -> 한수
 * - 1~N 사이의 값중에 한수의 갯를 출력하시오
 * 
 * 전략
 * - 일단 전부해봅시다
 * - 총 4자리의 배열을 만들어서 한자리씩 등차수열인지 확인
 * - 배열에 왼쪽 공백은 배제 (0)
 * 
 * 입력
 * - N (1000 이하 자연수)
 * 
 * 출력
 * - 한수의 개수 
 *
 */
public class Main_1065_한수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 한자리인 경우 N개만 나옴
		if(N/10 == N) {
			System.out.println(N);
			return;
		}
		
		// 1~N까지의 숫자를 각 자리수별로 나눠 char배열에 담아 비교
		char[] num = new char[4];
		for(int n = 1; n <= N; n++) { // 범위 확인 
			num = String.valueOf(n).toCharArray();
			
			boolean isStart = false; // 0040 같은 경우에서 00을 거르기 위함
			int gap = 0;
			for(int i = 0; i < 3; i++) { // 2개씩 짝지어서 판단하므로 0,1,2만 반복  
				if(num[i] != 0) isStart = true;
				if(isStart) {
					gap = num[i] - num[i+1];
				}
				
			}
		}
	}
}
