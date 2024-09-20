package numberbaseball.exceptions;

public class DecimalFormatException extends Exception {
    public DecimalFormatException() {
        super("이상한 형태의 소수점입니다.");
    }
}
