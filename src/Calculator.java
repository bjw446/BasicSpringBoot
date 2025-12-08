import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator<T extends Number> {
    private List<T> list = new ArrayList<>();
    private final T generic;


    public Calculator(T generic) {
        this.generic = generic;
    }

    public T getGeneric() {
        return this.generic;
    }

    public T calculate (T num1, T num2, OperatorType operator) {

        Double doubleNum1 = num1.doubleValue();
        Double doubleNum2 = num2.doubleValue();
        Double result = 0.0;

        switch (operator) {
            case PLUS :
                result = doubleNum1 + doubleNum2;
                break;
            case MINUS :
                result = doubleNum1 - doubleNum2;
                break;
            case MULTIPLY :
                result = doubleNum1 * doubleNum2;
                break;
            case DIVIDE :
                try {
                     result = doubleNum1 / doubleNum2;
                     break;
                } catch (ArithmeticException e) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    break;
                }
                default:
                    System.out.println("잘못된 연산자 입니다.");
        }
        T genericResult = (T) result;
        list.add(genericResult);
        return genericResult;
    }
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void removeResult() {
        try {
            list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("저장된 결과가 없습니다.");
        }
    }
    public void clearList() {
        list.clear();
    }
}