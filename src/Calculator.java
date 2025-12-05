import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> list = new ArrayList<>();


    public int calculate(int num1, int num2, char operator) {

        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                     result = num1 / num2;
                     break;
                } catch (ArithmeticException e) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    break;
                }
                default:
                    System.out.println("잘 못 입력하셨습니다.");
        }
        System.out.println("결과는 : " + result + " 입니다.");
        list.add(result);
        return result;

    }
}