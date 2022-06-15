package ru.nsu.yadrishnikova.task_2_3_1.model;

public class Obstacle extends Collidable {

    public Obstacle(Tile tile) {
        super(tile);
    }

    @Override
    public void onCollision(Snake snake) {
        snake.die();
    }

}
