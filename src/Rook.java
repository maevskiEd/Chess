public class Rook extends ChessPiece {
    public Rook(String color) {
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
            if (((iDeltaX == 0 && iDeltaY != 0) || (iDeltaX != 0 && iDeltaY == 0))
                    && checkPath(chessBoard, line, column, toLine, toColumn)
                    && (chessBoard.board[toLine][toColumn] == null
                    || (chessBoard.board[toLine][toColumn] != null && !equalsColor(chessBoard, toLine, toColumn)))) return true;
            else return false;
        } else return false;
    }

    @Override
    String getSymbol() {
        return "R";
    }

    boolean checkPath(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int iDeltaX = Math.abs(toColumn - column);
        int iDeltaY = Math.abs(toLine - line);
        int iter = iDeltaX + iDeltaY;
        int vektorX = (toColumn - column) / iter;
        int vektorY = (toLine - line) / iter;

        if ((iDeltaX == 0 && iDeltaY == 1) || (iDeltaX == 1 && iDeltaY == 0)) return true;
        for (int i = 1; i < iter; i++) {
            if (chessBoard.board[line + i * vektorY][column + i * vektorX] != null) return false;
        }
        return true;
    }
}