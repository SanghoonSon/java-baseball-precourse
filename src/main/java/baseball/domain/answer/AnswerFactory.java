package baseball.domain.answer;

import baseball.domain.answer.exception.NotValidAnswerNumbers;
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

    public static Answer of() {
        List<Integer> randomNumbers = RandomNumberGenerator.createRandomNumbers();
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
}
