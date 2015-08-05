package snakewars.samplebot.dtos;

import java.util.List;

public class SnakeDTO {

    private String id;
    private List<PointDTO> cells;
    private PointDTO head;
    private boolean isAlive;
    private SnakeDirection direction;
    private int score;
    private int weight;
    private int maxWeight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PointDTO> getCells() {
        return cells;
    }

    public void setCells(List<PointDTO> cells) {
        this.cells = cells;
    }

    public PointDTO getHead() {
        return head;
    }

    public void setHead(PointDTO head) {
        this.head = head;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
