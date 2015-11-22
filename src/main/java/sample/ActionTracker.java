package sample;

public class ActionTracker implements RegisterAction {

    @Override
    public void registerElementForClicking(AnyClickableItem clickableElement, AnyAction action) {
        clickableElement.setClickAction(action);
    }
}

interface RegisterAction {
    void registerElementForClicking(AnyClickableItem clickableElement, AnyAction action);
}