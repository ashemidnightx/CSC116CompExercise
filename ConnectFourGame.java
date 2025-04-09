import java.util.Scanner;

/**
* The Connect Four Game which iterates through each player
*
* @author Bayley Schaefer
*/
public class ConnectFourGame {

    /** The max number of pieces on the board */
    public static final int MAX_PIECES = 64;

    /** The Game board */
    private GameBoard board;

    /** The player X */
    private Player playerX;

    /** The player O */
    private Player playerO;

    /** Total moves done by both players */
    private int totalMoves;

    /** If the game is over */
    private boolean gameOver;

    /**
    * Constructor of the class
    * Initializes all instance variables
    */
    public ConnectFourGame() {
        this.board = new GameBoard();
        this.playerX = new Player('X');
        this.playerO = new Player('O');
        this.totalMoves = 0;
        this.gameOver = false;
    }

    /**
    * Scans through user input to play game
    */
    public void playGame() {
        Scanner in = new Scanner(System.in);
        Player currentPlayer = playerX;

        while (!gameOver && totalMoves != MAX_PIECES) {
            board.display();
            System.out.println("Player " + currentPlayer.getSymbol() + " choose a column (1-8)");
            System.out.println("Current max connections:");
            System.out.println("X: " + playerX.getMaxConnected());
            System.out.println("O: " + playerO.getMaxConnected());

            int column = in.nextInt();
            while (!board.validateColumn(column)) {
                System.out.println("Invalid column. Choose a column between 1-8");
                column = in.nextInt();
            }

            while (!board.placePiece(column, currentPlayer.getSymbol())) {
                System.out.println("Column " + column + " is full. Pick another column!");
                column = in.nextInt();
            }

            currentPlayer.incrementPiecesPlaced();
            totalMoves++;

            // Update max connections for both players after each move
            int currentXConnections = board.checkConnections('X');
            playerX.updateMaxConnected(currentXConnections);
            
            int currentOConnections = board.checkConnections('O');
            playerO.updateMaxConnected(currentOConnections);

            if (board.isWinner(currentPlayer.getSymbol())) {
                board.display();
                System.out.println("WINNER (" + currentPlayer.getSymbol() + ")!!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
            }

            System.out.println("Pieces Placed (X): " + playerX.getPiecesPlaced());
            System.out.println("Pieces Placed (O): " + playerO.getPiecesPlaced());
        }

        if (totalMoves == MAX_PIECES && !gameOver) {
            System.out.println("Game ended in a draw!");
        }

        System.out.println("Final max connections:");
        System.out.println("X: " + playerX.getMaxConnected());
        System.out.println("O: " + playerO.getMaxConnected());

        in.close();
    }

    /**
    * Plays the Connect Four game
    * @param command-line args not used
    */
    public static void main(String[] args) {
        ConnectFourGame game = new ConnectFourGame();
        game.playGame();
    }
}
