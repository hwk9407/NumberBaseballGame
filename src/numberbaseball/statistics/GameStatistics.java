package numberbaseball.statistics;

import java.util.ArrayList;

public class GameStatistics {
    /**
     * numberbaseball.statistics.GameStatistics.java
     * 게임 시도별 횟수, 난이도의 통계를 기록하고 관리하는 클래스
     */
    private final ArrayList<Integer> tryCount;
    private final ArrayList<Integer> tryDifficulty;


    public GameStatistics() {
        tryCount = new ArrayList<>();
        tryDifficulty = new ArrayList<>();
    }

    public ArrayList<Integer> getTryCount() {
        return tryCount;
    }
    public ArrayList<Integer> getTryDifficulty() {
        return tryDifficulty;
    }
    public void addTry(int count, int difficulty) {
        tryCount.add(count);
        tryDifficulty.add(difficulty);
    }
}
