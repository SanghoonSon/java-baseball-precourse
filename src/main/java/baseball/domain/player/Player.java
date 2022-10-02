package baseball.domain.player;

import baseball.domain.answer.Answer;

public class Player {

    private final Answer answer;

    private Player(Answer answer) {
        this.answer = answer;
    }

    public static Player of(Answer answer) {
        return new Player(answer);
    }

    public Answer getAnswer() {
        return answer;
    }
}
