package week; // 실버 4

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


/**
 * 문제 이해
 * - 정수 저장 스택 구현
 * 
 * 규칙
 * 1. 정수 x를 스택에 넣음
 * 2. 스택에 정수가 있다면 맨위 정수 뺴고 출력
 * 		없다면 -1 출력
 * 3. 스택에 들어있는 정수의 개수를 출력
 * 4. 스택이 비어있으면 1, 아니면 0 출력
 * 5. 스택에 정수가 있다면 맨위 정수 출력
 * 		없다면 -1 출력
 * 
 * 입력
 * - 첫째줄 명령의수 N
 * - 둘째 줄부터 N개의 명령 하나씩 
 * 
 * 전략
 * - stack 을 ArrayDeque로 구현
 * - push, pop
 */
public class Main_28278_스택2 {

	static int N;
	static ArrayDeque<Integer> stack = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			
			switch (order) {
				case 1:
					stack.push(Integer.parseInt(st.nextToken()));
//					break;
					continue;
				case 2:
					if(stack.isEmpty()) {
						sb.append("-1");
						break;
					}
					sb.append(stack.pop());
					break;
				case 3:
					sb.append(stack.size());
					break;
				case 4:
					String result = stack.isEmpty()?"1":"0";
					sb.append(result);
					break;
				case 5:
					if(stack.isEmpty()) {
						sb.append("-1");
						break;
					}
					sb.append(stack.peek());
				default:
					break;
			}
			
			sb.append("\n");
			
		}
		
		
		System.out.println(sb.toString());
		
		
	}
}
