public class Board {

    int[][] b;

    public Board(int rows, int columns){

        b = new int[rows][columns];
    }

    public int get(int row, int col){

        return b[row][col];
    }

    public void set(int row, int col, int value){

        b[row][col] = value;
    }

    public int getRows(){

        return b.length;
    }

    public int getCols(){

        return b[0].length;
    }

    public static void displayBoard(Board board){
        System.out.println("________");
        for (int r = 0; r < board.getRows(); r++) {
            String frame = "|";
            for (int c = 0; c < board.getCols(); c++) {
                if(board.get(r,c) == 0){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
            System.out.println(frame);
        }
        System.out.println("________");
    }

    @Override
    public String toString(){
        String result = "";
        for (int r = 0; r < getRows(); r++) {
            for (int c = 0; c < getCols(); c++) {
                result += b[r][c];
            }
            result += "\n";
        }
        return result;
    }

}
