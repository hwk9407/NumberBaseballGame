package NumberBaseball;

import java.util.List;

public class PlayBaseball {
    /**
     * NumberBaseball/PlayBaseball.java
     * 야구 게임 객체
     * 생성자에 정답생성 객체를 호출
     * 실행 메서드를 통해 게임 진행
     */

    private GenerateAnswer correctAnswer;

    public PlayBaseball() {
        System.out.println("< 숫자 야구 게임 > 을 시작하겠습니다.");
    }

    public void execute() {
        Conversation conversation = new Conversation();

        this.correctAnswer = new GenerateAnswer();

        System.out.println("-----테스트 전용 정답공개 나중에 지워야함~!-----");
        System.out.println("정답은 : " + correctAnswer.getAnswer());
        System.out.println("-----테스트 전용 정답공개 나중에 지워야함~!-----");


        while (true) {
            AnswerCheck answerCheck = new AnswerCheck(this.correctAnswer);

            // 사용자 입력받기 실행
            List<Integer> userAnswer = conversation.inputNumber();
            answerCheck.checkSBO(userAnswer);

            // 결과 출력
            conversation.sendResult(answerCheck.getScoreStrike(), answerCheck.getScoreBall(), answerCheck.getScoreOut());

            // Strike 3인 경우 break;
            if (answerCheck.getScoreStrike() == 3) break;
        }



    }
}
