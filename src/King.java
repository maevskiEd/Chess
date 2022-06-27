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

        if (!isRunningInPlace(iDeltaX, iDeltaY) && chessBoard.checkPos(toLine)
                && chessBoard.checkPos(toColumn)) {
            if ((iDeltaX == 0 && iDeltaY == 1) || (iDeltaX == 1 && iDeltaY == 0)
                    || (Math.abs(iDeltaX) == 1 && Math.abs(iDeltaY) == 1)) return true;
            else return false;
        } else return false;
    }

    @Override
    String getSymbol() {
        return "K";
    }

    boolean isUnderAttack(ChessBoard board, int line, int column){
        return true;
    }
}
