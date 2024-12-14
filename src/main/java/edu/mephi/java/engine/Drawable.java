package edu.mephi.java.engine;

import javax.swing.*;
import java.awt.*;

public interface Drawable {
    void draw(JPanel panel, Graphics g);
    void clear(JPanel panel, Graphics g);
}
