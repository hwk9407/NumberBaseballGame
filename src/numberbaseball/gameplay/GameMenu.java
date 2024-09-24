package numberbaseball.gameplay;

import numberbaseball.exceptions.DecimalFormatException;
import numberbaseball.exceptions.DoubleInputException;
import numberbaseball.exceptions.NotNumericException;
import numberbaseball.exceptions.UnsupportedDifficultyException;
import numberbaseball.input.InputInvalidCheck;
import numberbaseball.statistics.GameStatistics;

import java.util.ArrayList;
import java.util.Scanner;

public class GameMenu {
    /**
     * numberbaseball.gameplay.GameMenu.java
     * 안내문구로 메뉴리스트를 띄우고 사용자로부터 숫자 입력을 받아
     * 번호에 해당하는 메뉴 실행하는 클래스
     */
    private PlayBaseball playGame;
    Scanner sc;

    // 입력 타입에 따른 enum
    enum InputMenuType {
        MAIN("잘못된 메뉴번호 입니다.", 0, 3),
        DIFFICULTY("지원 하지 않는 난이도 입니다. 난이도는 3 ~ 5단계만 설정이 가능합니다.", 3, 5);

        String errorMessage;
        int min, max;
        InputMenuType(String errorMessage, int min, int max) {
            this.errorMessage = errorMessage;
            this.min = min;
            this.max = max;
        }

    }

    // 생성자
    public GameMenu() {
        this.playGame = new PlayBaseball();
        this.sc = new Scanner(System.in);
    }


    private int inputNumber(InputMenuType type) {

        while(true) {
            displayMenu(type);
            String inputStr = sc.nextLine();
            InputInvalidCheck inputCheck = new InputInvalidCheck();

            try {
                inputCheck.isIntegerNumeric(inputStr, false);
            } catch (DecimalFormatException | DoubleInputException | NotNumericException e) {
                System.out.println(e.getMessage());
                continue;
            }
            int inputNum = Integer.parseInt(inputStr);
            if (type == InputMenuType.MAIN && (InputMenuType.MAIN.min > inputNum || InputMenuType.MAIN.max < inputNum)) {
                System.out.println(InputMenuType.MAIN.errorMessage);
                continue;
            } else if (type == InputMenuType.DIFFICULTY && (InputMenuType.DIFFICULTY.min > inputNum || InputMenuType.DIFFICULTY.max < inputNum)) {
                System.out.println(InputMenuType.DIFFICULTY.errorMessage);
                // 지원하지 않는 난이도 설정 시 예외 처리
                try {
                    throw new UnsupportedDifficultyException(InputMenuType.DIFFICULTY.min, InputMenuType.DIFFICULTY.max);
                } catch (UnsupportedDifficultyException e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }
            return Integer.parseInt(inputStr);
        }
    }

    public void gameStart() {
        while (true) {

            int optionNumber;

            optionNumber = inputNumber(InputMenuType.MAIN);

            // 자리수 설정하기
            if (optionNumber == 0) {
                int gameDifficulty = inputNumber(InputMenuType.DIFFICULTY);
                playGame.setGameDifficulty(gameDifficulty);
                System.out.println("게임 난이도를 " + gameDifficulty + "로 설정 하였습니다. \n");
                // 시작하기
                optionNumber = 1;
            }

            if (optionNumber == 1) {
                System.out.println("< 숫자 야구 게임 > 을 시작하겠습니다.");
                playGame.execute(sc);
                // 게임 기록 보기
            } else if (optionNumber == 2) {
                System.out.println("\n< 게임 기록 보기 >");

                GameStatistics statistics = playGame.loadGameStatistics();
                ArrayList<Integer> tryCount = statistics.getTryCount();
                ArrayList<Integer> tryDifficulty = statistics.getTryDifficulty();

                if (tryCount.isEmpty()) {
                    System.out.println("기록 없음\n");
                    continue;
                }

                for (int i = 0; i < tryCount.size(); i++) {
                    System.out.println((i + 1) + "번째 게임 (난이도 " + tryDifficulty.get(i) + ") : 시도 횟수 - " + tryCount.get(i));
                }
                System.out.println();

            } else if (optionNumber == 3) {
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println("없는 번호를 입력하였습니다.");
            }
        }

        // System.in 입력 스트림 닫기
        sc.close();
    }

    private void displayMenu(InputMenuType type) {
        if (type == InputMenuType.MAIN) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
        } else if (type == InputMenuType.DIFFICULTY) {
            System.out.println("설정하고자 하는 자리수를 입력하세요.");
        }
    }

}
