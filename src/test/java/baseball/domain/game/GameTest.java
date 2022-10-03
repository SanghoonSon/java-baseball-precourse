package baseball.domain.game;

import baseball.domain.answer.AnswerFactory;
import baseball.domain.player.Player;
import baseball.domain.player.Players;
import baseball.domain.umpire.JudgmentResults;
import baseball.domain.umpire.Umpire;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Game 클래스")
class GameTest {

    @Nested
    @DisplayName("static of 메소드")
    class StaticOfTest {

        @Test
        @DisplayName("players, umpire가 주어지면 생성 된 Game 리턴")
        void create_game_with_players_test() {
            // given
            Players players = createPlayers();
            Umpire umpire = Umpire.create();

            // when
            Game game = Game.of(players, umpire);

            // then
            assertNotNull(game, "정상 생성되어야하므로 NULL일수 없습니다.");
        }

        @Test
        @DisplayName("players가 누락되면 예외 처리")
        void create_game_with_null_players_test() {
            // when
            Players players = null;
            Umpire umpire = Umpire.create();

            // when && then
            assertThrows(IllegalArgumentException.class,
                    () -> Game.of(players, umpire),
                    "players가 없으므로 예외 처리 되어야합니다.");
        }
    }

    @Nested
    @DisplayName("play 메소드")
    class PlayTest {

        @Nested
        @DisplayName("공격수 숫자값이 주어지면")
        class GivenOffensePlayerAnswerNumberTest {

            @Test
            @DisplayName("심판이 판정한 결과를 리턴")
            void game_play_test() {
                // given
                Players players = createPlayers();
                Game game = Game.of(createPlayers(), Umpire.create());
                List<Integer> offensePlayerAnswerNumber = Arrays.asList(1, 2, 3);

                // when
                JudgmentResults judgmentResults = game.play(offensePlayerAnswerNumber);

                // then
                assertNotNull(judgmentResults, "심판 판정 결과가 NULL일수 없습니다.");
            }

            @Test
            @DisplayName("3스트라이크면 게임 종료")
            void game_has_next_turn_if_three_strike_test() {
                // given
                Game game = createGame();
                List<Integer> defencePlayerAnswerNumber = game.getPlayers()
                        .getDefencePlayer()
                        .getAnswer()
                        .getNumbers();

                // when
                game.play(defencePlayerAnswerNumber);

                // then
                assertFalse(game.hasNextTurn(), "3스트라이크이므로 게임이 종료되어야 합니다.");
            }
        }
    }

    private Players createPlayers() {
        Player offensePlayer = Player.offense();
        Player defencePlayer = Player.defence(AnswerFactory.of());
        return Players.of(offensePlayer, defencePlayer);
    }

    private Game createGame() {
        return Game.of(createPlayers(), Umpire.create());
    }
}