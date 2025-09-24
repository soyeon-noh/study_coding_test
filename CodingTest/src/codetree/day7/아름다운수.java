package codetree.day7;

import java.util.Scanner;
// N : 자리수
// 아름다운 수 : 1이 1번, 2가 2번, 3이 3번, 4가 4번 연속해서 나오는 수로만 이루어진 수 

public class 아름다운수 {
	
	static int n;
	static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.
        
        permutation(0, new int[n]);
        System.out.println(cnt);
    }
    
	private static void permutation(int depth, int[] result) {
//		if(depth > n) {
//			return;
//		}
		if(depth == n) {
			++cnt;
			return;
		}
		
		for(int i = 1; i <= 4; i++) {
			if(depth+i > n) {
				return;
			}
			
			if(i == 1) {
				result[depth] = 1;
				permutation(depth+1, result);
			}else if(i == 2) {
				result[depth] = 2;
				result[depth+1] = 2;
				permutation(depth+2, result);
			}else if(i == 3) {
				result[depth] = 3;
				result[depth+1] = 3;
				result[depth+2] = 3;
				permutation(depth+3, result);
			}else {
				result[depth] = 4;
				result[depth+1] = 4;
				result[depth+2] = 4;
				result[depth+3] = 4;
				permutation(depth+4, result);
			}
			
			
		}
		
	}
}

