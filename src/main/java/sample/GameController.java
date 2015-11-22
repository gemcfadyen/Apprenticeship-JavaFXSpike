package sample;

public class GameController {

    private final Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public int getPlayerIndex() {
        return game.currentPlayersIndex();
    }

    public String gameStatus() {
        return game.getStatus();
    }

    public String updateGrid(String zeroBasedIndex) {
        int playerIndex = getPlayerIndex();
        String symbol;
        if (playerIndex == 0) {
            symbol = "X";
        } else {
            symbol = "O";
        }
        game.updateAt(zeroBasedIndex, symbol);
        return symbol;
    }

    public String getGameType() {
        return "Human vs Human";
    }
}
