package numberbaseball.exceptions;

public class DoubleInputException extends Exception {
    /**
     * numberbaseball.exceptions.DoublerInputException.java
     * 숫자 입력은 하였으나, 실수를 입력할 경우 발생하는 예외
     */
    public DoubleInputException() {
        super("실수 입력은 유효하지 않습니다.");

    }
}
