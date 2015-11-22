package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public interface ButtonInterface {
    String getIdentifier();

    void disable();

    void onClick(ClickAction event);

    void setClickAction(ClickAction event);
}


class JavaFxButton extends Button implements ButtonInterface {

    private Button javaFxButton;
    private Game game;

    public JavaFxButton(Game game, Button javaFxButton) {
        this.game = game;
        this.javaFxButton = javaFxButton;
    }


    @Override
    public String getIdentifier() {
       return javaFxButton.getId();
    }

    @Override
    public void disable() {
        javaFxButton.setDisable(true);
    }

    @Override
    public void onClick(ClickAction event) {

    }

    @Override
    public void setClickAction(ClickAction event) {
        javaFxButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            boolean isTaken = false;

            @Override
            public void handle(ActionEvent event) {
                if (!isTaken) {
                    String symbol = placeMarker(game, javaFxButton);
                    javaFxButton.setDisable(true);
                    giveSymbolTo(game, getIdentifier(), symbol);
                    isTaken = true;
                }
            }
        });
    }

    private void giveSymbolTo(Game game, String cellIndex, String symbol) {
        game.updateAt(cellIndex, symbol);
    }

    private String placeMarker(Game game, Button firstSquare) {
        if (game.currentPlayersIndex() == 0) {
            firstSquare.setText("X");
            return "X";
        } else {
            firstSquare.setText("O");
            return "O";
        }
    }

}