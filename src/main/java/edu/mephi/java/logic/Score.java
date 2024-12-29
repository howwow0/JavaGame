package edu.mephi.java.logic;

import javax.swing.*;

public class Score{
    private int _score;
    private final JFrame _jFrame;

    public Score(JFrame jFrame) {
        _jFrame = jFrame;
    }

    public int getScore() {
        return _score;
    }

    public void incrementScore() {
        ++_score;
        _jFrame.setTitle("Score: " + _score);
    }

    public void clearScore() {
        _score = 0;
        _jFrame.setTitle("Snake Game");
    }

}