package sample;

public class Game {
    private int playerIndex = 0;
    private int numberOfTurns = 0;

    public int currentPlayersIndex() {
        int originalPlayerIndex = playerIndex;
        if(playerIndex == 0) {
            playerIndex = 1;
        } else {
            playerIndex = 0;
        }
        return originalPlayerIndex;
    }

    public void updateAt(String cellIndex, String symbol) {
        numberOfTurns++;
        System.out.println("Game received message from Gui");
        System.out.println("Symbol " + symbol + " placed at index " + cellIndex);
    }

    public String getStatus() {
        if(numberOfTurns == 3) {
            return "GAME OVER";
        }
        return "Continue...";
    }
}
