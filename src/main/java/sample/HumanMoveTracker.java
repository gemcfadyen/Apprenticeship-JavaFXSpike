package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class HumanMoveTracker {
    private final GameController gameController;
    private Text gameOverMessage;

    HumanMoveTracker(Text text, GameController gameController) {
        this.gameOverMessage = text;
        this.gameController = gameController;
    }

    public void registerButtonForClicking(Button button) {

        button.setOnAction(mouseClickEventHandler(button));
    }

    public EventHandler<ActionEvent> mouseClickEventHandler(Button button) {
        return onButtonClickEvent(button);
    }

    private EventHandler<ActionEvent> onButtonClickEvent(Button button) {
        return new EventHandler<ActionEvent>() {
            boolean isTaken = false;

            @Override
            public void handle(ActionEvent event) {
                if (!isTaken) {
                    String symbol = gameController.updateGrid(button.getId());
                    button.setText(symbol);
                    String status = gameController.gameStatus();
                    gameOverMessage.setText(status);
                    button.setDisable(true);
                    isTaken = true;
                }
            }
        };
    }
}
