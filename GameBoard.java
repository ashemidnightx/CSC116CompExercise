/**
* The creation of the game board
*
* @author Bayley Schaefer
* @author Vanitas Smith-Debnam
*/
public class GameBoard {

    /** The max length of a column/ row */
    public static final int MAX_LENGTH = 8;

    /** The number of connected pieces needed to win */
    public static final int MAX_CONNECT = 4;

    /** The Connect Four grid */
    private char[][] grid;

    /** Initalizes the grid */
    public GameBoard() {
        this.grid = new char[MAX_LENGTH][MAX_LENGTH];
        initializeGrid();
    }

   /**
   * Initializes the grid with spaces for each box
   */
    private void initializeGrid() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = ' ';
            }
        }
    }

    /**
    * Prints the grid
    */
    public void display() {
        System.out.println(" 1 2 3 4 5 6 7 8 ");
        System.out.println("-----------------");
        for (int row = 0; row < grid.length; row++) {
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("-----------------");
        }
        System.out.println(" 1 2 3 4 5 6 7 8 ");
        System.out.println();
    }

    /**
    * Places a player (X/O) into the bottommost open space of a column
    *
    * @return true if the piece was successfully placed
    */
    public boolean placePiece(int column, char player) {
        column--;
        for (int i = grid[0].length - 1; i >= 0; i--) {
            if (grid[i][column] == ' ') {
                grid[i][column] = player;
                return true;
            }
        }
        return false;
    }

    /**
    * Checks if column is positive and less than 9
    *
    * @return true if column is valud
    */
    public boolean validateColumn(int column) {
        return column > 0 && column <= grid[0].length;
    }

    /**
    * Checks if the player won (has 4 connected pieces)
    */
    public boolean isWinner(char player) {
        return checkConnections(player) >= MAX_CONNECT;
    }

    /**
    * Checks for the highest number of connections
    *
    * @param player that is going
    * @return the maximum number of connections
    */
    public int checkConnections(char player) {
        int maxConnection = 0;
        maxConnection = Math.max(maxConnection, checkHorizontal(player));
        maxConnection = Math.max(maxConnection, checkVertical(player));
        maxConnection = Math.max(maxConnection, checkUpwardDiagonal(player));
        maxConnection = Math.max(maxConnection, checkDownwardDiagonal(player));
        return maxConnection;
    }

    /**
    * Checks if the player won horizontally
    *
    * @param player that is going
    * @return maximumConnected max number of connected pieces
    */
    private int checkHorizontal(char player) {
        int maxConnected = 0;
        for (int row = 0; row < grid.length; row++) {
            int currentConnected = 0;
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == player) {
                    currentConnected++;
                    maxConnected = Math.max(maxConnected, currentConnected);
                } else {
                    currentConnected = 0;
                }
            }
        }
        return maxConnected;
    }

    /**
    * Checks if the player won vertically
    *
    * @param player that is going
    * @return maximumConnected max number of connected pieces
    */
    private int checkVertical(char player) {
        int maxConnected = 0;
        for (int col = 0; col < grid[0].length; col++) {
            int currentConnected = 0;
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == player) {
                    currentConnected++;
                    maxConnected = Math.max(maxConnected, currentConnected);
                } else {
                    currentConnected = 0;
                }
            }
        }
        return maxConnected;
    }

    /**
    * Checks if the player won upward diagonally
    *
    * @param player that is going
    * @return maximumConnected max number of connected pieces
    */
    private int checkUpwardDiagonal(char player) {
        int maxConnected = 0;
        // Check diagonals from bottom-left to top-right
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int currentConnected = 0;
                for (int i = 0; row - i >= 0 && col + i < grid[0].length; i++) {
                    if (grid[row - i][col + i] == player) {
                        currentConnected++;
                        maxConnected = Math.max(maxConnected, currentConnected);
                    } else {
                        currentConnected = 0;
                    }
                }
            }
        }
        return maxConnected;
    }

    /**
    * Checks if the player won horizontally
    *
    * @param player that is going
    * @return maximumConnected max number of connected pieces
    */
    private int checkDownwardDiagonal(char player) {
        int maxConnected = 0;
        // Check diagonals from top-left to bottom-right
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int currentConnected = 0;
                for (int i = 0; row + i < grid.length && col + i < grid[0].length; i++) {
                    if (grid[row + i][col + i] == player) {
                        currentConnected++;
                        maxConnected = Math.max(maxConnected, currentConnected);
                    } else {
                        currentConnected = 0;
                    }
                }
            }
        }
        return maxConnected;
    }
}
