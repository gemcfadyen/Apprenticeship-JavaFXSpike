package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class JavaFxButton implements AnyButton {
    private Button javaFxButton;

    public JavaFxButton(Button javaFxButton) {
        this.javaFxButton = javaFxButton;
    }

    @Override
    public void setClickAction(AnyAction clickAction) {
        javaFxButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clickAction.actionEvent();
            }
        });
    }

    @Override
    public void setAsDisabled() {
        javaFxButton.setDisable(true);
    }

    @Override
    public void setButtonText(String text) {
        javaFxButton.setText(text);
    }

    @Override
    public String getButtonId() {
        return javaFxButton.getId();
    }

}
