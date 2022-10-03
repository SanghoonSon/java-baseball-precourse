package baseball.view.game;

import baseball.domain.answer.AnswerFactory;
import baseball.domain.game.Game;
import baseball.domain.player.Player;
import baseball.domain.player.Players;
import baseball.domain.umpire.JudgmentResults;
import baseball.domain.umpire.Umpire;
import baseball.view.console.ConsoleViewer;

import java.util.List;

public class GameViewer {

    private final ConsoleViewer consoleViewer;
    private boolean isRestartGame;

    public GameViewer(ConsoleViewer consoleViewer) {
        this.consoleViewer = consoleViewer;
        this.isRestartGame = true;
    }

    public void render() {
        while(isRestartGame) {
            runGame();
            askToRestartGame();
        }
    }

    private void runGame() {
        Game game = Game.of(createPlayers(), Umpire.create());
        while(game.hasNextTurn()) {
            List<Integer> playerNumbers = consoleViewer.inputPlayerNumbers();
            JudgmentResults judgmentResults = game.play(playerNumbers);
            consoleViewer.outputJudgmentResults(judgmentResults);
        }
    }

    private Players createPlayers() {
        Player offensePlayer = Player.offense();
        Player defencePlayer = Player.defence(AnswerFactory.of());
        return Players.of(offensePlayer, defencePlayer);
    }

    private void askToRestartGame() {
        String inputRestartNumberAsString = consoleViewer.inputRestartNumber();
        if(GameViewerProperties.RESTART_GAME_VALUE.equals(inputRestartNumberAsString)) {
            this.isRestartGame = false;
        }
    }
}
