package piece.utils;

import java.util.stream.Collectors;

import board.Chessboard;
import pieces.Piece;

/**
 * A piece utility class.
 *
 */
public final class ControlsUtility {

    private ControlsUtility() {
    }

    /**
     * 
     * @param piece the piece you are calculating the possible positions.
     * @param position the position you are checking.
     * @param board the current board.
     * @return true if the position in occupied by an enemy, false otherwise.
     */
    public static boolean checkEnemy(final Piece piece, final Position position, final Chessboard board) {
        final Color s = board.getAllPieces().stream()
                .filter(x -> x.getPosition().equals(position))
                .map(x -> x.getColor())
                .findFirst().get();
        return board.getAllPieces().stream()
                .filter(x -> !piece.getColor().equals(s))
                .map(Piece::getPosition)
                .collect(Collectors.toList())
                .contains(position);
    }

    /**
     * 
     * @param piece the piece you are calculating the possible positions.
     * @param position the position you are checking.
     * @param board the current board.
     * @return true if there is a piece in the specified position, false otherwise.
     */
    public static boolean checkPiece(final Piece piece, final Position position, final Chessboard board) {
        return board.getAllPieces().stream().map(Piece::getPosition).collect(Collectors.toList()).contains(position);
    }

    /**
     * 
     * @param piece the piece you are calculating the possible positions.
     * @param position the position you are checking.
     * @return true if the position is in the board, false otherwise.
     */
    public static boolean checkPosition(final Piece piece, final Position position) {
        return position.getX() < 8 && position.getX() >= 0 
                && position.getY() < 8 && position.getY() >= 0;
    }

    /**
     * 
     * @param piece the piece you are calculating the possible positions.
     * @param direction the directions the piece can go to.
     * @param multiplier position multiplier.
     * @return the new position.
     */
    public static Position getNewPosition(final Piece piece, final Position direction, final int multiplier) {
        return new Position(piece.getPosition().getX() + (direction.getX() * multiplier),
                piece.getPosition().getY() + (direction.getY() * multiplier));
    }
}