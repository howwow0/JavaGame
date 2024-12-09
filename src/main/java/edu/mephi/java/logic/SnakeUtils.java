package edu.mephi.java.logic;

import edu.mephi.java.engine.ArrayObservableDeque;

import java.awt.*;
import java.util.Deque;

public class SnakeUtils {

    public static void AddPartToSnake(ArrayObservableDeque<Snake.SnakePart> points, Direction direction) {
        Snake.SnakePart last = points.getLast();
        last.setColor(Snake.BODY_COLOR);
        Point lastPoint = last.getPoint();
        int dirX = (direction == Direction.LEFT) ? -1 : ((direction == Direction.RIGHT) ? 1 : 0);
        int dirY = (direction == Direction.UP) ? -1 : ((direction == Direction.DOWN) ? 1 : 0);
        points.addLast(new Snake.SnakePart(lastPoint.x + dirX, lastPoint.y + dirY, Snake.HEAD_COLOR));
    }
}
