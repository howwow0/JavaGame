package edu.mephi.java.logic;
import edu.mephi.java.engine.ArrayObservableDeque;
import edu.mephi.java.engine.Drawable;
import edu.mephi.java.engine.GraphicsUtils;
import edu.mephi.java.engine.observable.Observable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Snake {
    public static final Color HEAD_COLOR = Color.GREEN;
    public static final Color BODY_COLOR = Color.PINK;
    private final ArrayObservableDeque<SnakePart> _points;
    private Direction _direction;

    public Snake(ArrayObservableDeque<SnakePart> points) {
        _points = points;
        _direction = Direction.NONE;
    }

    public Direction getDirection() {
        return _direction;
    }

    public void setDirection(Direction direction) {
        _direction = direction;
    }

    public List<Snake.SnakePart> getPoints() {
        return _points.getArray();
    }

    public SnakePart getHead() {
        return _points.getLast();
    }

    public void move() {
        if(_direction == Direction.NONE) return;
        _points.removeFirst();
        SnakeUtils.AddPartToSnake(_points, _direction);
    }

    public void eatApple(Apple apple, Observable observable){
        observable.removeObserver(apple);
        SnakeUtils.AddPartToSnake(_points, _direction);
    }
    public void clearSnake(){
        _points.clear();
    }

   public static class SnakePart implements Drawable {
        private final Point _point;
        private Color _color;

        public Point getPoint() {
            return _point;
        }

        public void setColor(Color color) {
            _color = color;
        }

        public Color getColor() {
            return _color;
        }

        public SnakePart(int x, int y, Color color) {
            _point = new Point(x, y);
            _color = color;
        }

       @Override
       public void draw(JPanel panel, Graphics g) {
           GraphicsUtils.drawCell(panel, g, _point, getColor());
       }

       @Override
       public void clear(JPanel panel, Graphics g) {
           GraphicsUtils.drawCell(panel, g, _point, Color.WHITE);
       }


   }
}
