package baseball.view.console;

import baseball.domain.umpire.JudgmentResults;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ConsoleViewer {

    public List<Integer> inputPlayerNumbers() {
        System.out.print(ConsoleViewerMessage.PLAYER_INPUT_NUMBER_DISPLAY);
        String playerNumbers = Console.readLine();
        validatePlayerNumbers(playerNumbers);
        return convertToIntList(playerNumbers);
    }

    public String inputRestartNumber() {
        System.out.print(ConsoleViewerMessage.RESTART_OR_END_GAME_DISPLAY);
        String restartNumber = Console.readLine();
        validateRestartNumber(restartNumber);
        return restartNumber;
    }

    public void outputJudgmentResults(JudgmentResults judgmentResults) {
        System.out.println(judgmentResults);
        if(judgmentResults.isAllStrike()) {
            System.out.println(ConsoleViewerMessage.PLAYER_ALL_STRIKE_DISPLAY);
        }
    }

    private void validatePlayerNumbers(String inputNumbers) {
        validatedIsNumericInputValue(inputNumbers);
        validateIsValidInputValueLength(inputNumbers, ConsoleViewerProperties.PLAYER_INPUT_NUMBER_MAX_LENGTH);
    }

    private void validateRestartNumber(String restartNumber) {
        validatedIsNumericInputValue(restartNumber);
        validateIsValidInputValueLength(restartNumber, ConsoleViewerProperties.RESTART_NUMBER_MAX_LENGTH);
        validateIsRestartOrEndGameNumber(restartNumber);
    }

    private void validatedIsNumericInputValue(String inputValue) {
        if(!isNumeric(inputValue)) {
            throw new IllegalArgumentException(
                    ConsoleViewerMessage.ERROR_INPUT_VALUE_IS_NOT_NUMBER.getMessage()
            );
        }
    }

    private boolean isNumeric(String inputValue) {
        return Pattern.matches(ConsoleViewerProperties.PATTERN_ONLY_NUMBERS, inputValue);
    }

    private void validateIsValidInputValueLength(String inputValue, int length) {
        if(inputValue.length() != length) {
            String errorMessage = String.format(
                    ConsoleViewerMessage.ERROR_INPUT_VALUE_IS_NOT_LENGTH_FORMAT.getMessage(),
                    length
            );
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateIsRestartOrEndGameNumber(String restartNumber) {
        int restartNumberAsInt = Integer.parseInt(restartNumber);
        if (restartNumberAsInt != ConsoleViewerProperties.RESTART_NUMBER
                && restartNumberAsInt != ConsoleViewerProperties.END_NUMBER) {
            throw new IllegalArgumentException(
                    ConsoleViewerMessage.ERROR_INPUT_VALUE_IS_NOT_RESTART_NUMBERS.getMessage()
            );
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
