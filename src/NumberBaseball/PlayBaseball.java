package NumberBaseball;

import java.util.ArrayList;
import java.util.List;

public class PlayBaseball {
    /**
     * NumberBaseball/PlayBaseball.java
     * 야구 게임 객체
     * 생성자에 정답생성 객체를 호출
     * 실행 메서드를 통해 게임 진행
     */
    GameStatistics gameStatistics;
    
    public PlayBaseball() {
        this.gameStatistics = new GameStatistics();
    }

    public void execute() {
        Conversation conversation = new Conversation();
        GenerateAnswer correctAnswer = new GenerateAnswer();
        AnswerCheck answerCheck = new AnswerCheck(correctAnswer);
/*
        // 정답 테스트용
        System.out.println("정답은 : " + correctAnswer.getAnswer());
*/


        while (true) {

            // 사용자 입력받기 실행
            List<Integer> userAnswer = conversation.inputNumber();
            answerCheck.checkSBO(userAnswer);

            // 결과 출력
            conversation.sendResult(answerCheck.getScoreStrike(), answerCheck.getScoreBall(), answerCheck.getScoreOut());

            // Strike 3인 경우 break;
            if (answerCheck.getScoreStrike() == 3) {
                this.gameStatistics.addTryCount(answerCheck.getScoreCount());
                break;
            }
        }
    }

    public ArrayList<Integer> loadGameStatistics() {
        return this.gameStatistics.getTryCount();
    }
}
