package sample;

import javafx.scene.text.Text;

public class JavaFxGameStatusDisplay implements GameStatus {
    private final Text statusBox;

    public JavaFxGameStatusDisplay(Text statusBox) {
        this.statusBox = statusBox;
    }

    @Override
    public void setStatus(String status) {
         statusBox.setText(status);
    }
}
