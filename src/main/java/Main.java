public class Main {

    public static void main(String[] args) {
        final int ROWS = 10;
        final int COLS = 20;
        final int GAME_SPEED = 1000;


        Board board = new Board(ROWS, COLS);
        Board newBoard = new Board(ROWS, COLS);
        Cells cells = new Cells();
        cells.setUpCells(board);
        for (int i = 0; i < 10; i++) {
            Board.displayBoard(board);
            cells.cellSpeed(GAME_SPEED);
            cells.calculateNewCells(board, newBoard);
            cells.transferNewCells(board, newBoard);
        }
    }
}
