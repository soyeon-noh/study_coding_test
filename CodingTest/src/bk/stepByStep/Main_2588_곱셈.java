package bk.stepByStep; //브 3

import java.util.Scanner;

/**
 * 문제이해
 * - 세자리 두 수 곱하는 거
 * - 곱하는 수의 1의자리 10의자리 100의 자리 하나씩 출력
 * - 마지막에 두 수 곱 출력 
 * 
 * 후기
 * - 왜 이렇게 숫자가 나오면 버벅대는 걸까
 * - 간단한 건데 오래걸리는 건 제가 곱셈 나눗셈을 못한다는 뜻이겠지요 
 */
public class Main_2588_곱셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int cal = num2%10;
		System.out.println(num1*cal);
		cal = num2%100/10;
		System.out.println(num1*cal);
		cal = num2/100;
		System.out.println(num1*cal);
		System.out.println(num1*num2);
	}
}
