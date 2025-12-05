package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    private static Object charAt;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;
        String operator;


        System.out.println("첫번째 숫자를 입력하세요 : ");
        num1 = sc.nextInt();
        System.out.println("사칙연산 기호를 입력하세요 : ");
        operator = sc.next();
        System.out.println("두번째 숫자를 입력하세요 : ");
        num2 = sc.nextInt();

        char saveoperator = operator.charAt(0);

    }
}

