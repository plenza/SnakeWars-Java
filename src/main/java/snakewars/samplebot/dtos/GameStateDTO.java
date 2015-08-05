package snakewars.samplebot.dtos;

import java.util.List;

public class GameStateDTO {

    private int turn;
    private List<SnakeDTO> snakes;
    private List<PointDTO> walls;
    private List<PointDTO> food;

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public List<SnakeDTO> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<SnakeDTO> snakes) {
        this.snakes = snakes;
    }

    public List<PointDTO> getWalls() {
        return walls;
    }

    public void setWalls(List<PointDTO> walls) {
        this.walls = walls;
    }

    public List<PointDTO> getFood() {
        return food;
    }

    public void setFood(List<PointDTO> food) {
        this.food = food;
    }

    public SizeDTO getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(SizeDTO boardSize) {
        this.boardSize = boardSize;
    }

    public int getTurnTimeMilliseconds() {
        return turnTimeMilliseconds;
    }

    public void setTurnTimeMilliseconds(int turnTimeMilliseconds) {
        this.turnTimeMilliseconds = turnTimeMilliseconds;
    }

    private SizeDTO boardSize;
    private int turnTimeMilliseconds;
}
