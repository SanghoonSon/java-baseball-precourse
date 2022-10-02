package baseball.global.random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RandomNumberGeneratorTest 클래스")
class RandomNumberGeneratorTest {

    @Nested
    @DisplayName("static createRandomNumbers 메소드")
    class StaticCreateByTest {

        @Test
        @DisplayName("생성 된 랜덤 숫자 리턴")
        public void create_by_list_fetch_strategy() {
            // when
            List<Integer> randomNumbers = RandomNumberGenerator.createRandomNumbers();

            // then
            assertAll(
                    () -> assertEquals(3, randomNumbers.size(), "3개의 랜덤 숫자가 생성되어야 합니다."),
                    () -> assertTrue(() -> {
                        boolean testResult = true;
                        for (Integer randomNumber : randomNumbers) {
                            testResult = (randomNumber > 0 && randomNumber < 10) && testResult;
                        }
                        return testResult;
                    }, "Random Number은 1 이상 9이하이어야 합니다.")
            );
        }
    }
}