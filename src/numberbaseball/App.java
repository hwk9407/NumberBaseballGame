package numberbaseball;

public class App {
    /**
     * numberbaseball/App.java
     * main클래스 숫자 야구 게임 객체를 생성하고 실행함.
     *
     */
    public static void main(String[] args) {
        GameMenu gameMenu = new GameMenu();
        gameMenu.gameStart();
    }
}
