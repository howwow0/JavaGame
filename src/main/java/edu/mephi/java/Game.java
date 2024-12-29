package edu.mephi.java;

import edu.mephi.java.engine.ArrayObservableDeque;
import edu.mephi.java.engine.observable.DrawableStateObserver;
import edu.mephi.java.engine.observable.Observable;
import edu.mephi.java.logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements ActionListener {
    public static final int HEIGHT = 10;
    public static final int WIDTH = 10;
    private final Timer _timer;
    private SnakeKeyListener _keyListener;
    private Observable _graphicsEngine;
    private Snake _snake;
    private Apple _apple;
    private final Score _score;
    private final JFrame _frame;

    public Game(JFrame jFrame) {
        _frame = jFrame;
        int TILE_SIZE = 20;
        setLayout(new GridLayout(HEIGHT, WIDTH));
        setPreferredSize(new Dimension(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE));
        setBackground(Color.WHITE);
        _score = new Score(jFrame);
        _timer = new Timer(200, this);
    }

    public void Start() {
        _graphicsEngine = new DrawableStateObserver(this);
        _snake = new Snake(new ArrayObservableDeque<>(_graphicsEngine) {
            {
                add(new Snake.SnakePart(WIDTH / 2, HEIGHT / 2, Snake.BODY_COLOR));
                add(new Snake.SnakePart(WIDTH / 2, HEIGHT / 2 - 1, Snake.HEAD_COLOR));
            }
        });
        _apple = AppleUtils.Generate(_snake.getPoints(), _graphicsEngine);
        _keyListener = new SnakeKeyListener(_snake);
        addKeyListener(_keyListener);
        setFocusable(true);
        requestFocusInWindow();
        _timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (_keyListener.getNextDirection() != null) {
            _snake.setDirection(_keyListener.getNextDirection());
            _keyListener.resetNextDirection();
        }
        if(_snake.getDirection() == Direction.NONE) return;
        if (SnakeUtils.hasNextPointApple(_snake.getHead(), _apple, _snake.getDirection())) {
            _snake.eatApple(_apple, _graphicsEngine);
            _score.incrementScore();
            _apple = AppleUtils.Generate(_snake.getPoints(), _graphicsEngine);
        } else if (SnakeUtils.hasNextPointWallOrSnakePart(_snake.getHead(), _snake.getPoints(), _snake.getDirection()))
            openEndGameDialogAndStopGame("Игра окончена вы проиграли. Ваш счет " + _score.getScore() +". Начать заново?");
        else
            _snake.move();
        if (_apple == null) {
            openEndGameDialogAndStopGame("Игра окончена вы выйграли. Ваш счет " + _score.getScore() +". Начать заново?");
        }
    }

    private void openEndGameDialogAndStopGame(String message) {
        _timer.stop();
        int n = JOptionPane.showOptionDialog(_frame,
                message,
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null);
        if (n == JOptionPane.YES_OPTION) {
            _graphicsEngine.clearObservers();
            _snake.clearSnake();
            _score.clearScore();
            _apple = null;
            Start();
        } else System.exit(0);
    }
}
