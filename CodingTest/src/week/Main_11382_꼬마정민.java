package week; // 브5 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제이해
 * - 정민이가 숫자 3개 더한대 
 * 
 * 주의사항
 * - 숫자 범위에 당했다. 10^12
 * - 1,000,000,000,000
 * - 조를 넣겠다고요 
 * 
 * 후기
 * - while문을 너무 안 써서 쓰는 법을 익혀보고자했다.
 * - 3번 반복하고 싶을 때 i--로 돌리자 
 */
public class Main_11382_꼬마정민 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int i = 3;
		Long sum = 0L;
		while(i-- > 0) {
			sum += Long.parseLong(st.nextToken());	
		}
		
		System.out.println(sum);		
				
	}
}
