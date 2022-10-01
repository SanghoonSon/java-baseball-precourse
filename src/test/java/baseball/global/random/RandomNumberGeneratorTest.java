package baseball.global.random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RandomNumberGeneratorTest 클래스")
class RandomNumberGeneratorTest {

    @Nested
    @DisplayName("static createBy 메소드")
    class StaticCreateByTest {

        @Nested
        @DisplayName("Fetch 전략이 LIST이면")
        class CreateByListFetchStrategyTest {

            @Test
            @DisplayName("생성 된 랜덤 숫자 리턴")
            public void create_by_list_fetch_strategy() {
                // given
                RandomNumberFetchStrategy fetchStrategy = RandomNumberFetchStrategy.LIST;

                // when
                int randomNumber = RandomNumberGenerator.createBy(fetchStrategy);

                // then
                assertAll(
                        () -> assertTrue(randomNumber > 0, "Random Number은 1 이상이어야 합니다."),
                        () -> assertTrue(randomNumber < 10, "Random Number은 9 이하이어야 합니다.")
                );
            }
        }

        @Nested
        @DisplayName("Fetch 전략이 RANGE이면")
        class CreateByRangeFetchStrategyTest {

            @Test
            @DisplayName("생성 된 랜덤 숫자 리턴")
            public void create_by_range_fetch_strategy() {
                // given
                RandomNumberFetchStrategy fetchStrategy = RandomNumberFetchStrategy.RANGE;

                // when
                int randomNumber = RandomNumberGenerator.createBy(fetchStrategy);

                // then
                assertAll(
                        () -> assertTrue(randomNumber > 0, "Random Number은 1 이상이어야 합니다."),
                        () -> assertTrue(randomNumber < 10, "Random Number은 9 이하이어야 합니다.")
                );
            }
        }
    }
}