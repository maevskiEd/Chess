public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int iDeltaX = toColumn - column;
        int iDeltaY = deltaY(line, toLine);

        if (!isRunningInPlace(iDeltaX, iDeltaY) && chessBoard.checkPos(toLine)
                && chessBoard.checkPos(toColumn)) {
            if ((isSecondLine(line) && iDeltaY == 2 && iDeltaX == 0)
                    || (iDeltaY == 1 && (iDeltaX == 0 || Math.abs(iDeltaX) == 1))) return true;
            else return false;
        } else return false;
    }

    @Override
    String getSymbol() {
        return "P";
    }

    boolean isSecondLine(int line) {
        return (color.equals("White") && line == 1) || (color.equals("Black") && line == 6);
    }

    int deltaY(int line, int toLine) {
        if (color.equals("White")) return toLine - line;
        else return line - toLine;
    }
}
