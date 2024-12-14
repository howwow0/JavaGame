package edu.mephi.java;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Game");
        Game game = new Game();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        game.Start();
    }
}