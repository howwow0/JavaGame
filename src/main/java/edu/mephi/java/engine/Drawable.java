package edu.mephi.java.engine;

import java.awt.*;

public interface Drawable {
    void draw(GridLayout layout, Graphics g);
    void clear(GridLayout layout, Graphics g);
}
