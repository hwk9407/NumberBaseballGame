package NumberBaseball;

import java.util.Arrays;

public class AnswerCheck {
    /**
     * NumberBaseball/AnswerCheck.java
     * 전달 받은 입력값을 검사하는 역할.
     * 전달 받은 입력값과 GenerateAnswer에 있는 정답과 비교하여
     * -----------------------------------------
     * Strike : 위치(자릿수)도 맞고, 숫자도 맞춤
     * Ball   : 위치는 틀리고, 숫자는 맞춤
     * Out    : 숫자 틀림
     * -----------------------------------------
     * 각 SBO가 몇개인지 반환해주는 기능을 담당
     */

    // 순수 숫자만 있는지 검사하는 메서드
    private boolean isNumeric(String answer) {
        return Arrays.stream(answer.split("")).allMatch(s -> Character.isDigit(s.charAt(0)));
    }

    // 세자리인지 검사하는 메서드
    private boolean isValidDigit(String answer) {
        return answer.length() == 3;    // 길이가 3이면 true
    }

    // 0을 포함하고있는지 검사하는 메서드
    private boolean isContainZero(String answer) {
        return !answer.contains("0");    // 0을 갖고 있지 않으면 true
    }

    // 각 자릿수에 같은 숫자가 있는지 검사하는 메서드
    private boolean isSameNumberByDigit(String answer) {
        return answer.chars().count() == answer.chars().distinct().count();
    }

    // 입력받은 String을 채점해주는 메서드
    public boolean scoreCalculate(String answer) {
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

            // strike, ball, out을 카운트해주기.

            return true;
        }
    }
}
