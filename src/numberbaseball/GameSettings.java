package numberbaseball;

import java.util.ArrayList;

public class GameSettings {
    /**
     * numberbaseball/GameSettings.java
     * 진행할 게임 난이도를 저장하고 관리하는 클래스
     */
    private int difficulty;

    public GameSettings () {
        this.difficulty = 3;
    }

    public int getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(int gameDifficulty) {
        this.difficulty = gameDifficulty;
    }
}
