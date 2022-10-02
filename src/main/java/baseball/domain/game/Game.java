package baseball.domain.game;

import baseball.domain.player.Players;
import baseball.domain.umpire.JudgmentResults;
import baseball.domain.umpire.Umpire;

import java.util.List;

public class Game {

    private final Players players;
    private final Umpire umpire;
    private boolean hasNextTurn;
    
    private Game(Players players, Umpire umpire) {
        this.players = players;
        this.umpire = umpire;
        this.hasNextTurn = true;
    }

    public static Game of(Players players) {
        if(players == null) {
            throw new IllegalArgumentException("Players는 필수값입니다.");
        }

        Umpire umpire = Umpire.create();
        return new Game(players, umpire);
    }

    public boolean hasNextTurn() {
        return this.hasNextTurn;
    }

    public JudgmentResults play(List<Integer> offensePlayerAnswerNumber) {
        List<Integer> defencePlayerAnswerNumbers = this.players.getDefencePlayer().getAnswer().getNumbers();
        JudgmentResults judgmentResults = this.umpire.judge(offensePlayerAnswerNumber, defencePlayerAnswerNumbers);
        if(judgmentResults.isAllStrike()) {
            endGame();
        }

        return judgmentResults;
    }

    private void endGame() {
        this.hasNextTurn = false;
    }
}
