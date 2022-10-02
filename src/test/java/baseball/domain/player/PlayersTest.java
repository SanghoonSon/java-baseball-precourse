package baseball.domain.player;

import baseball.domain.answer.Answer;
import baseball.domain.answer.AnswerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Players 클래스")
class PlayersTest {

    @Nested
    @DisplayName("static of 메소드")
    class StaticOfTest {

        @Nested
        @DisplayName("공격수와 수비수가 주어지면")
        class CreateWithOffenseAndDefenceTest {

            @Test
            @DisplayName("새로 생성 된 Players 리턴")
            public void create_players_test() {
                // given
                Player offensePlayer = createPlayer();
                Player defencePlayer = createPlayer();

                // when
                Players players = Players.of(offensePlayer, defencePlayer);

                // then
                assertAll(
                        () -> assertNotNull(players.getOffensePlayer(), "공격수가 정상 생성되어야 하므로 NULL이 될 수 없습니다."),
                        () -> assertNotNull(players.getDefencePlayer(), "수비수가 정상 생성되어야 하므로 NULL이 될 수 없습니다.")
                );
            }
        }

        @Nested
        @DisplayName("공격수 or 수비수중 하나라도 누락되면")
        class CreateIfOffenseOrDefenceIsNullTest {

            @Test
            @DisplayName("Players 생성 실패")
            public void create_players_test() {
                // given
                Player offensePlayer = createPlayer();

                // when && then
                Assertions.assertThrows(
                        IllegalArgumentException.class,
                        () -> Players.of(offensePlayer, null),
                        "수비수가 없으므로 IllegalArgumentException 예외가 발생하여야 합니다."
                );
            }
        }
    }

    private Player createPlayer() {
        Answer answer = AnswerFactory.of();
        return Player.defence(answer);
    }
}