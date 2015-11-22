package sample;

public class UserClicksButtonToMakeMoveAction implements AnyAction {
    private final GameController gameController;
    private final AnyClickableItem button;
    private final GameStatus gameStatus;
    private boolean isTaken = false;

    UserClicksButtonToMakeMoveAction(GameController gameController, AnyClickableItem button, GameStatus gameStatus) {
        this.gameController = gameController;
        this.button = button;
        this.gameStatus = gameStatus;
    }

    @Override
    public void actionEvent() {
        if (!isTaken) {
            String symbol = gameController.updateGrid(button.getId());
            button.setText(symbol);
            gameStatus.setStatus(gameController.gameStatus());
            button.setAsDisabled();
            isTaken = true;
        }
    }
}
