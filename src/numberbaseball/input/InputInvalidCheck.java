package numberbaseball.input;

import numberbaseball.exceptions.DecimalFormatException;
import numberbaseball.exceptions.DoubleInputException;

import java.util.ArrayList;
import java.util.List;

public class InputInvalidCheck {
    /**
     * numberbaseball.input.InputInvalidCheck.java
     * 전달 받은 입력값이 조건에 맞게 잘 입력했는지 검사하는 역할.
     * 조건1. 순수 숫자만 있어야 함. (ex. 1a2, abc)
     * 조건2. n 개의 숫자여야 함. (ex. n = 4 : 1234, n = 5 : 12345)
     * 조건3. 0을 포함하고 있으면 안됨. (ex. 102)
     * 조건4. 똑같은 숫자를 입력 해서는 안됨. (ex. 111, 112, 119, 333)
     */

    // 순수 숫자만 있는지 검사하는 메서드
    public boolean isIntegerNumeric(String str, boolean allowPrimeNumbers) throws DecimalFormatException, DoubleInputException {
        //
        if (str == null || str.isEmpty()) return false;

        boolean pointFlag = false;
        char[] c = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(c[i])) continue;
            else if (c[i] == '.') {
                if (pointFlag || i == 0 || i == str.length() - 1) {
                    throw new DecimalFormatException();
                }
                pointFlag = true;
            } else {
                return false;
            }
        }
        if (pointFlag && !allowPrimeNumbers) {
            throw new DoubleInputException();
        }

        return true;

    }

    // n 자리인지 검사하는 메서드
    private boolean isValidDigit(String answer, int difficulty) {
        return answer.length() == difficulty;    // 길이가 n이면 true
    }

    // 0을 포함하고 있는지 검사하는 메서드
    private boolean isContainZero(String answer) {
        return !answer.contains("0");    // 0을 갖고 있지 않으면 true
    }

    // 각 자릿수에 같은 숫자가 있는지 검사하는 메서드
    private boolean isSameNumberByDigit(String answer) {
        return answer.chars().count() == answer.chars().distinct().count();
    }

    // 답안지 검사 메서드
    public boolean answerCheckInvalid(String answer, int difficulty) throws DecimalFormatException, DoubleInputException {
        if (!isIntegerNumeric(answer, false)) {
            System.out.println("숫자가 아닙니다.");
            return false;
        } else if (!isValidDigit(answer, difficulty)) {
            System.out.println(difficulty + " 개의 숫자를 입력해야 합니다.");
            return false;
        } else if (!isContainZero(answer)) {
            System.out.println("0이 아닌 1 ~ 9사이의 " + difficulty + " 개의 숫자가 필요합니다.");
            return false;
        } else if (!isSameNumberByDigit(answer)) {
            System.out.println("중복 숫자를 허용하지 않습니다.");
            return false;
        } else {
            return true;
        }
    }

    // String을 List로 변환해서 반환해주는 메서드
    public List<Integer> changeStrToList(String input) {
        List<Integer> inputList = new ArrayList<>();
        for (String str : input.split("")) {
            inputList.add(Integer.parseInt(str));
        }

        return inputList;
    }
}
