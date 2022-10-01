package baseball.domain.answer;

import baseball.domain.answer.exception.NotValidAnswerNumbers;

import java.util.List;

public class Answer {
    private final List<Integer> numbers;

    private Answer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Answer of(List<Integer> numbers) {
        validateNumbers(numbers);
        return new Answer(numbers);
    }

    private static void validateNumbers(List<Integer> numbers) {
        if(numbers == null || numbers.isEmpty()) {
            throw new NotValidAnswerNumbers("숫자는 필수값입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
