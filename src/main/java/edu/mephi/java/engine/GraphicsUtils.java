package edu.mephi.java.engine;

import javax.swing.*;
import java.awt.*;

public class GraphicsUtils {
    public static void drawCell(JPanel panel, Graphics g, Point point, Color color) {
        int containerWidth = panel.getWidth();
        int containerHeight = panel.getHeight();

        int rows = ((GridLayout) panel.getLayout()).getRows();
        int columns = ((GridLayout) panel.getLayout()).getColumns();

        int cellWidth = containerWidth / columns;
        int cellHeight = containerHeight / rows;

        int x = point.x * cellWidth;
        int y = point.y * cellHeight;

        g.setColor(color);
        g.fillRect(x, y, cellWidth, cellHeight);
    }
}
