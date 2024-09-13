package NumberBaseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conversation {
    /**
     * NumberBaseball/Conversation.java
     * 사용자 입력을 받고 출력하고, 게임 진행을 하는 클래스
     * 정답을 입력할 때까지 계속해서 진행하도록 반복문 사용
     * 정답을 맞출시 축하메시지와 함께 종료
     */


    public void startInputNumber() {
        Scanner sc = new Scanner(System.in);

        System.out.println("서로 다른 세 자리의 숫자를 입력해주세요.");
        while (true) {
            String inputStr = sc.nextLine();
            AnswerCheck answerCheck = new AnswerCheck();

            if (answerCheck.scoreCalculate(inputStr)) break;
        }
        sc.close(); // Scanner 닫기
    }

    public void congratulationMessage() {
        System.out.println("축하합니다! 정답을 맞추셨습니다.");
    }
}
