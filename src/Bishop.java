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
        if (!isRunningInPlace(line, column, toLine, toColumn) && chessBoard.checkPos(toLine)
                && chessBoard.checkPos(toColumn)) {
            if (Math.abs(toColumn - column) == Math.abs(toLine - line)) return true;
            else return false;
        } else return false;
    }

    @Override
    String getSymbol() {
        return "B";
    }
}

