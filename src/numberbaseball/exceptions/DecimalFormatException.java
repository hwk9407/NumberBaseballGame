package numberbaseball.exceptions;

public class DecimalFormatException extends Exception {
    /**
     * numberbaseball.exceptions.DoublerInputException.java
     * 숫자 입력은 하였으나, 소수점을 두개이상 혹은 ".12" "123."과 같은
     * 이상한 형태의 실수를 입력시 발생하는 예외
     */
    public DecimalFormatException() {
        super("이상한 형태의 소수점입니다.");
    }
}
