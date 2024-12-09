package edu.mephi.java.engine;

import edu.mephi.java.logic.Direction;
import edu.mephi.java.logic.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JPanel implements ActionListener {
	private final int TILE_SIZE = 20;
	private final int WIDTH = 20;
	private final int HEIGHT = 20;
	private Timer timer;
	GridLayout gridLayout = new GridLayout(HEIGHT,WIDTH+1);
	public Game() {
		setLayout(gridLayout);
		setPreferredSize(new Dimension(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE));
		setBackground(Color.WHITE);
		timer = new Timer(1000, this);

	}
	Snake snake;
	public void Start() {
		DrawableStateObserver drawableStateObserver = new DrawableStateObserver(gridLayout, this.getGraphics());
		ArrayObservableDeque arrayObservableDeque = new ArrayObservableDeque<>(drawableStateObserver);
		arrayObservableDeque.add(new Snake.SnakePart(10,10, Snake.HEAD_COLOR));
		arrayObservableDeque.add(new Snake.SnakePart(10,9, Snake.BODY_COLOR));
		snake = new Snake(arrayObservableDeque);
		timer.start();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		snake.setDirection(Direction.RIGHT);
		snake.move();
	}
}
