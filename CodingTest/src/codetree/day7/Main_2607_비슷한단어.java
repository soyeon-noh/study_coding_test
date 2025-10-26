package codetree.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제 이해
 * - 비슷한 단어란
 * - 두 단어를 비교했을 때
 * - 두 단어가 같은 구성을 갖는 경우,
 * -  또는 한 단어에서 한 문자를 더하거나, 빼거나, 하나의 문자를 다른 문자로 바꾸어 나머지 한 단어와 같은 구성을 갖게 되는 경우
 * - 비슷한 단어가 몇개인지 출력하시오
 * 
 * 
 * 
 *
 */
public class Main_2607_비슷한단어 {

	static int N;
	static String[] word;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < N; i++) {
			word[i] = br.readLine();
			char[] arr = word[i].toCharArray();
			int cnt; 
			
			for(int j = 0; j < arr.length; j++) {
				
			}
		}
		
		
		
	}
}
