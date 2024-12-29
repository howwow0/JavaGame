package edu.mephi.java.logic;

import edu.mephi.java.engine.Drawable;
import edu.mephi.java.engine.GraphicsUtils;

import javax.swing.*;
import java.awt.*;

public class Apple implements Drawable {
    private final Point _point;
    private final Color _color;

    public Point getPoint() {
        return _point;
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
