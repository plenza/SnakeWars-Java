package snakewars.samplebot.logic;

import snakewars.samplebot.GameBoardState;
import snakewars.samplebot.dtos.PointDTO;
import snakewars.samplebot.dtos.SnakeDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SnakeEngine {

    private final String mySnakeId;
    private final Random random = new Random();

    public SnakeEngine(String mySnakeId) {
        this.mySnakeId = mySnakeId;
    }

    public Move getNextMove(GameBoardState gameBoardState) {
        //===========================
        // Your snake logic goes here
        //===========================

        SnakeDTO mySnake = gameBoardState.getSnake(mySnakeId);
        if (mySnake.isAlive()) {
            Set<PointDTO> occupiedCells = gameBoardState.getOccupiedCells();

            // Check possible moves in random order.
            List<Move> moves = Arrays.asList(Move.LEFT, Move.RIGHT, Move.STRAIGHT);

            while (moves.stream().anyMatch(predicate -> true)) {
                // Select random move.
                Move move = moves.get(random.nextInt(moves.size()));
                moves.remove(move);

                PointDTO newHead = gameBoardState.getSnakeNewHeadPosition(mySnakeId, move);
                if (!occupiedCells.contains(newHead)) {
                    return move;
                }
            }
        }
        return Move.NONE;
    }
}
