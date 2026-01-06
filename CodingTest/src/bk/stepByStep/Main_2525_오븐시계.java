package bk.stepByStep;

import java.util.Scanner;

public class Main_2525_오븐시계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		int C = sc.nextInt();
		
		int newM = M+C;
		int newH = H + (M+C)/60;
		
		if(newM < 60) {
			System.out.println(H + " " +newM);
		}else {
			if(newH > 23) {
				System.out.print(newH-24);
			}else {
				System.out.print(newH);				
			}
			System.out.println( " " + (newM%60));
		}
		
	}
}
