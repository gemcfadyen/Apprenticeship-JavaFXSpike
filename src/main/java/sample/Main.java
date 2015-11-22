package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();

        GridPane grid = createGrid();
        setTitleOfScene(grid);

        //Spike for TTT
        GameController gameController = new GameController(game);
        HumanMoveTracker humanMoveTracker = new HumanMoveTracker();

        //Prompt user to select game type - human vs human
        String gameType = gameController.getGameType();
        RadioButton humanVsHumanRadioButton = new RadioButton(gameType);
        humanVsHumanRadioButton.setId("gameTypeSelectionId");
        AnyClickableItem javaFxHumanVsHumanRadioButton = new JavaFxRadioBox(humanVsHumanRadioButton);

        //register the action that should happen when radio box is selected
        humanMoveTracker.registerElementForClicking(javaFxHumanVsHumanRadioButton,
                new UserSelectsGameTypeRadioButtonSelection(javaFxHumanVsHumanRadioButton, new JavaFXBoardPresenter(grid, humanMoveTracker, gameController)));
        grid.add(humanVsHumanRadioButton, 0, 1);

        //draw the page
        Scene scene = new Scene(grid, 700, 700);
        scene.getStylesheets().add(Main.class.getResource("presentation.css").toExternalForm());
        primaryStage.setTitle("JavaFX Spike");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setTitleOfScene(GridPane grid) {
        Text sceneTitle = new Text("TTT Spike");
        sceneTitle.setId("sceneTitle");
        grid.add(sceneTitle, 0, 0, 2, 1);
    }


    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return grid;
    }
}