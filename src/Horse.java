public class Horse extends ChessPiece {
    public Horse(String color) {
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
                && ((Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) ||
                (Math.abs(column - toColumn) == 2 && Math.abs(line - toLine) == 1))) {
            if ((chessBoard.board[toLine][toColumn] == null || (chessBoard.board[toLine][toColumn] != null
                    && !equalsColor(chessBoard, toLine, toColumn))))
                return true;
        } else return false;
        return false;
    }

    @Override
    String getSymbol() {
        return "H";
    }
}
