package NumberBaseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conversation {
    /**
     * NumberBaseball/Conversation.java
     * 사용자 입력을 받고 출력하고, 게임 진행을 하는 클래스
     * 올바르게 입력할 때까지 계속해서 진행하도록 반복문 사용
     * 정답을 맞출시 축하메시지와 함께 종료
     */


    public List<Integer> inputNumber() {
        Scanner sc = new Scanner(System.in);
        List<Integer> userAnswer = new ArrayList<Integer>();

        System.out.println("서로 다른 세 자리의 숫자를 입력해주세요.");
        while (true) {
            String inputStr = sc.nextLine();
            InputInvalidCheck inputcheck = new InputInvalidCheck();

            if (inputcheck.checkInvalid(inputStr)) { // 입력값 유효한지 검사
                userAnswer = inputcheck.changeStrToList(inputStr);
                break;
            }
        }

        sc.close(); // Scanner 닫기
        return userAnswer;
    }

    public void congratulationMessage() {
        System.out.println("축하합니다! 정답을 맞추셨습니다.");
    }
}
