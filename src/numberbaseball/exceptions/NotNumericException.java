package numberbaseball.exceptions;

public class NotNumericException extends Exception {
    /**
     * numberbaseball.exceptions.notNumericException.java
     * 숫자 이외의 문자가 입력될 경우 발생하는 예외
     */
    public NotNumericException() {
        super("숫자가 아닙니다.");
    }
}
