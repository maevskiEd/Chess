abstract public class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract public String getColor();

    abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    abstract String getSymbol();

    boolean isRunningInPlace(int line, int column, int toLine, int toColumn) {
        return line == toLine && column == toColumn;
    }

    boolean isRunningInPlace(int deltaX, int deltaY) {
        return deltaX == 0 && deltaY == 0;
    }
}
