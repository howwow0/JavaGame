package edu.mephi.java.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DrawableStateObserver implements Observable, ActionListener {
    private final java.util.List<Drawable> drawables;
    private final JPanel _panel;
    private final Graphics _graphics;

    public DrawableStateObserver(JPanel panel) {
        Timer _timer = new Timer(10, this);
        drawables = new ArrayList<>();
        _panel = panel;
        _graphics = panel.getGraphics();
        _timer.start();
    }

    @Override
    public void addObserver(Drawable drawable) {
        drawables.add(drawable);
    }

    @Override
    public void removeObserver(Drawable drawable) {
        drawable.clear(_panel, _graphics);
        drawables.remove(drawable);
    }

    @Override
    public void notifyObservers() {
        for (Drawable drawable : drawables) {
            drawable.draw(_panel, _graphics);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        notifyObservers();
    }
}
