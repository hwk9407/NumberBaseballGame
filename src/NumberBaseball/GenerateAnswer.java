package NumberBaseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateAnswer {
    /**
     * NumberBaseball/GenerateAnswer.java
     * 랜덤한 세 자리의 수 생성 하는 객체
     * 1 ~ 9의 숫자만 사용해야 하며(0은 안된다.)
     * 각 자리수의 수들은 중복되지 않아야 한다. (123, 234는 되지만 333, 112는 안됨)
     */
    private List<Integer> answer;

    // 생성자
    public GenerateAnswer() {
        this.answer = new ArrayList<>(); // 순서가 중요하나 중복을 허용하면 안됨.
        for (int i = 1; i <= 9; i++) {  // randList : [1, 2, 3, 4, 5, 6, 7, 8, 9]
            this.answer.add(i);
        }
        Collections.shuffle(this.answer);  // 섞는 메서드
        this.answer = this.answer.subList(0, 3); // 0, 1, 2 3개의 요소만 가져옴
    }

    // getter
    public List<Integer> getAnswer() {
        return this.answer;
    }
}
