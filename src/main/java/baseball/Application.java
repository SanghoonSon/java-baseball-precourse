package baseball;

import baseball.view.console.ConsoleViewer;
import baseball.view.game.GameViewer;

public class Application {
    public static void main(String[] args) {
        ConsoleViewer consoleViewer = new ConsoleViewer();
        GameViewer viewer = new GameViewer(consoleViewer);
        viewer.render();
    }
}
