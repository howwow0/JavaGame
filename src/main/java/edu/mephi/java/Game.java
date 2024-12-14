package edu.mephi.java;

import edu.mephi.java.engine.ArrayObservableDeque;
import edu.mephi.java.engine.DrawableStateObserver;
import edu.mephi.java.engine.Observable;
import edu.mephi.java.logic.Apple;
import edu.mephi.java.logic.AppleUtils;
import edu.mephi.java.logic.Direction;
import edu.mephi.java.logic.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel implements ActionListener {
    private final Timer timer;
    public static final int HEIGHT = 20;
    public static final int WIDTH = 20;
    Observable drawableStateObserver;
    Snake snake;
    Apple apple;

    public Game() {
        int TILE_SIZE = 20;
        setLayout(new GridLayout(HEIGHT, WIDTH));
        setPreferredSize(new Dimension(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE));
        setBackground(Color.WHITE);
        timer = new Timer(15, this);
    }

    public void Start() {
        drawableStateObserver = new DrawableStateObserver(this);
        snake = new Snake(new ArrayObservableDeque<>(drawableStateObserver) {
            {
                add(new Snake.SnakePart(10, 10, Snake.BODY_COLOR));
                add(new Snake.SnakePart(10, 9, Snake.HEAD_COLOR));
            }
        });
        apple = AppleUtils.Generate(snake.getPoints(), drawableStateObserver);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.setDirection(Direction.RIGHT);
        snake.move();
        snake.setDirection(Direction.LEFT);
        snake.eatApple(apple, drawableStateObserver);
        apple = AppleUtils.Generate(snake.getPoints(), drawableStateObserver);
    }
}
