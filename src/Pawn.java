public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    public static void main(String[] args) {
        Pawn p = new Pawn("White");
        ChessBoard c = new ChessBoard("Player");
        System.out.println(p.canMoveToPosition(c, 1, 1, 2, 1));
        System.out.println(p.canMoveToPosition(c, 1, 1, 3, 1));
        System.out.println(p.canMoveToPosition(c, 2, 2, 3, 1));
        System.out.println(p.canMoveToPosition(c, 2, 2, 3, 2));
        System.out.println(p.canMoveToPosition(c, 2, 2, 3, 3));
        System.out.println(p.canMoveToPosition(c, 2, 2, 4, 2));
        System.out.println(p.canMoveToPosition(c, 2, 2, 5, 2));
        System.out.println(p.canMoveToPosition(c, 2, 2, 2, 2));
        System.out.println(p.canMoveToPosition(c, 2, 2, 3, 4));
        Pawn pBlack = new Pawn("Black");
        System.out.println("Black");
        System.out.println(pBlack.canMoveToPosition(c, 6, 1, 5, 1));
        System.out.println(pBlack.canMoveToPosition(c, 6, 1, 4, 1));
        System.out.println(pBlack.canMoveToPosition(c, 6, 1, 4, 2));
        System.out.println(pBlack.canMoveToPosition(c, 6, 1, 5, 2));
        System.out.println(pBlack.canMoveToPosition(c, 6, 1, 5, 1));
        System.out.println(pBlack.canMoveToPosition(c, 6, 2, 5, 1));
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
