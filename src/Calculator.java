import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 제네릭 타입을 활용, Number 타입을 상속
public class Calculator<T extends Number> {
    // 계산 결과를 저장하는 리스트
    private List<T> list = new ArrayList<>();
    // 기본 제네릭 값
    private final T generic;

    // 생성자
    public Calculator(T generic) {
        this.generic = generic;
    }

    public T getGeneric() {
        return this.generic;
    }

    // 계산기 수행 메서드 구현
    public T calculate (T num1, T num2, OperatorType operator) {

        // 제네릭을 더블로 반환
        Double doubleNum1 = num1.doubleValue();
        Double doubleNum2 = num2.doubleValue();
        Double result = 0.0;

        // enum을 활용 한 연산자 관리
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
                // 0으로 나누기 예외처리
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
        T genericResult = (T) result;  // 결과 값 제네릭으로 변경
        list.add(genericResult); // 리스트에 결과 저장
        return genericResult;
    }
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    // 첫 번째 결과 삭제
    public void removeResult() {
        try {
            list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("저장된 결과가 없습니다.");
        }
    }
    // 전체 결과 삭제
    public void clearList() {
        list.clear();
    }
}