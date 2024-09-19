package NumberBaseball;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu {
    /**
     * NumberBaseball/GameMenu.java
     * 안내문구로 메뉴리스트를 띄우고 사용자로부터 숫자 입력을 받아
     * 번호에 해당하는 메뉴 실행하는 클래스
     */

    public void gameStart() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            displayMenu();
            
            int optionNumber;
            try {
                optionNumber = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                sc.next();
                continue;
            }


            // 시작하기
            if (optionNumber == 1) {
                PlayBaseball playGame = new PlayBaseball();
                playGame.execute();
            // 게임 기록 보기 (미구현)
            } else if (optionNumber == 2) {
                System.out.println("아직 구현되지 않았습니다.");
            } else if (optionNumber == 3) {
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println("없는 번호를 입력하였습니다.");
            }
        }
    }
    private void displayMenu() {
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
        System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
    }
}
