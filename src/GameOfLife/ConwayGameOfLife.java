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