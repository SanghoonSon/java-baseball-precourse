package baseball.view.console;

import baseball.domain.umpire.JudgmentResults;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ConsoleViewer {
    public static final String PATTERN_ONLY_NUMBERS;

    static {
        PATTERN_ONLY_NUMBERS = "-?\\d+(\\.\\d+)?";
    }

    public List<Integer> inputPlayerNumbers() {
        System.out.print(ConsoleViewerConst.PLAYER_INPUT_NUMBER_DISPLAY);
        String playerNumbers = Console.readLine();
        validatePlayerNumbers(playerNumbers);
        return convertToIntList(playerNumbers);
    }

    public String inputRestartNumber() {
        System.out.print(ConsoleViewerConst.RESTART_OR_END_GAME_DISPLAY);
        String restartNumber = Console.readLine();
        validateRestartNumber(restartNumber);
        return restartNumber;
    }

    public void outputJudgmentResults(JudgmentResults judgmentResults) {
        System.out.println(judgmentResults);
        if(judgmentResults.isAllStrike()) {
            System.out.println(ConsoleViewerConst.PLAYER_ALL_STRIKE_DISPLAY);
        }
    }

    private void validatePlayerNumbers(String inputNumbers) {
        validatedIsNumericInputValue(inputNumbers);
        validateIsValidInputValueLength(inputNumbers, ConsoleViewerConst.PLAYER_INPUT_NUMBER_MAX_LENGTH);
    }

    private void validateRestartNumber(String restartNumber) {
        validatedIsNumericInputValue(restartNumber);
        validateIsValidInputValueLength(restartNumber, ConsoleViewerConst.RESTART_NUMBER_MAX_LENGTH);
        validateIsRestartOrEndGameNumber(restartNumber);
    }

    private void validatedIsNumericInputValue(String inputValue) {
        if(!isNumeric(inputValue)) {
            throw new IllegalArgumentException(ConsoleViewerConst.ERROR_INPUT_VALUE_IS_NOT_NUMBER);
        }
    }

    private boolean isNumeric(String inputValue) {
        return Pattern.matches(PATTERN_ONLY_NUMBERS, inputValue);
    }

    private void validateIsValidInputValueLength(String inputValue, int length) {
        if(inputValue.length() != length) {
            String errorMessage = String.format(ConsoleViewerConst.ERROR_INPUT_VALUE_IS_NOT_LENGTH_FORMAT, length);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateIsRestartOrEndGameNumber(String restartNumber) {
        if (Integer.parseInt(restartNumber) != ConsoleViewerConst.RESTART_NUMBER
                && Integer.parseInt(restartNumber) != ConsoleViewerConst.END_NUMBER) {
            throw new IllegalArgumentException(ConsoleViewerConst.ERROR_INPUT_VALUE_IS_NOT_RESTART_NUMBERS);
        }
    }

    private List<Integer> convertToIntList(String value) {
        List<Integer> valueAsIntList = new ArrayList<>();
        for (char valueAsChar : value.toCharArray()) {
            valueAsIntList.add(Character.getNumericValue(valueAsChar));
        }
        return valueAsIntList;
    }
}
