package baseball.domain.answer;

import baseball.domain.answer.exception.NotValidAnswerNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AnswerFactory 클래스")
class AnswerFactoryTest {

    @Nested
    @DisplayName("static of 메소드")
    class StaticOfTest {

        @Nested
        @DisplayName("Input값이 주어지면")
        class GivenInputNumbersTest {

            @Test
            @DisplayName("Input값으로 생성 된 Answer 리턴")
            public void when_input_numbers_test() {
                // given
                String inputNumbers = "345";

                // when
                Answer answer = AnswerFactory.of(inputNumbers);

                // then
                assertIfCreatedAnswer(answer);
            }
        }

        @Nested
        @DisplayName("Input값이 유효하지 않으면")
        class GivenNotValidInputNumbersTest {

            @Test
            @DisplayName("Answer 생성 실패")
            public void when_if_not_valid_input_numbers_test() {
                // given
                String inputNumbers = "-1aa";

                // when && then
                assertThrows(NotValidAnswerNumbers.class,
                        () -> AnswerFactory.of(inputNumbers),
                        "Input값이 유효하지 않으므로 예외가 발생하여야 합니다"
                );
            }
        }

        @Nested
        @DisplayName("기본 생성 메소드이면")
        class GivenStrategyAndDigitsTest {

            @Test
            @DisplayName("생성 된 Answer 리턴")
            public void when_list_strategy_test() {
                // when
                Answer answer = AnswerFactory.of();

                // then
                assertIfCreatedAnswer(answer);
            }
        }
    }

    private void assertIfCreatedAnswer(Answer answer) {
        assertAll(
                () -> assertNotNull(answer, "정상 생성되어야 하므로 NULL이 될 수 없습니다."),
                () -> assertNotNull(answer.getNumbers(), "Answer의 Number는 NULL이 될 수 없습니다.")
        );
    }
}