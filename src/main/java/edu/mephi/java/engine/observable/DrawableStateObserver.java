package edu.mephi.java.engine.observable;

import edu.mephi.java.engine.Drawable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//Графический движок - рисует все обьекты, интерфейс Drawable означает что обьект можно рисовать
public class DrawableStateObserver implements Observable, ActionListener {
    private final java.util.List<Drawable> _drawables;
    private final JPanel _panel;
    private final Graphics _graphics;

    public DrawableStateObserver(JPanel panel) {
        Timer _timer = new Timer(50, this);
        _drawables = new ArrayList<>();
        _panel = panel;
        _graphics = panel.getGraphics();
        _timer.start();
    }

    @Override
    public void addObserver(Drawable drawable) {
        _drawables.add(drawable);
    }

    @Override
    public void removeObserver(Drawable drawable) {
        drawable.clear(_panel, _graphics);
        _drawables.remove(drawable);
    }

    @Override
    public void notifyObservers() {
        for (Drawable drawable : _drawables) {
            drawable.draw(_panel, _graphics);
        }
    }

    @Override
    public void clearObservers() {
        for (Drawable drawable : _drawables) {
            drawable.clear(_panel, _graphics);
        }
        _drawables.clear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        notifyObservers();
    }
}
