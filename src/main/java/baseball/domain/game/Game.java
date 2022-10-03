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

    public static Game of(Players players, Umpire umpire) {
        if(players == null) {
            throw new IllegalArgumentException("Players는 필수값입니다.");
        }
        return new Game(players, umpire);
    }

    public boolean hasNextTurn() {
        return this.hasNextTurn;
    }

    public Players getPlayers() {
        return this.players;
    }

    public JudgmentResults play(List<Integer> offensePlayerAnswerNumber) {
        List<Integer> defencePlayerAnswerNumbers = getPlayers().getDefencePlayer().getAnswer().getNumbers();
        JudgmentResults judgmentResults = this.umpire.judge(offensePlayerAnswerNumber, defencePlayerAnswerNumbers);
        if(judgmentResults.isAllStrike()) {
            endGame();
        }

        return judgmentResults;
    }

    private void endGame() {
        this.hasNextTurn = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (!players.equals(game.players)) return false;
        return umpire.equals(game.umpire);
    }

    @Override
    public int hashCode() {
        int result = players.hashCode();
        result = 31 * result + umpire.hashCode();
        return result;
    }
}
