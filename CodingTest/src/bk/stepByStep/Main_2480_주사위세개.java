package bk.stepByStep;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2480_주사위세개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int ansNum = arr[0];
		int cnt = 1;
		
		for(int i = 0; i < arr.length-1; i++) {
			if(ansNum != arr[i+1] ) {
				if(cnt != 2) ansNum = arr[i+1];
			}else {
				++cnt;
			}
		}
		
		int ans = 0;
		if(cnt == 1) {
			ans = ansNum * 100;
		}else if(cnt == 2) {
			ans = 1000 + ansNum * 100;
		}else {
			ans = 10000 + ansNum * 1000;
		}
		
		System.out.println(ans);
		
	}
}
