package edu.mephi.java;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import edu.mephi.java.logic.Direction;
import edu.mephi.java.logic.Snake;

public class SnakeKeyListener extends KeyAdapter {
    private final Snake snake;
    private Direction nextDirection;

    public SnakeKeyListener(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                if (snake.getDirection() != Direction.DOWN)
                    nextDirection = Direction.UP;
                break;
            case KeyEvent.VK_S:
                if (snake.getDirection() != Direction.UP && snake.getDirection() != Direction.NONE)
                    nextDirection = Direction.DOWN;
                break;
            case KeyEvent.VK_A:
                if (snake.getDirection() != Direction.RIGHT)
                    nextDirection = Direction.LEFT;
                break;
            case KeyEvent.VK_D:
                if (snake.getDirection() != Direction.LEFT)
                    nextDirection = Direction.RIGHT;
                break;
        }
    }

    public Direction getNextDirection() {
        return nextDirection;
    }

    public void resetNextDirection() {
        nextDirection = null;
    }
}