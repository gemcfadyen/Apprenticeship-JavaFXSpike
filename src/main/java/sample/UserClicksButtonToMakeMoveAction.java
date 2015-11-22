package sample;

public class UserClicksButtonToMakeMoveAction implements AnyAction {
    private final GameController gameController;
    private final AnyButton button;
    private final GameStatus gameStatus;
    private boolean isTaken = false;

    UserClicksButtonToMakeMoveAction(GameController gameController, AnyButton button, GameStatus gameStatus) {
        this.gameController = gameController;
        this.button = button;
        this.gameStatus = gameStatus;
    }

    @Override
    public void actionEvent() {
        if (!isTaken) {
            String symbol = gameController.updateGrid(button.getButtonId());
            button.setButtonText(symbol);
            gameStatus.setStatus(gameController.gameStatus());
            button.setAsDisabled();
            isTaken = true;
        }
    }
}
