package numberbaseball;

import java.util.ArrayList;

public class GameSettings {
    /**
     * numberbaseball/GameSettings.java
     * 게임 난이도와, 정답 시도 횟수 필드를 저장하고 관리하는 클래스
     */
    private GameStatistics gameStatistics;
    private int gameDifficulty;

    public GameSettings () {
        this.gameDifficulty = 3;
        this.gameStatistics = new GameStatistics();
    }

    public int getGameDifficulty() {
        return gameDifficulty;
    }
    public void setGameDifficulty(int gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }
    public void addTryCount(int count) {
        gameStatistics.addTryCount(count);
    }
    public ArrayList<Integer> getTryCount() {
        return gameStatistics.getTryCount();
    }
}
