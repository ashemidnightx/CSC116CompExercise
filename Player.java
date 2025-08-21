/**
* The Player that is going
*
* @author Bayley Schaefr
* @author Alexis Nguyen
* @author Vanitas Smith-Debnam
*/
public class Player {

    /** The symbol of the player going */
    private char symbol;

    /** The number of pieces placed */
    private int piecesPlaced;

    /** The maximum number of consecutively connected pieces */
    private int maxConnected;

    /** 
    * Constructor of Player class
    *
    * @param symbol of the player going (X/O)
    */
    public Player(char symbol) {
        this.symbol = symbol;
        this.piecesPlaced = 0;
        this.maxConnected = 0;
    }

    /**
    * Gets the symbol of the player going
    * 
    * @return symbol of player going
    */
    public char getSymbol() {
        return symbol;
    }

    /**
    * Increments the number of pieces placed
    */
    public void incrementPiecesPlaced() {
        piecesPlaced++;
    }

    /**
    * Gets the number of pieces placed
    *
    * @return piecesPlaced Total number of pieces placed
    */
    public int getPiecesPlaced() {
        return piecesPlaced;
    }

    /**
    * Updates the max number of consecutive connections
    *
    * @param connected the maximumn connected before
    */
    public void updateMaxConnected(int connected) {
        if (connected > maxConnected) {
            maxConnected = connected;
        }
    }

    /**
    * Gets the maximum number of consecutive connections
    * 
    * @return maxConnected maximum number of consecutive connections
    */
    public int getMaxConnected() {
        return maxConnected;
    }

    /**
    * Sets maximum number of connected to 0
    *
    * @returns maxConnected the maximum number of consecutive connections
    */
    public void resetMaxConnected() {
        maxConnected = 0;
    }
}

