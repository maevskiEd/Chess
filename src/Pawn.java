public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    public static void main(String[] args) {
        ChessBoard board = new ChessBoard("Black");
        board.board[0][0] = new Rook("White");
        board.board[0][1] = new Horse("White");
        board.board[0][2] = new Bishop("White");
        board.board[0][3] = new Queen("White");
        board.board[0][4] = new King("White");
        board.board[0][5] = new Bishop("White");
        board.board[0][6] = new Horse("White");
        board.board[0][7] = new Rook("White");
        board.board[1][0] = new Pawn("White");
        board.board[1][1] = new Pawn("White");
        board.board[1][2] = new Pawn("White");
        board.board[2][2] = new Pawn("White");
        board.board[1][3] = new Pawn("White");
        board.board[1][4] = new Pawn("White");
        board.board[1][5] = new Pawn("White");
        board.board[1][6] = new Pawn("White");
        board.board[1][7] = new Pawn("White");
        board.board[5][2] = new Pawn("White");

        board.board[7][0] = new Rook("Black");
        board.board[7][1] = new Horse("Black");
        board.board[7][2] = new Bishop("Black");
        board.board[7][3] = new Queen("Black");
        board.board[7][4] = new King("Black");
        board.board[7][5] = new Bishop("Black");
        board.board[7][6] = new Horse("Black");
        board.board[7][7] = new Rook("Black");
        board.board[6][0] = new Pawn("Black");
        board.board[6][1] = new Pawn("Black");
        board.board[6][2] = new Pawn("Black");
        board.board[6][3] = new Pawn("Black");
        board.board[6][4] = new Pawn("Black");
        board.board[6][5] = new Pawn("Black");
        board.board[6][6] = new Pawn("Black");
        board.board[6][7] = new Pawn("Black");
        board.board[3][1] = new Pawn("Black");
        board.board[3][3] = new Pawn("Black");


        System.out.println(board.board[1][1].canMoveToPosition(board, 1, 1, 2, 1));
        System.out.println(board.board[1][1].canMoveToPosition(board, 1, 1, 3, 1));
        System.out.println(board.board[2][2].canMoveToPosition(board, 2, 2, 3, 1));
        System.out.println(board.board[2][2].canMoveToPosition(board, 2, 2, 3, 2));
        System.out.println(board.board[2][2].canMoveToPosition(board, 2, 2, 3, 3));
        System.out.println(board.board[2][2].canMoveToPosition(board, 2, 2, 4, 2));
        System.out.println(board.board[2][2].canMoveToPosition(board, 2, 2, 5, 2));
        System.out.println(board.board[2][2].canMoveToPosition(board, 2, 2, 2, 2));
        System.out.println(board.board[2][2].canMoveToPosition(board, 2, 2, 3, 4));

        System.out.println("Black");
        System.out.println(board.board[6][1].canMoveToPosition(board, 6, 1, 5, 1));
        System.out.println(board.board[6][1].canMoveToPosition(board, 6, 1, 4, 1));
        System.out.println(board.board[6][1].canMoveToPosition(board, 6, 1, 4, 2));
        System.out.println(board.board[6][1].canMoveToPosition(board, 6, 1, 5, 2));
        System.out.println(board.board[6][1].canMoveToPosition(board, 6, 2, 5, 2));
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int iDeltaX = toColumn - column;
        int iDeltaY = toLine - line;

        if (!isRunningInPlace(iDeltaX, iDeltaY) && isInField(chessBoard, line, column, toLine, toColumn)
                && chessBoard.board[line][column] != null && equalsColor(chessBoard, line, column)) {
            if ((isSecondLine(line) && Math.abs(iDeltaY) == 2 && iDeltaX == 0
                    && chessBoard.board[line + (chessBoard.nowPlayerColor().equals("White") ? 1 : -1)][column] == null
                    && chessBoard.board[toLine][toColumn] == null) || (Math.abs(iDeltaY) == 1 && iDeltaX == 0
                    && chessBoard.board[toLine][toColumn] == null)) return true;
            if (iDeltaY == (chessBoard.nowPlayerColor().equals("White") ? 1 : -1) && Math.abs(iDeltaX) == 1
                    && chessBoard.board[toLine][toColumn] != null && !equalsColor(chessBoard, toLine, toColumn))
                return true;
            return false;
        } else return false;
    }

    @Override
    String getSymbol() {
        return "P";
    }

    boolean isSecondLine(int line) {
        return (color.equals("White") && line == 1) || (color.equals("Black") && line == 6);
    }
}
