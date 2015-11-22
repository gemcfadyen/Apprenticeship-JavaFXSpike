package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
        addUserName(grid);
        addPassword(grid);
        Button btn = createButton(grid);
        final Text actionTarget = new Text();
        actionTarget.setId("actionTargetId");
        grid.add(actionTarget, 1, 6);
        btn.setOnAction(event -> actionTarget.setText("Button was pressed"));

        /***********************************************/
        //Spike for TTT
        Button firstSquare = createButton("1", "Index 0");
        Button secondSquare = createButton("2", "Index 1");
        Button thirdSquare = createButton("3", "Index 2");

        createHBoxForButton(grid, firstSquare, Pos.BOTTOM_LEFT, 2);
        createHBoxForButton(grid, secondSquare, Pos.BOTTOM_CENTER, 3);
        createHBoxForButton(grid, thirdSquare, Pos.BOTTOM_RIGHT, 4);

        Text gameOverTarget = new Text();
        gameOverTarget.setId("gameOverTargetId");

        grid.add(gameOverTarget, 1, 8);

        GameController gameController = new GameController(game);
        HumanMoveTracker humanMoveTracker = new HumanMoveTracker();

        JavaFxButton buttonForCell1 = new JavaFxButton(firstSquare);
        JavaFxButton buttonForCell2 = new JavaFxButton(secondSquare);
        JavaFxButton buttonForCell3 = new JavaFxButton(thirdSquare);

        JavaFxGameStatusDisplay gameStatusTracker = new JavaFxGameStatusDisplay(gameOverTarget);
        humanMoveTracker.registerButtonForClicking(buttonForCell1, new UserClicksButtonToMakeMoveAction(gameController, buttonForCell1, gameStatusTracker));
        humanMoveTracker.registerButtonForClicking(buttonForCell2, new UserClicksButtonToMakeMoveAction(gameController, buttonForCell2, gameStatusTracker));
        humanMoveTracker.registerButtonForClicking(buttonForCell3, new UserClicksButtonToMakeMoveAction(gameController, buttonForCell3, gameStatusTracker));

        Scene scene = new Scene(grid, 700, 700);
        scene.getStylesheets().add(Main.class.getResource("presentation.css").toExternalForm());
        primaryStage.setTitle("JavaFX Spike");
        primaryStage.setScene(scene);
        primaryStage.show();
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

    private void setTitleOfScene(GridPane grid) {
        Text sceneTitle = new Text("TTT Spike");
        sceneTitle.setId("sceneTitle");
        grid.add(sceneTitle, 0, 0, 2, 1);
    }

    private Button createButton(GridPane grid) {
        Button btn = new Button("sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        return btn;
    }

    private void addPassword(GridPane grid) {
        Label password = new Label("password");
        grid.add(password, 0, 2);

        TextField passwordTextField = new PasswordField();
        grid.add(passwordTextField, 1, 2);
    }

    private void addUserName(GridPane grid) {
        Label username = new Label("username");
        grid.add(username, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
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