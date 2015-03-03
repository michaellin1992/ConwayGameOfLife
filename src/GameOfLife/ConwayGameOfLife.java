package GameOfLife;

import java.util.ArrayList;

public class ConwayGameOfLife {
    private int mBoardDimension;
    private String[][] mBoard;

    public static void main(String[] args) {
        int boardDimension = Integer.parseInt(args[0]);
        int iterations = Integer.parseInt(args[1]);
        String startingBlocks = args[2];
        String[] splitCoordinates = startingBlocks.split(":");
        ArrayList<Integer[]> startPosition = new ArrayList<Integer[]>();
        for (String onePoint : splitCoordinates) {
            String[] coordinate = onePoint.split(",");
            Integer[] xyCoordinates = new Integer[2];
            xyCoordinates[0] = Integer.parseInt(coordinate[0]);
            xyCoordinates[1] = Integer.parseInt(coordinate[1]);
            startPosition.add(xyCoordinates);
        }
        ConwayGameOfLife game = new ConwayGameOfLife(boardDimension, iterations, startPosition);
    }

    public ConwayGameOfLife(int boardDimension, int iterations, ArrayList<Integer[]> startPosition) {
        mBoardDimension = boardDimension;
        mBoard = new String[mBoardDimension][mBoardDimension];
        populateBoard(startPosition);
        printBoard();
        evolveBoard(iterations);
    }

    public void evolveBoard(int iterations) {
        while (iterations != 0) {
            String[][] newBoard = new String[mBoardDimension][mBoardDimension];
            for (int column = 0; column < mBoardDimension; column++) {
                for (int row = 0; row < mBoardDimension; row++) {
                    if (shouldEvolveSquare(column, row)) {
                        newBoard[column][row] = "X";
                    }
                }
            }
            iterations--;
            mBoard = newBoard;
            printBoard();
        }
    }

    private void mark(int column, int row) {
        mBoard[column][row] = "X";
    }
    
    private void populateBoard(ArrayList<Integer[]> startPosition) {
        for (Integer[] startingBlock : startPosition) {
            mark(startingBlock[0], startingBlock[1]);
        }
    }

    private boolean shouldEvolveSquare(int column, int row) {
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
            }
        }
        return false;
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
            (squareIsAlive(column+1,row) )) {
            aliveNeighbors++;
        } 
        if ((column + 1 < mBoardDimension) &&
            (row + 1 < mBoardDimension) &&
            (squareIsAlive(column+1,row+1) )) {
            aliveNeighbors++;
        }
        if ((column + 1 < mBoardDimension) &&
            (row - 1 >= 0) &&
            (squareIsAlive(column+1,row-1) )) {
            aliveNeighbors++;
        }
        if ((row - 1 >= 0) &&
            (squareIsAlive(column, row-1))) {
            aliveNeighbors++;
        }
        if ((row + 1 < mBoardDimension) &&
            (squareIsAlive(column, row+1))) {
            aliveNeighbors++;
        }
        if ((column - 1 >= 0) &&
            (squareIsAlive(column - 1, row))) {
            aliveNeighbors++;
        }
        if ((column - 1 >= 0) &&
            (row - 1 >= 0) &&
            (squareIsAlive(column - 1, row - 1))) {
            aliveNeighbors++;
        }
        if ((column - 1 >= 0) &&
            (row + 1 < mBoardDimension) &&
            (squareIsAlive(column - 1, row + 1))) {
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
        System.out.println("");
        System.out.println("");
    }

    public int add(int x, int y) {
        return x + y;
    }
}