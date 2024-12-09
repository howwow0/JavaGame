package edu.mephi.java.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class DrawableStateObserver implements Observable, ActionListener {
    private final java.util.List<Drawable> drawables;
    private final GridLayout _layout;
    private final Graphics _graphics;
    public DrawableStateObserver(GridLayout layout, Graphics g) {
        Timer _timer = new Timer(10, this);
        drawables = new LinkedList<>();
        _layout = layout;
        _graphics = g;
        _timer.start();
    }

    @Override
    public void addObserver(Drawable drawable) {
        drawables.add(drawable);
    }

    @Override
    public void removeObserver(Drawable drawable) {
        drawable.clear(_layout, _graphics);
        drawables.remove(drawable);
    }

    @Override
    public void notifyObservers() {
        for (Drawable drawable : drawables) {
            drawable.draw(_layout, _graphics);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        notifyObservers();
    }
}
