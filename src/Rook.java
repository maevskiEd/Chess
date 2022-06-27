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

        if (!isRunningInPlace(iDeltaX, iDeltaY) && chessBoard.checkPos(toLine)
                && chessBoard.checkPos(toColumn)) {
            if ((iDeltaX == 0 && iDeltaY != 0) || (iDeltaX != 0 && iDeltaY == 0)) return true;
            else return false;
        } else return false;
    }

    @Override
    String getSymbol() {
        return "R";
    }
}


