package bk.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N 최대 3000자리..? 
 * 
 * 경우의 수 
 * 앞 < 뒤 (같은 십의자리수에서 일의자리 증가) 
 * 뒤 < 앞 (십의자리수 +1)
 * 만약 지금까지의 최소값의 십의 자리 수와 다음 수가 동일한 경우 -> 그 다음수까지 고려 
 * 앞 < 뒤뒤 
 * 			 xxxxx(뒤뒤로 갱신) -> 이것보다 아래가 더 이득이라 취소  xxxx
 * 		근데 뒤뒤도 십의 자리수와 동일하면 
 * 			 (일의자리수 가장 최소값으로 가정하고 넣기) -> 이거 어떻게함?
 * 				-> 반복되는 경우 일의자리수가 9가되면 넘어가기  
 * 뒤뒤 < 앞 (기존과 동일하게 십의자리수 +1)
 * 
 * 자리수가 더 높아지는 것도 고려.. 
 * 
 * + 십의 자리수가 증가했을 떄의 십의자리수 = 뒤 -> 일의자리가 0인 것도 고려
 * + 십의 자리수와 뒤가 동일한 경우 -> 그 다음수가 십의자리인 것도 고려 
 */
public class Main_1515_수이어쓰기 {
	
	static int min, minLength;
	static int[] mArr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int inputLength = input.length();
		int[] n = new int[input.length()];

		for(int i = 0; i < inputLength; i++) {
			n[i] = input.charAt(i) - '0';
		}
		
		mArr = new int[3001];
		if(n[0] == 0) { //시작이 0인경우 고려 
			min = 10;
			minLength =2;
			mArr[1] = 0;
			mArr[2] = 1;
		} else {
			min = n[0];
			minLength = 1; // 최소값 자리수 
			mArr[1] = n[0];
		}
		
		
		for(int i = 0; i < inputLength - 1; i++) {
			System.out.println(i+1 + " "  + min);
			int now = n[i];
			int next = n[i+1];
			int nextIdx = i+1;
			
			
			// 1의자리까지 동일한 걸 고려할필요 x 
			boolean isSame = false;
			
			// 현재 min과 십의자리까지 일치하는지 
			for(int j = minLength; j > 1; j--) {
				if(mArr[j] == next) {
					System.out.println(mArr[j] + "== " + next);
					next = n[nextIdx++];
					isSame = true;
					i += minLength-2;	
				}else {
					System.out.println(mArr[j] + "!= " + next);
					isSame = false;	
					break;
				}
			}
			
			// 십의자리수까지 같음 
			if(isSame) {
//				System.out.println("십의자리수까지 같음");
				if(mArr[1] + 1 == next) {
					i++;// 10 -> 11같은 경우 
				}
				min = (min/10)*10 + min%10+1;
			// 일반적인 경우 
			}else {
				// 앞 < 뒤
				if(now < next) {
//					System.out.println("앞 < 뒤 ");
					min = (min/10)*10 + n[i+1];
				// 앞 > 뒤 
				} else {
//					System.out.println("앞 > 뒤 ");
					// 십의자리수를 올렸는데 next랑 같아. 그러면 n0으로처리 
					if(min/10 + 1 == next) {
//						System.out.println("근데 n0처리");
						min = (min/10)*10 + 10;
					}else {
						min = (min/10)*10 + 10 + next;	
					}
				}	
			}	
			set();
		}
		
		System.out.println(min);
	}

	private static void set() {		
		minLength = String.valueOf(min).length();
		int cMin = min;
		for(int i = 1; i <= minLength; i++) {
			mArr[i] = cMin % 10;
			cMin /= 10;
		}
	}
}
