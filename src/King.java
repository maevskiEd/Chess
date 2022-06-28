public class King extends ChessPiece {
    public King(String color) {
        super(color);
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
            if (((iDeltaX == 0 && Math.abs(iDeltaY) == 1) || (Math.abs(iDeltaX) == 1 && iDeltaY == 0)
                    || (Math.abs(iDeltaX) == 1 && Math.abs(iDeltaY) == 1))
                    && (chessBoard.board[toLine][toColumn] == null
                    || (chessBoard.board[toLine][toColumn] != null && !equalsColor(chessBoard, toLine, toColumn))))
                return true;
            else return false;
        } else return false;
    }

    @Override
    String getSymbol() {
        return "K";
    }

    boolean isUnderAttack(ChessBoard board, int line, int column) {
        if (isInField(board, line, column)) {
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    if (board.board[i][j] != null && !equalsColor(board, i, j)
                            && board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        if (board.board[i][j].getSymbol().equals("P") && j == column) return false;
                        else return true;
                    }
                }
            }
        }
        return false;
    }
}
