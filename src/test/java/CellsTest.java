import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CellsTest {

    private Board board;
    private Board newBoard;


    @Test
    public void CellsWithOneNeighborDies() {
        board = new Board(6, 8);
        newBoard = new Board(6, 8);
        Cells cells = new Cells();
        cells.setUpCells(board);
        board.set(0,0,1);
        board.set(0,1,0);
        board.set(1,1,0);
        board.set(1,0,0);
        for (int i = 0; i < 1; i++) {
            cells.calculateNewCells(board,newBoard);
            cells.transferNewCells(board, newBoard);
        }
        assertTrue(board.get(0,0) == 0);
    }

    @Test
    public void CellsWithTwoNeighborslives() {
        board = new Board(6, 8);
        newBoard = new Board(6, 8);
        Cells cells = new Cells();
        cells.setUpCells(board);
        board.set(0,0,1);
        board.set(0,1,1);
        board.set(1,1,1);
        board.set(1,0,0);
        for (int i = 0; i < 1; i++) {
            cells.calculateNewCells(board,newBoard);
            cells.transferNewCells(board, newBoard);
        }
        assertTrue(board.get(0,0) == 1);
    }

    @Test
    public void NoCellsOutsideBoard(){
        board = new Board(6, 8);
        try {
            board.set(-1, 0, 1);
            board.set(7, 0, 1);
            board.set(0, -9, 1);
            board.set(0, 9, 1);
        } catch (Exception e){
            assertNotNull(e);
        }
    }
}
