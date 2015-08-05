package snakewars.samplebot.logic;

import snakewars.samplebot.GameBoardState;
import snakewars.samplebot.dtos.PointDTO;
import snakewars.samplebot.dtos.SnakeDTO;

import java.util.*;

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
            List<Move> moves = new LinkedList<>(Arrays.asList(Move.LEFT, Move.RIGHT, Move.STRAIGHT));

            while (moves.stream().anyMatch(predicate -> true)) {
                // Select random move.
                int randomIndex = random.nextInt(moves.size());
                Move move = moves.get(randomIndex);
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
