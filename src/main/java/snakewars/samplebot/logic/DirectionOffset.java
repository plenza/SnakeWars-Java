package snakewars.samplebot.logic;

import snakewars.samplebot.dtos.SnakeDirection;

public class DirectionOffset {
    public Offset Offset;
    public SnakeDirection SnakeDirection;

    public DirectionOffset(snakewars.samplebot.logic.Offset offset, snakewars.samplebot.dtos.SnakeDirection snakeDirection) {
        Offset = offset;
        SnakeDirection = snakeDirection;
    }
}
