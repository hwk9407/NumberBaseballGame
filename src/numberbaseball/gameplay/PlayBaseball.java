package numberbaseball.gameplay;


import numberbaseball.input.Conversation;
import numberbaseball.settings.GameSettings;
import numberbaseball.settings.GenerateAnswer;
import numberbaseball.statistics.GameStatistics;

import java.util.List;
import java.util.Scanner;

public class PlayBaseball {
    /**
     * numberbaseball.gameplay.PlayBaseball.java
     * 야구 게임 객체
     * 생성자에 정답생성 객체를 호출
     * 실행 메서드를 통해 게임 진행
     */
    private final GameSettings settings;
    private GameStatistics statistics;

    public PlayBaseball() {
        this.settings = new GameSettings();
        this.statistics = new GameStatistics();
    }

    public void execute(Scanner sc) {
        Conversation conversation = new Conversation();
        GenerateAnswer correctAnswer = new GenerateAnswer(settings.getDifficulty());
        AnswerCheck answerCheck = new AnswerCheck(correctAnswer);
/*
        // 정답 테스트용
        System.out.println("정답은 : " + correctAnswer.getAnswer());
*/


        while (true) {

            // 사용자 입력받기 실행
            List<Integer> userAnswer = conversation.inputNumber(sc, settings.getDifficulty());
            answerCheck.checkSBO(userAnswer);

            // 결과 출력
            conversation.sendResult(answerCheck.getScoreStrike(), answerCheck.getScoreBall(), answerCheck.getScoreOut(), settings.getDifficulty());

            // Strike n인 경우 정답이므로 탈출
            if (answerCheck.getScoreStrike() == settings.getDifficulty()) {
                // 정답일 경우에 게임 통계 GameStatistics 객체에 현재 게임의 난이도와 기록을 추가
                statistics.addTry(answerCheck.getScoreCount(), settings.getDifficulty());
                break;
            }
        }
    }

    public GameStatistics loadGameStatistics() {
        return statistics;
    }

    public void setGameDifficulty(int difficulty) {
        settings.setDifficulty(difficulty);
    }
    public int getGameDifficulty() {
        return settings.getDifficulty();
    }
}
