package numberbaseball.exceptions;

public class UnsupportedDifficultyException extends Exception {
    /**
     * numberbaseball/exceptions/UnsupportedDifficulty.java
     * 3 ~ 5 범위를 벗어난 난이도를 설정하려는 경우 발생하는 예외
     */
    public UnsupportedDifficultyException() {
        super("지원 하지 않는 난이도 입니다. 난이도는 3 ~ 5단계만 설정이 가능합니다.");
    }

}
