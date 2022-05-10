public class Cells {


    public void setUpCells(Board board){
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                int randomNumber = (int) (Math.random() * 3);
                if(randomNumber == 0){
                    board.set(r,c,1);
                }
            }
        }
    }

    public void calculateNewCells(Board board, Board newBoard){
        for (int r = 0; r < board.getRows() ; r++) {
            for (int c = 0; c < board.getCols(); c++) {
                if (board.get(r, c) == 1 && countCellNeigbors(r, c, board) < 2) {
                    newBoard.set(r, c, 0);
                } else if (board.get(r, c) == 1 && countCellNeigbors(r, c, board) < 4) {
                    newBoard.set(r, c, 1);
                } else if (board.get(r, c) == 1 && countCellNeigbors(r, c, board) > 3) {
                    newBoard.set(r, c, 0);
                } else if (board.get(r, c) == 0 && countCellNeigbors(r, c, board) == 3) {
                    newBoard.set(r, c, 1);
                } else {
                    newBoard.set(r, c, 0);
                }
            }
        }
    }

    public int countCellNeigbors(int row, int col, Board board){
        int count = 0;
        for (int r = row - 1; r <= row +1; r++){
            for (int c = col - 1; c <= col +1; c++) {
                if(r >= 0 && r < board.getRows() &&
                        c >= 0 && c < board.getCols() &&
                            !(r == row && c == col) &&
                                board.get(r, c) == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public void transferNewCells(Board board, Board newBoard){
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols() ; c++) {
                board.set(r, c, newBoard.get(r, c));
            }
        }
    }

    public void cellSpeed(int GAME_SPEED){
        try {
            Thread.sleep(GAME_SPEED);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
