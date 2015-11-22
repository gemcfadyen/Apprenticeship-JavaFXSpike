package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class JavaFXBoardPresenter implements BoardPresenter {
    private final GridPane grid;
    private final ActionTracker actionTracker;
    private GameController gameController;

    public JavaFXBoardPresenter(GridPane grid, ActionTracker actionTracker, GameController gameController) {
        this.grid = grid;
        this.actionTracker = actionTracker;
        this.gameController = gameController;
    }

    public void drawBoard() {
        Button firstSquare = createButton("1", "Index 0");
        Button secondSquare = createButton("2", "Index 1");
        Button thirdSquare = createButton("3", "Index 2");
        createHBoxForButton(grid, firstSquare, Pos.BOTTOM_LEFT, 2);
        createHBoxForButton(grid, secondSquare, Pos.BOTTOM_CENTER, 3);
        createHBoxForButton(grid, thirdSquare, Pos.BOTTOM_RIGHT, 4);

        AnyClickableItem buttonForCell1 = new JavaFxButton(firstSquare);
        AnyClickableItem buttonForCell2 = new JavaFxButton(secondSquare);
        AnyClickableItem buttonForCell3 = new JavaFxButton(thirdSquare);

        //Display of game status
        Text gameOverTarget = new Text();
        gameOverTarget.setId("gameOverTargetId");
        grid.add(gameOverTarget, 5, 8);
        JavaFxGameStatusDisplay gameStatusTracker = new JavaFxGameStatusDisplay(gameOverTarget);

        //register the action that should happen when a button is clicked
        actionTracker.registerElementForClicking(buttonForCell1, new UserClicksButtonToMakeMoveAction(gameController, buttonForCell1, gameStatusTracker));
        actionTracker.registerElementForClicking(buttonForCell2, new UserClicksButtonToMakeMoveAction(gameController, buttonForCell2, gameStatusTracker));
        actionTracker.registerElementForClicking(buttonForCell3, new UserClicksButtonToMakeMoveAction(gameController, buttonForCell3, gameStatusTracker));

    }

    private void createHBoxForButton(GridPane grid, Button firstSquare, Pos bottomLeft, int columnIndex) {
        HBox gridCell1 = new HBox(10);
        gridCell1.setAlignment(bottomLeft);
        gridCell1.getChildren().add(firstSquare);
        gridCell1.setPrefSize(100, 100);
        grid.add(gridCell1, columnIndex, 5);
    }


    private Button createButton(String text, String value) {
        Button firstSquare = new Button(text);
        firstSquare.setId(value);
        firstSquare.setMinSize(100, 100);
        return firstSquare;
    }

}

interface BoardPresenter {
    void drawBoard();
}