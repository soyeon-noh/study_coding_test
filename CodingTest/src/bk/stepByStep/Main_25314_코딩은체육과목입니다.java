package bk.stepByStep; // 브론즈5

import java.util.Scanner;

public class Main_25314_코딩은체육과목입니다 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        int cnt = n/4;


        for(int i = 0; i < cnt; i++){
            sb.append("long ");
        }

        sb.append("int");

        System.out.println(sb.toString());
    }

}
