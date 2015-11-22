package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

public class JavaFxRadioBox implements AnyClickableItem {
    private final RadioButton radioButton;

    public JavaFxRadioBox(RadioButton radioButton) {
        this.radioButton = radioButton;
    }

    @Override
    public void setClickAction(AnyAction clickAction) {
        radioButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickAction.actionEvent();
            }
        });
    }

    @Override
    public void setText(String text) {
        radioButton.setText("Human vs Human");
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setAsDisabled() {
        radioButton.setDisable(true);
    }
}
