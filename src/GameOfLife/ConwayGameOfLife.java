package GameOfLife;

public class ConwayGameOfLife {
    private int mBoardDimension;
    private String[][] mBoard;

    public static void main(String[] args) {
        System.out.println("Hello World");
        ConwayGameOfLife game = new ConwayGameOfLife();
    }

    public ConwayGameOfLife() {
        mBoardDimension = 3;
        mBoard = new String[mBoardDimension][mBoardDimension];
        mBoard[0][1] = "X";
        mBoard[1][1] = "X";
        mBoard[2][1] = "X";
        printBoard();
    }

    public void evolveBoard() {
    }

    private boolean evolveSquare(int column, int row) {
        int aliveNeighbors = computeAliveNeighbors(column, row);
        if (squareIsAlive(column, row)) {
            if (aliveNeighbors < 2) {
                return false;
            } else if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                return true;
            } else if (aliveNeighbors > 3) {
                return false;
            }
        } else {
            if (aliveNeighbors == 3) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean squareIsAlive(int column, int row) {
        if (mBoard[column][row] == null) {
            return false;
        } else {
            return true;
        }
    }
    
    /** 
     * Computes the number of neighbors that are alive.
     */
    private int computeAliveNeighbors(int column, int row) {
        int aliveNeighbors = 0;
        if ((column+1 < mBoardDimension) &&
            (squareIsAlive(column+1,row) != null)) {
            aliveNeighbors++;
        } 
        if ((column + 1 < mBoardDimension) &&
            (row + 1 < mBoardDimension) &&
            (squareIsAlive(column+1,row+1) != null)) {
            aliveNeighbors++;
        }
        if ((column + 1 < mBoardDimension) &&
            (row - 1 >= 0) &&
            (squareIsAlive(column+1,row-1) != null)) {
            aliveNeighbors++;
        }
        if ((row - 1 >= 0) &&
            (mBoard[column][row - 1] != null)) {
            aliveNeighbors++;
        }
        if ((row + 1 < mBoardDimension) &&
            (mBoard[column][row - 1] != null)) {
            aliveNeighbors++;
        }
        if ((column - 1 >= 0) &&
            (mBoard[column - 1][row] != null)) {
            aliveNeighbors++;
        }
        if ((column - 1 >= 0) &&
            (row - 1 >= 0) &&
            (mBoard[column - 1][row - 1] != null)) {
            aliveNeighbors++;
        }
        if ((column - 1 >= 0) &&
            (row + 1 >= 0) &&
            (mBoard[column - 1][row + 1] != null)) {
            aliveNeighbors++;
        }
        return aliveNeighbors;
    }

    public void printBoard() {
        for (int row = 0; row < mBoardDimension; row++) {
            for (int column = 0; column < mBoardDimension; column++) {
                System.out.print("_ ");
            }
            System.out.println("");
            for (int column = 0; column < mBoardDimension; column++) {
                if (mBoard[column][row] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(mBoard[column][row]);
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
        for (int column = 0; column < mBoardDimension; column++) {
            System.out.print("_ ");
        }
    }

    public int add(int x, int y) {
        return x + y;
    }
}