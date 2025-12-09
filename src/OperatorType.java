// 연산자를 enum 으로 관리
public enum OperatorType {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    // 선언한 상수에 문자열 연결
    private final String changeType;

    OperatorType(String changeType) {
        this.changeType = changeType;
    }

    public String getChangeType() {
        return changeType;
    }

    // 연산기호로 입력시 반복문을 통해 enum 상수랑 매칭
    public static OperatorType changeOk(String changeType) {
        for (OperatorType a : values()) {
            if (a.changeType.equals(changeType)) {
                return a;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자 입니다.");
    }
}