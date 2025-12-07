package bk.stepByStep; // 실버 4

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;

public class Main_4949_균형잡힌세상 {

	/**
	 * 문제이해
	 * - 소활호 (), 대괄호 [] 
	 * - 괄호 짝맞추기
	 * 
	 * 전략
	 * - 스택
	 * 
	 * 주의사항
	 * - 괄호가 아무것도 없는 경우도 고려해야함 
	 * 
	 */
	static ArrayDeque<Character> stack;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			boolean isYes = true; // 문제가 없으면 완벽한 문장
			stack = new ArrayDeque<>();
			
			String input = br.readLine();
			if(input.equals("."))return;
		
			a : for(int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				
				switch (c) {
				case '(':
					stack.push(c);
					break;
				case ')':
					if(stack.isEmpty()) {
						isYes = false;
						break a;
					}else if(stack.peek() != '(') {
						isYes = false;
						break a;
					}
					stack.poll();
					break;	
				case '[':
					stack.push(c);
					break;	
				case ']':
					if(stack.isEmpty()) {
						isYes = false;
						break a;
					}else if(stack.peek() != '[') {
						isYes = false;
						break a;
					}
					stack.poll();
					break;		

				default:
					break;
				}
			}
			
			// 오답노트 : 스택이 비어야 균형이 맞
			if(!stack.isEmpty()) isYes = false;
			
			
			System.out.println(isYes?"yes":"no");	
			
			
			
		}
	}
}
