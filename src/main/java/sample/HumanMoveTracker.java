package sample;

public class HumanMoveTracker {

    public void registerButtonForClicking(AnyButton button, AnyAction action) {
        button.setClickAction(action);
    }
}
