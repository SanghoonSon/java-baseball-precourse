package baseball.domain.player;

import baseball.domain.answer.Answer;

public class Player {

    private final Answer answer;

    private Player(Answer answer) {
        this.answer = answer;
    }

    public static Player offense() {
        return new Player(null);
    }

    public static Player defence(Answer answer) {
        return new Player(answer);
    }

    public Answer getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return answer.equals(player.answer);
    }

    @Override
    public int hashCode() {
        return answer.hashCode();
    }
}
