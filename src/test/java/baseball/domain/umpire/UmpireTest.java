package baseball.domain.umpire;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Umpire 클래스")
class UmpireTest {

    @Nested
    @DisplayName("judge 메소드")
    class JudgeTest {

        @Nested
        @DisplayName("수비수와 공격수의 숫자값이 주어지면")
        class GivenOffenseAndDefencePlayerNumbersTest {

            @Test
            @DisplayName("숫자값이 모두 일치하면 3스트라이크 처리")
            void judge_equal_all_numbers_test() {
                // given
                Umpire umpire = Umpire.create();
                List<Integer> offensePlayerNumbers = Arrays.asList(1, 2, 3);
                List<Integer> defencePlayerNumbers = Arrays.asList(1, 2, 3);

                // when
                JudgmentResults judgmentResults = umpire.judge(offensePlayerNumbers, defencePlayerNumbers);

                // then
                assertAll(
                        () -> assertTrue(judgmentResults::isAllStrike, "숫자값이 모두 일치하므로 3스트라이크이어야 합니다."),
                        () -> assertEquals(judgmentResults.toString(), "3스트라이크", "숫자값이 모두 일치하므로 3스트라이크이어야 합니다.")
                );
            }

            @Test
            @DisplayName("2개 숫자값의 위치가 다른경우 2볼 처리")
            void judge_two_diff_location_numbers_test() {
                // given
                Umpire umpire = Umpire.create();
                List<Integer> offensePlayerNumbers = Arrays.asList(1, 4, 3);
                List<Integer> defencePlayerNumbers = Arrays.asList(3, 2, 1);

                // when
                JudgmentResults judgmentResults = umpire.judge(offensePlayerNumbers, defencePlayerNumbers);

                // then
                assertEquals(judgmentResults.toString(), "2볼", "2개 숫자값의 위치만 다르므로 2볼 처리되어야 합니다.");
            }

            @Test
            @DisplayName("1개 숫자는 일치하고 2개 숫자값의 위치가 다른경우 2볼 1스트라이크 처리")
            void judge_one_equal_and_two_diff_location_numbers_test() {
                // given
                Umpire umpire = Umpire.create();
                List<Integer> offensePlayerNumbers = Arrays.asList(1, 2, 3);
                List<Integer> defencePlayerNumbers = Arrays.asList(3, 2, 1);

                // when
                JudgmentResults judgmentResults = umpire.judge(offensePlayerNumbers, defencePlayerNumbers);

                // then
                assertEquals(judgmentResults.toString(), "2볼 1스트라이크", "1개는 일치하고 2개 숫자값 위치가 다르므로 2볼 1스트라이크 처리되어야 합니다.");
            }

            @Test
            @DisplayName("3개 숫자값 모두 다른 경우 낫싱 처리")
            void judge_diff_all_numbers_test() {
                // given
                Umpire umpire = Umpire.create();
                List<Integer> offensePlayerNumbers = Arrays.asList(1, 2, 3);
                List<Integer> defencePlayerNumbers = Arrays.asList(4, 5, 6);

                // when
                JudgmentResults judgmentResults = umpire.judge(offensePlayerNumbers, defencePlayerNumbers);

                // then
                assertEquals(judgmentResults.toString(), "낫싱", "3개 숫자값이 모두 다르므로 낫싱 처리되어야 합니다.");
            }
        }
    }
}