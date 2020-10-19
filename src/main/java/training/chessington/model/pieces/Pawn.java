package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> moves = new ArrayList<>();

        if (colour.equals(PlayerColour.BLACK)) {
            if (inStartingPosition(from)) {
                Move whiteMoveTwo = new Move(from, from.plus(2, 0));
                moves.add(whiteMoveTwo);
            }

            Move whiteMove = new Move(from, from.plus(1, 0));
            moves.add(whiteMove);

        } else {
            if (inStartingPosition(from)) {
                Move blackMoveTwo = new Move(from, from.plus(-2, 0));
                moves.add(blackMoveTwo);
            }

            Move blackMove = new Move(from, from.plus(-1, 0));
            moves.add(blackMove);
        }

        return moves;
    }

    private boolean inStartingPosition(Coordinates coords) {
        if (coords.getRow() == 1 && colour.equals(PlayerColour.BLACK)) return true;
        return coords.getRow() == 6 && colour.equals(PlayerColour.WHITE);
    }
}
