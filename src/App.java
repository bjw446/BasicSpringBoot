import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();


        System.out.println("계산기 실행!!");


        while (true) {

            int num1;
            int num2;
            char operator;

            try {
                System.out.println("첫 번째 숫자를 입력하세요 : ");
                num1 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다.");
                sc.nextLine();
                continue;
            }
            System.out.println("사칙연산 기호를 입력하세요 : ");
            operator = sc.next().charAt(0);
            sc.nextLine();

            try {
                System.out.println("두 번째 숫자를 입력하세요 : ");
                num2 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다.");
                sc.nextLine();
                continue;
            }

            calculator.calculate(num1, num2, operator);
            boolean menu = true;
            while (menu) {
                System.out.println("\n====================");
                System.out.println("원하는 메뉴를 입력해주세요");
                System.out.println("1. 다시 계산 하기");
                System.out.println("2. 계산 결과 보기");
                System.out.println("3. 계산기 종료 하기");
                System.out.println("====================");

                int choice;
                try {
                    choice = sc.nextInt();
                }catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                    sc.nextLine();
                    continue;
                }
                switch (choice) {
                    case 1 :
                        menu = false;
                        break;
                    case 2 :
                        System.out.println("지금까지 계산한 결과 : \n" + calculator.getList());
                        break;
                    case 3 :
                        System.out.println("계산기를 종료합니다.");
                        sc.close();
                        return;
                    default :
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                }

            }

        }
    }
}
