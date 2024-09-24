package numberbaseball.exceptions;
public class UnsupportedDifficultyException extends Exception {
    /**
     * numberbaseball.exceptions.UnsupportedDifficultyException.java
     * 지원하지 않는 난이도를 입력할 시 발생하는 에러
     * 지원하는 난이도는 numberbaseball.gameplay.GameMenu.java의 enum타입 InputMenuType 에서 범위를 정하고 있다.
     */
    public UnsupportedDifficultyException(int minDifficulty, int maxDifficulty) {
        super("지원하지 않는 난이도입니다. (" + minDifficulty + " ~ " + maxDifficulty + " 난이도만 가능)");
    }
}
