public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isRunningInPlace(line, column, toLine, toColumn) && isInField(chessBoard, line, column, toLine, toColumn)
                && chessBoard.board[line][column] != null && equalsColor(chessBoard, line, column)
                && Math.abs(toColumn - column) == Math.abs(toLine - line)) {
            if (checkPath(chessBoard, line, column, toLine, toColumn) && (chessBoard.board[toLine][toColumn] == null
                    || (chessBoard.board[toLine][toColumn] != null && !equalsColor(chessBoard, toLine, toColumn))))
                return true;
            else return false;
        } else return false;
    }

    @Override
    String getSymbol() {
        return "B";
    }

    boolean checkPath(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int iter = Math.abs(toColumn - column);
        int vektorX = (toColumn - column) / iter;
        int vektorY = (toLine - line) / iter;

        if (Math.abs(toColumn - column) == 1 && Math.abs(toLine - line) == 1) return true;
        for (int i = 1; i < iter; i++) {
            if (chessBoard.board[line + i * vektorY][column + i * vektorX] != null) return false;
        }
        return true;
    }
}

