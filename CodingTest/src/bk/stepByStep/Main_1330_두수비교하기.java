package bk.stepByStep;

import java.util.Scanner;

public class Main_1330_두수비교하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(A==B?"==":(A>B?'>':'<'));
		
	}
}
