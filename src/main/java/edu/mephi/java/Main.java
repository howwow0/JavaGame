package edu.mephi.java;

import edu.mephi.java.engine.*;
import edu.mephi.java.logic.Direction;
import edu.mephi.java.logic.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    private final int WIDTH = 20;
    private final int HEIGHT = 20;
    private final int TILE_SIZE = 20;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Game");
        Game game = new Game();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        game.Start();

    }
}