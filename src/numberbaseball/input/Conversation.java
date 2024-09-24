package numberbaseball.input;

import numberbaseball.exceptions.DecimalFormatException;
import numberbaseball.exceptions.DoubleInputException;
import numberbaseball.exceptions.NotNumericException;

import java.util.List;
import java.util.Scanner;

public class Conversation {
    /**
     * numberbaseball.input.Conversation.java
     * 사용자 입력을 받고 출력하고, 게임 진행을 하는 클래스
     * 올바르게 입력할 때까지 계속해서 진행하도록 반복문 사용
     * 정답을 맞출시 축하메시지와 함께 종료
     */


    public List<Integer> inputNumber(Scanner sc, int difficulty) {
        List<Integer> userAnswer;

        while (true) {
            System.out.println("서로 다른 " + difficulty + " 자리의 숫자를 입력해주세요.");
            String inputStr = sc.nextLine();
            InputInvalidCheck inputCheck = new InputInvalidCheck();

            try {
                if (!inputStr.isEmpty() && inputCheck.answerCheckInvalid(inputStr, difficulty)) { // 입력값 유효한지 검사
                    userAnswer = inputCheck.changeStrToList(inputStr);
                    break;
                }
            } catch (DecimalFormatException | DoubleInputException | NotNumericException e) {
                System.out.println(e.getMessage());
            }
        }

        return userAnswer;
    }

    public void sendResult(int strike, int ball, int out, int difficulty, int count) {
        StringBuilder scoreString = new StringBuilder();
        if (strike == difficulty) {
            scoreString.append("정답입니다! " + difficulty + "단계 난이도를 " + count + "회 만에 맞추셨습니다.");
        } else if (out == difficulty) {
            scoreString.setLength(0);
            scoreString.append("아웃");
        } else {
            if (strike > 0) {
                scoreString.append(strike).append("스트라이크 ");
            }

            if (ball > 0) {
                scoreString.append(ball).append("볼");
            }

            scoreString.trimToSize();
        }

        System.out.println(scoreString);
        System.out.println();
    }
}
