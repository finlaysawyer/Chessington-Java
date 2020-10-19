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

        if (nextSquareClear(from, board, 1)) {
            Move moveOne = new Move(from, generateCoords(colour, from, 1));
            moves.add(moveOne);
        }

        if (inStartingPosition(from) && nextSquareClear(from, board, 2)) {
            Move startingMove = new Move(from, generateCoords(colour, from, 2));
            moves.add(startingMove);
        }
        return moves;
    }

    private boolean inStartingPosition(Coordinates coords) {
        if (coords.getRow() == 1 && colour.equals(PlayerColour.BLACK)) return true;
        return coords.getRow() == 6 && colour.equals(PlayerColour.WHITE);
    }

    private boolean nextSquareClear(Coordinates coords, Board board, int difference) {
        if (colour.equals(PlayerColour.BLACK)) {
            if (coords.getRow() == 7 || board.get(coords.plus(difference, 0)) != null) {
                return false;
            }
        }
        if (colour.equals(PlayerColour.WHITE)) {
            if (coords.getRow() == 0 || board.get(coords.plus(-difference, 0)) != null) {
                return false;
            }
        }
        return true;
    }

    private Coordinates generateCoords(PlayerColour colour, Coordinates coords, int difference) {
        if (colour.equals(PlayerColour.BLACK)) {
            return new Coordinates(coords.getRow() + difference, coords.getCol());
        } else {
            return new Coordinates(coords.getRow() - difference, coords.getCol());
        }
    }
}
