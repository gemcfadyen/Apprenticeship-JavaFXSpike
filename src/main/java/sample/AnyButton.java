package sample;


interface AnyClickableItem {
    void setClickAction(AnyAction clickAction);
    void setText(String text);
    String getId();
    void setAsDisabled();
}

interface AnyAction {
    void actionEvent();
}

interface GameStatus {
    void setStatus(String status);
}