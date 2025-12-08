import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator<Double> calculator = new Calculator<>(0.1);

        System.out.println("계산기 실행!!");

        while (true) {

            Double num1 = calculator.getGeneric();
            Double num2 = calculator.getGeneric();
            String operator;

            try {
                System.out.println("첫 번째 숫자를 입력하세요 : ");
                num1 = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다.");
                sc.nextLine();
                continue;
            }

                System.out.println("사칙연산 기호를 입력하세요 : ");
                operator = sc.next();

            try {
                System.out.println("두 번째 숫자를 입력하세요 : ");
                num2 = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다.");
                sc.nextLine();
                continue;
            }

            Double genericResult = calculator.calculate((Double) num1, (Double) num2, OperatorType.changeOk(operator));
            System.out.println("\n계산 결과 : " + genericResult);

            boolean menu = true;
            while (menu) {
                System.out.println("\n====================");
                System.out.println("원하는 메뉴를 입력해주세요");
                System.out.println("1. 다시 계산 하기");
                System.out.println("2. 계산 결과 목록 보기");
                System.out.println("3. 첫 번째 계산 결과 지우기");
                System.out.println("4. 전체 계산 결과 목록 지우기");
                System.out.println("5. 계산한 결과 보다 큰 결과 목록 출력");
                System.out.println("6. 계산기 종료 하기");
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
                        calculator.removeResult();
                        System.out.println("남아있는 결과 : \n" + calculator.getList());
                        break;
                    case 4 :
                        calculator.clearList();
                        System.out.println("전체 계산 결과를 삭제하였습니다. \n" + calculator.getList());
                        break;
                    case 5 :
                        List<Double> compareSize =
                        calculator.getList().stream()
                        .filter(a -> a > genericResult)
                        .collect(Collectors.toList());
                        System.out.println("더 큰 결과 목록 : \n" + compareSize);
                        break;
                    case 6 :
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
