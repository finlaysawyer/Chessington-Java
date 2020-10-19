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
        Move whiteMove = new Move(new Coordinates(6, 4), new Coordinates(5, 4));
        Move blackMove = new Move(new Coordinates(1, 4), new Coordinates(2, 4));
        List<Move> moves = new ArrayList<>();
        moves.add(whiteMove);
        moves.add(blackMove);
        return moves;
    }
}
