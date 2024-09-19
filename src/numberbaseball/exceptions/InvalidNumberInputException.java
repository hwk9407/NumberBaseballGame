package numberbaseball.exceptions;

public class InvalidNumberInputException extends Exception {
    /**
     * numberbaseball/exceptions/InvalidNumberInputException.java
     * 숫자 입력을 안할경우 발생하는 예외
     */
    public InvalidNumberInputException() {
        super("숫자만 입력해주세요.");

    }
}
