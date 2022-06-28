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

    boolean isInField(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        return chessBoard.checkPos(line) && chessBoard.checkPos(column) && chessBoard.checkPos(toLine)
                && chessBoard.checkPos(toColumn);
    }
    boolean isInField(ChessBoard chessBoard, int line, int column){
        return chessBoard.checkPos(line) && chessBoard.checkPos(column);
    }

    boolean equalsColor(ChessBoard chessBoard, int line, int column){
        return chessBoard.nowPlayerColor().equals(chessBoard.board[line][column].getColor());
    }
}
