package baseball.domain.answer;

import baseball.domain.answer.exception.NotValidAnswerNumbers;
import baseball.global.random.RandomNumberFetchStrategy;
import baseball.global.random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class AnswerFactory {

    public static Answer of(String inputNumbers) {
        validateInputNumbers(inputNumbers);
        List<Integer> numbers = new ArrayList<>();
        for (char inputNumber : inputNumbers.toCharArray()) {
            numbers.add(Character.getNumericValue(inputNumber));
        }
        return Answer.of(numbers);
    }

    public static Answer of(RandomNumberFetchStrategy strategy, int digits) {
        validateInputNumberDigits(digits);
        List<Integer> randomNumbers = new ArrayList<>();
        for(int i = 0; i < digits; i++) {
            int randomNumber = RandomNumberGenerator.createBy(strategy);
            randomNumbers.add(randomNumber);
        }
        return Answer.of(randomNumbers);
    }

    private static void validateInputNumbers(String inputNumbers) throws NotValidAnswerNumbers {
        validateInputNumbersIsEmpty(inputNumbers);
        for (char number : inputNumbers.toCharArray()) {
            validateInputNumbersIsNumeric(number);
        }
    }

    private static void validateInputNumbersIsEmpty(String inputNumbers) {
        if(inputNumbers == null || inputNumbers.length() < 1) {
            throw new NotValidAnswerNumbers("number은 필수값입니다.");
        }
    }

    private static void validateInputNumbersIsNumeric(char number) {
        if(number < 48 || number > 57) {
            throw new NotValidAnswerNumbers("숫자만 입력이 가능합니다.");
        }
    }

    private static void validateInputNumberDigits(int digits) {
        if(digits < 0) {
            throw new IllegalArgumentException("자리수는 1이상이어야 합니다.");
        }
    }
}
