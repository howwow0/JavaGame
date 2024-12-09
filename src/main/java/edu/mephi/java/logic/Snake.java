package edu.mephi.java.logic;
import edu.mephi.java.engine.ArrayObservableDeque;
import edu.mephi.java.engine.Drawable;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

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

    public SnakePart getHead() {
        return _points.getLast();
    }

    public SnakePart getTail() {
        return _points.getFirst();
    }

    public void move() {
        _points.removeFirst();
        SnakeUtils.AddPartToSnake(_points, _direction);
    }

    public void eatApple(){
        SnakeUtils.AddPartToSnake(_points, _direction);
    }

   public static class SnakePart implements Drawable {
        private Point _point;
        private Color _color;

        public void setPoint(Point point) {
            _point = point;
        }

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
       public void draw(GridLayout layout, Graphics g) {
           int x = _point.x * layout.getRows();
           int y = _point.y * layout.getColumns();
           g.setColor(getColor());
           g.drawRect(x, y, layout.getRows(), layout.getColumns());
       }

       @Override
       public void clear(GridLayout layout, Graphics g) {
           int x = _point.x * layout.getRows();
           int y = _point.y * layout.getColumns();
           g.clearRect(x, y, layout.getRows(), layout.getColumns());
       }


   }
}
