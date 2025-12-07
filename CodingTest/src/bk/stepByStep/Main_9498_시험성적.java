package bk.stepByStep;

import java.util.Scanner;

public class Main_9498_시험성적 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
	
		if(N<60) {
			System.out.println("F");
		}else if(N<70) {
			System.out.println("D");
		}else if(N<80) {
			System.out.println("C");
		}else if(N<90) {
			System.out.println("B");
		}else {
			System.out.println("A");
		}
		
	}
}
