package bk.stepByStep; // 실버 4

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


/**
 * 입력
 * - 첫번째 줄에 정수 K
 * - K번 반복해서 정수 1개씩 주어짐 -> 스택에 넣기
 * 	- 정수가 0일 경우 가장 최근에 쓴 수를 지우고
 * 	- 아닐 경우 해당 수를 쓴다
 * 
 * 출력
 * - 최종적으로 스택에 담긴 수의 합
 * - int
 * 
 */
public class Main_10773_제로 {

	static int K;
	static ArrayDeque<Integer> stack = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < K; k++) {
			
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				stack.pop();
				continue;
			}
			stack.push(num);
		}
		
		
		int sum = 0;
		int stackSize = stack.size();
		for(int i = 0; i < stackSize; i++) { // 오답노트 : 제발 변하는 수를 for문조건에 넣지마 
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}
