package NumberBaseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputInvalidCheck {
    /**
     * NumberBaseball/InputInvalidCheck.java
     * 전달 받은 입력값이 조건에 맞게 잘 입력했는지 검사하는 역할.
     * 조건1. 순수 숫자만 있어야 함. (ex. 1a2, abc)
     * 조건2. 세 개의 숫자여야 함. (ex. 1234, 12)
     * 조건3. 0을 포함하고 있으면 안됨. (ex. 102)
     * 조건4. 똑같은 숫자를 입력 해서는 안됨. (ex. 111, 112, 119, 333)
     */

    // 순수 숫자만 있는지 검사하는 메서드
    private boolean isNumeric(String answer) {
        return Arrays.stream(answer.split("")).allMatch(s -> Character.isDigit(s.charAt(0)));
    }

    // 세 자리인지 검사하는 메서드
    private boolean isValidDigit(String answer) {
        return answer.length() == 3;    // 길이가 3이면 true
    }

    // 0을 포함하고 있는지 검사하는 메서드
    private boolean isContainZero(String answer) {
        return !answer.contains("0");    // 0을 갖고 있지 않으면 true
    }

    // 각 자릿수에 같은 숫자가 있는지 검사하는 메서드
    private boolean isSameNumberByDigit(String answer) {
        return answer.chars().count() == answer.chars().distinct().count();
    }

    // 최종 검사 메서드
    public boolean checkInvalid(String answer) {
        if(!isNumeric(answer)) {
            System.out.println("숫자가 아닙니다.");
            return false;
        } else if(!isValidDigit(answer)) {
            System.out.println("세 개의 숫자를 입력해야 합니다.");
            return false;
        } else if(!isContainZero(answer)) {
            System.out.println("0이 아닌 1 ~ 9사이의 세 개의 숫자가 필요합니다.");
            return false;
        } else if(!isSameNumberByDigit(answer)) {
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
