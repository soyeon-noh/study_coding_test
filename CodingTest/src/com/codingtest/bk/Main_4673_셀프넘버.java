package com.codingtest.bk;

/**
 * 문제 이해
 * - d(n) = n + n의 각자리수 
 * 		- 33 + 3 + 3 = 39
 * 		- 39 + 3 + 9 = 51
 * 		- 51 + 5 + 1 = 57
 * - n은 d(n)의 생성자 (복수로 가질 수 있음) 
 * - 생성자가 없는 숫자 = 셀프 넘버
 * - ex) 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
 * 
 * 요구 사항
 * - 10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력
 * - 오름차순 
 *
 * 메모
 * - ? 규칙성 모르겠고 뭘써야하는지도 모르겠다. 일단 고. 
 * 
 * 후기
 * - 백의 자리 수를 구하려면 (i%1000)/100 잊지말자.... 
 */
public class Main_4673_셀프넘버 {

	public static void main(String[] args) {
		int N = 10000;
		boolean[] isNotSelf = new boolean[N+1]; // 실버니까 ㄱㅊ지않을까? 
		
		for(int i = 1; i < N; i++) { // 오답노트 : 1부터 시작하자
			// 만은 셀프넘버 아니래
			if(i/10000 == 0) { // 천의 자리
				if(i + (i/1000) + ((i%1000)/100) +((i%100)/10) + (i%10) <= 10000) {
					isNotSelf[i + (i/1000) + ((i%1000)/100) +((i%100)/10) + (i%10)] = true;
				}
				
			} else if(i/1000 == 0) {// 백의 자리수 
				isNotSelf[i + ((i%1000)/100) +((i%100)/10) + (i%10)] = true;
			} else if(i/100 == 0) { // 십의 자리수 
				isNotSelf[i + ((i%100)/10) + (i%10)] = true;
			} else { // 일의 자리수 
				isNotSelf[i + i] = true; 
			}
		}
		
		for(int i = 1; i < N; i++) {
			if(!isNotSelf[i]) System.out.println(i);
			
		}
		
		
		
	}
}
