package bk.stepByStep;

import java.util.Scanner;

// 윤년이면 1 아니면 0
public class Main_2753_윤년 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		if(N<4) {
			System.out.println(0);
		}else if(N%4 == 0) {
			if(N%100 != 0 || N%400 == 0) {
				System.out.println(1);
				return;
			}	
		}
		System.out.println(0);
	}
}
