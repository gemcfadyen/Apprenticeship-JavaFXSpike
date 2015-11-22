package sample;

public interface AnyButton {

    void setClickAction(AnyAction clickAction);
    void setAsDisabled();
    void setButtonText(String text);
    String getButtonId();
}

interface AnyAction {
    void actionEvent();
}


interface GameStatus {
    void setStatus(String status);
}