package week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제 이해
 * - A이상 B 이하의 정수를 모두 더한 값
 * - A = 4, B = 21인 경우 이환이는 456789101112131415161718192021 로 적음
 * 
 * - A <= B <= 999 정수 
 * 
 * - 이환이가 적어온 숫자들의 나열이 주어지면 선생이 부른 두 수를 찾기
 * 
 * 입력 
 * - 이환이가 적은 답 문자열 S (S는 숫자. 길이는 1<=S<=2889)
 * 
 * 출력
 * - A, B를 공백으로 구분하여 출력
 * - 답이 두가지 이상이면 그중 A가 가장 작은 것 출력
 * 
 * 생각
 * - 답이 두가지 이상인 경우가 뭘까. 910 -> 9 10과 910 910
 * - 
 */
public class _Main_2235_수학은체육과목입니다3 {

	static String S;
	static int A, B;
	static char[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine(); //입력끝
		
		arr = S.toCharArray();
		
		// 앞 한 수에 +1을 해.
		// 그리고 뒤수랑 일치하는지 봐.
		// 아니야? 그러면 앞에 두수에 +1을해 
		// 그리고 뒤 두수랑 일치하는지를 봐
		// 이걸 4자리까지 하는거임
		
		int len = arr.length;
		

		if(len == 1 || arr[0] + 1 == arr[1]) {
			A = arr[0] - '0';
		}else if(len <= 3 || arr[1] + 1 == arr[3]) {
			if(len == 2) {
				A = (arr[0] - '0') * 10 + (arr[1] - '0');	
			}else if(len == 3){
				A = (arr[0] - '0') * 100 + (arr[1] - '0') * 10 + (arr[2] - '0');
			}
		}else if(len <= 4 || arr[2] + 1 == arr[5]) {
			A = (arr[0] - '0') * 100 + (arr[1] - '0') * 10 + (arr[2] - '0');
			if(len == 4) {
				A = (arr[0] - '0') * 1000 + (arr[1] - '0') * 100 + (arr[2] - '0') * 10 + (arr[3] - '0');
			}
		}else if(arr[3] + 1 == arr[7]) {
			A = (arr[0] - '0') * 1000 + (arr[1] - '0') * 100 + (arr[2] - '0') * 10 + (arr[3] - '0');
		}
		
		System.out.println(A);
	}
}
