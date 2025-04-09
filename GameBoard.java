// GameBoard.java
public class GameBoard {
    public static final int MAX_LENGTH = 8;
    private char[][] grid;

    public GameBoard() {
        this.grid = new char[MAX_LENGTH][MAX_LENGTH];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = ' ';
            }
        }
    }

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

    public boolean validateColumn(int column) {
        return column > 0 && column <= grid[0].length;
    }

    public boolean isWinner(char player) {
        return checkConnections(player) >= 4;
    }

    public int checkConnections(char player) {
        int maxConnection = 0;
        maxConnection = Math.max(maxConnection, checkHorizontal(player));
        maxConnection = Math.max(maxConnection, checkVertical(player));
        maxConnection = Math.max(maxConnection, checkUpwardDiagonal(player));
        maxConnection = Math.max(maxConnection, checkDownwardDiagonal(player));
        return maxConnection;
    }

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