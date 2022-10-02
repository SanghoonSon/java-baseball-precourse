package baseball.view.console;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mockStatic;

@DisplayName("ConsoleViewer 클래스")
class ConsoleViewerTest {

    @Nested
    @DisplayName("inputPlayerNumbers 메소드")
    class InputPlayerNumbersTest {

        @ParameterizedTest
        @ValueSource(strings = {"123", "456", "789"})
        @DisplayName("정상적인 입력값인 경우 예외 없음")
        void input_player_valid_numbers_test(String input) {
            // given
            ConsoleViewer consoleViewer = new ConsoleViewer();

            // when && then
            try (final MockedStatic<Console> mock = mockStatic(Console.class)) {
                mock.when(Console::readLine).thenReturn(input);
                assertThatCode(consoleViewer::inputPlayerNumbers).doesNotThrowAnyException();
            }
        }

        @ParameterizedTest
        @ValueSource(strings = {"12", "3456", "78"})
        @DisplayName("입력값 자리수가 일치하지 않은 경우 예외 처리")
        void input_player_not_valid_numbers_test(String input) {
            // given
            ConsoleViewer consoleViewer = new ConsoleViewer();

            // when && then
            try (final MockedStatic<Console> mock = mockStatic(Console.class)) {
                mock.when(Console::readLine).thenReturn(input);
                assertThatCode(consoleViewer::inputPlayerNumbers)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값은 3자리 숫자이어야 합니다.");
            }
        }

        @ParameterizedTest
        @ValueSource(strings = {"12a", "34a", "78b"})
        @DisplayName("입력값이 숫자가 아닌 경우 예외 처리")
        void input_player_numbers_and_alphabet_test(String input) {
            // given
            ConsoleViewer consoleViewer = new ConsoleViewer();

            // when && then
            try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
                consoleMockedStatic.when(Console::readLine).thenReturn(input);
                assertThatCode(consoleViewer::inputPlayerNumbers)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값이 숫자가 아닙니다.");
            }
        }
    }

    @Nested
    @DisplayName("inputRestartNumber 메소드")
    class InputRestartNumbersTest {

        @ParameterizedTest
        @ValueSource(strings = {"1", "2"})
        @DisplayName("게임 재시작 및 종료 값인 경우 예외 없음")
        void input_restart_numbers_test(String input) {
            // given
            ConsoleViewer consoleViewer = new ConsoleViewer();

            // when && then
            try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
                consoleMockedStatic.when(Console::readLine).thenReturn(input);
                assertThatCode(consoleViewer::inputRestartNumber).doesNotThrowAnyException();
            }
        }

        @ParameterizedTest
        @ValueSource(strings = {"3", "4", "6"})
        @DisplayName("게임 재시작 및 종료 값이 아닌 않은 경우 예외 처리")
        void input_restart_not_numbers_test(String input) {
            // given
            ConsoleViewer consoleViewer = new ConsoleViewer();

            // when && then
            try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
                consoleMockedStatic.when(Console::readLine).thenReturn(input);
                assertThatCode(consoleViewer::inputRestartNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("1(재시작) 또는 2(종료)값을 입력하여야 합니다.");
            }
        }

        @ParameterizedTest
        @ValueSource(strings = {"33", "444", "6666"})
        @DisplayName("게임 재시작 및 종료 값이 길이가 잘못 된 경우 예외 처리")
        void input_restart_not_equal_length_numbers_test(String input) {
            // given
            ConsoleViewer consoleViewer = new ConsoleViewer();

            // when && then
            try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
                consoleMockedStatic.when(Console::readLine).thenReturn(input);
                assertThatCode(consoleViewer::inputRestartNumber)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("입력값은 1자리 숫자이어야 합니다.");
            }
        }
    }
}