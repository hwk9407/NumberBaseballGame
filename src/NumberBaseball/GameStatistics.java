package NumberBaseball;

import java.util.ArrayList;

public class GameStatistics {
    /**
     * NumberBaseball/GameStatistics.java
     * 게임 시도 횟수 기록을 관리하는 클래스
     */
    private ArrayList<Integer> tryCount;

    GameStatistics() {
        tryCount = new ArrayList<>();
    }

    public ArrayList<Integer> getTryCount() {
        return tryCount;
    }
    public void addTryCount(int count) {
        tryCount.add(count);
    }
}
