package numberbaseball;

import java.util.List;

public class AnswerCheck {
    /**
     * numberbaseball/AnswerCheck.java
     * 전달 받은 입력값을 검사하는 역할.
     * 전달 받은 입력값과 GenerateAnswer에 있는 정답과 비교하여
     * -----------------------------------------
     * Strike : 위치(자릿수)도 맞고, 숫자도 맞춤
     * Ball   : 위치는 틀리고, 숫자는 맞춤
     * Out    : 숫자 틀림
     * -----------------------------------------
     * 각 SBO가 몇개인지 반환해주는 기능을 담당
     */
    List<Integer> answer;
    private int scoreStrike, scoreBall, scoreOut, scoreCount;

    public AnswerCheck (GenerateAnswer answer) {
        this.answer = answer.getAnswer();
        this.scoreStrike = 0;
        this.scoreBall = 0;
        this.scoreOut = 0;
        this.scoreCount = 0;
    }

    public void checkSBO (List<Integer> userAnswer) {
        resetSBO();
        scoreCount++;

        for (int i = 0; i < userAnswer.size(); i++) {
            if (this.answer.contains(userAnswer.get(i))) {
                if (answer.indexOf(userAnswer.get(i)) == i) {
                    scoreStrike++; // Strike
                } else {
                    scoreBall++; // ball
                }
            } else {
                scoreOut++;
            }
        }
    }

    private void resetSBO () {
        scoreStrike = 0;
        scoreBall = 0;
        scoreOut = 0;
    }

    // getter
    public int getScoreStrike() {
        return scoreStrike;
    }
    public int getScoreBall() {
        return scoreBall;
    }
    public int getScoreOut() {
        return scoreOut;
    }
    public int getScoreCount() {
        return scoreCount;
    }
}
