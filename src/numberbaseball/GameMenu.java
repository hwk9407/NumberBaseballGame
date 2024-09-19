package numberbaseball;

import numberbaseball.exceptions.InvalidNumberInputException;
import numberbaseball.exceptions.UnsupportedDifficultyException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu {
    /**
     * numberbaseball/GameMenu.java
     * 안내문구로 메뉴리스트를 띄우고 사용자로부터 숫자 입력을 받아
     * 번호에 해당하는 메뉴 실행하는 클래스
     */
    PlayBaseball playGame;

    // 생성자
    public GameMenu() {
        this.playGame = new PlayBaseball();
    }
    private int inputNumber() throws InvalidNumberInputException {
        Scanner sc = new Scanner(System.in);

        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
            throw new InvalidNumberInputException();
        }

    }

    public void gameStart() {
        while (true) {
            displayMenu();
            
            int optionNumber;

            try {
                optionNumber = inputNumber();
            } catch (InvalidNumberInputException e) {
                System.out.println(e.getMessage());
                continue;
            }


            // 자리수 설정하기
            if (optionNumber == 0) {
                while (true) {
                    System.out.println("설정하고자 하는 자리수를 입력하세요.");
                    try {
                        int gameDifficulty = inputNumber();
                        playGame.setGameDifficulty(gameDifficulty);
                        System.out.println("게임 난이도를 " + gameDifficulty + "로 설정 하였습니다. \n");
                        break;
                    } catch (InvalidNumberInputException | UnsupportedDifficultyException e) { // 숫자 외 입력할 때 | 3 ~ 5 범위 외 난이도 설정하려 할 때 예외 처리
                        System.out.println(e.getMessage());
                    }
                }
            // 시작하기
            } else if (optionNumber == 1) {
                System.out.println("< 숫자 야구 게임 > 을 시작하겠습니다.");
                this.playGame.execute();
            // 게임 기록 보기
            } else if (optionNumber == 2) {
                System.out.println("\n< 게임 기록 보기 >");

                ArrayList<Integer> tryCount = this.playGame.loadGameStatistics();

                if (tryCount.size() == 0) {
                    System.out.println("기록 없음\n");
                    continue;
                }

                for (int i = 0; i < tryCount.size(); i++) {
                    System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + tryCount.get(i));
                }
                System.out.println();

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
        System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
    }
}
