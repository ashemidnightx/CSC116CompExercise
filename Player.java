// Player.java
public class Player {
    private char symbol;
    private int piecesPlaced;
    private int maxConnected;

    public Player(char symbol) {
        this.symbol = symbol;
        this.piecesPlaced = 0;
        this.maxConnected = 0;
    }

    public char getSymbol() {
        return symbol;
    }

    public void incrementPiecesPlaced() {
        piecesPlaced++;
    }

    public int getPiecesPlaced() {
        return piecesPlaced;
    }

    public void updateMaxConnected(int connected) {
        if (connected > maxConnected) {
            maxConnected = connected;
        }
    }

    public int getMaxConnected() {
        return maxConnected;
    }

    public void resetMaxConnected() {
        maxConnected = 0;
    }
}