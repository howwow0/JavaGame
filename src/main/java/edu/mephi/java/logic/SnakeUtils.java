package edu.mephi.java.logic;

import edu.mephi.java.Game;
import edu.mephi.java.engine.ArrayObservableDeque;

import java.awt.*;
import java.util.List;


public class SnakeUtils {

    public static void AddPartToSnake(ArrayObservableDeque<Snake.SnakePart> points, Direction direction) {
        Snake.SnakePart last = points.getLast();
        last.setColor(Snake.BODY_COLOR);
        Point newPoint = getPointFromDirection(last.getPoint(), direction);
        points.addLast(new Snake.SnakePart(newPoint.x, newPoint.y, Snake.HEAD_COLOR));
    }

    public static boolean hasNextPointApple(Snake.SnakePart head, Apple apple, Direction direction) {
        return getPointFromDirection(head.getPoint(), direction).equals(apple.getPoint());
    }

    public static boolean hasNextPointWallOrSnakePart(Snake.SnakePart head, List<Snake.SnakePart> points, Direction direction) {
        Point nextPoint = getPointFromDirection(head.getPoint(), direction);
        return nextPoint.x<= -1 || nextPoint.x>= Game.WIDTH || nextPoint.y<= -1 || nextPoint.y>= Game.HEIGHT || points.stream().anyMatch((p-> p.getPoint().equals(nextPoint))) ;
    }

    private static Point getPointFromDirection(Point point, Direction direction) {
        int dirX = (direction == Direction.LEFT) ? -1 : ((direction == Direction.RIGHT) ? 1 : 0);
        int dirY = (direction == Direction.UP) ? -1 : ((direction == Direction.DOWN) ? 1 : 0);
        return new Point(point.x + dirX, point.y + dirY);
    }
}
