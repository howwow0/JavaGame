package edu.mephi.java.logic;

import edu.mephi.java.engine.Drawable;
import edu.mephi.java.engine.GraphicsUtils;

import javax.swing.*;
import java.awt.*;

public class Apple implements Drawable {
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

    public Apple(Point _point, Color _color) {
        this._point = _point;
        this._color = _color;
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
