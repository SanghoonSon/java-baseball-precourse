package baseball.view.console;

public abstract class ConsoleViewerConst {

    public static final int PLAYER_INPUT_NUMBER_MAX_LENGTH = 3;
    public static final int RESTART_NUMBER_MAX_LENGTH = 1;
    public static final int RESTART_NUMBER = 1;
    public static final int END_NUMBER = 2;
    public static final String PLAYER_INPUT_NUMBER_DISPLAY = "숫자를 입력해주세요 : ";
    public static final String PLAYER_ALL_STRIKE_DISPLAY = "3개의 숫자를 모두 맞셨습니다! 게임 종료";
    public static final String RESTART_OR_END_GAME_DISPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";

    public static final String ERROR_INPUT_VALUE_IS_NOT_NUMBER = "입력값이 숫자가 아닙니다.";
    public static final String ERROR_INPUT_VALUE_IS_NOT_LENGTH_FORMAT = "입력값은 %d자리 숫자이어야 합니다.";
    public static final String ERROR_INPUT_VALUE_IS_NOT_RESTART_NUMBERS = "1(재시작) 또는 2(종료)값을 입력하여야 합니다.";
}
