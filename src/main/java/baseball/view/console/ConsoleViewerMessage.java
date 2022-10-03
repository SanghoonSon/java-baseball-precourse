package baseball.view.console;

public enum ConsoleViewerMessage {
    PLAYER_INPUT_NUMBER_DISPLAY("숫자를 입력해주세요 : "),
    PLAYER_ALL_STRIKE_DISPLAY("3개의 숫자를 모두 맞셨습니다! 게임 종료"),
    RESTART_OR_END_GAME_DISPLAY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. "),

    ERROR_INPUT_VALUE_IS_NOT_NUMBER("입력값이 숫자가 아닙니다."),
    ERROR_INPUT_VALUE_IS_NOT_LENGTH_FORMAT("입력값은 %d자리 숫자이어야 합니다."),
    ERROR_INPUT_VALUE_IS_NOT_RESTART_NUMBERS("1(재시작) 또는 2(종료)값을 입력하여야 합니다.");

    private final String message;

    ConsoleViewerMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
