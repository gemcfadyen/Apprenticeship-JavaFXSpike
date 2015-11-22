package sample;

public class UserSelectsGameTypeRadioButtonSelection implements AnyAction {
    private final BoardPresenter boardPresenter;
    private final AnyClickableItem clickableItem;
    private boolean isSelected = false;

    public UserSelectsGameTypeRadioButtonSelection(AnyClickableItem clickableItem, BoardPresenter boardPresenter) {
        this.clickableItem = clickableItem;
        this.boardPresenter = boardPresenter;
    }

    @Override
    public void actionEvent() {
        if (!isSelected) {
            boardPresenter.drawBoard();
            clickableItem.setAsDisabled();
            isSelected = true;
        }
    }
}
