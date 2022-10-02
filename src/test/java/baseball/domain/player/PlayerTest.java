package baseball.domain.player;

import baseball.domain.answer.Answer;
import baseball.domain.answer.AnswerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Nested
@DisplayName("Player 클래스")
class PlayerTest {

    @Nested
    @DisplayName("static of 메소드")
    class StaticCreateTest {

        @Test
        @DisplayName("새로 생성 된 Player 리턴")
        public void create_player_test() {
            // given
            Answer answer = AnswerFactory.of();

            // when
            Player player = Player.of(answer);

            // then
            assertAll(
                    () -> assertNotNull(player, "플레이어가 정상 생성되어야 하므로 NULL이 될 수 없습니다."),
                    () -> assertNotNull(player.getAnswer(), "Player가 가진 answer은 NULL이 될 수 없습니다.")
            );
        }
    }
}
