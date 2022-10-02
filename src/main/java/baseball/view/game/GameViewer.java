package baseball.view.game;

import baseball.domain.answer.AnswerFactory;
import baseball.domain.game.Game;
import baseball.domain.player.Player;
import baseball.domain.player.Players;
import baseball.domain.umpire.JudgmentResults;
import baseball.view.console.ConsoleViewer;

import java.util.List;

public class GameViewer {

    private final ConsoleViewer consoleViewer;
    private boolean isRetryGame;

    public GameViewer(ConsoleViewer consoleViewer) {
        this.consoleViewer = consoleViewer;
        this.isRetryGame = true;
    }

    public void render() {
        while(isRetryGame) {
            runGame();
            isRetryGame();
        }
    }

    private void runGame() {
        Players players = createPlayers();
        Game game = Game.of(players);
        while(game.hasNextTurn()) {
            List<Integer> playerNumbers = consoleViewer.inputPlayerNumbers();
            JudgmentResults judgmentResults = game.play(playerNumbers);
            consoleViewer.outputJudgmentResults(judgmentResults);
        }
    }

    private Players createPlayers() {
        Player offensePlayer = Player.of(AnswerFactory.of());
        Player defencePlayer = Player.of(AnswerFactory.of());
        return Players.of(offensePlayer, defencePlayer);
    }

    private void isRetryGame() {
        String retryGameInput = consoleViewer.inputRestartNumber();
        if("2".equals(retryGameInput)) {
            this.isRetryGame = false;
        }
    }
}
