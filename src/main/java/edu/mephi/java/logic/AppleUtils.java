package edu.mephi.java.logic;

import edu.mephi.java.Game;
import edu.mephi.java.engine.observable.Observable;

import java.awt.*;
import java.util.*;
import java.util.List;

public class AppleUtils {
    public static Apple Generate(List<Snake.SnakePart> snakeParts, Observable observable) {
        Set<Point> occupied = getOccupiedCells(snakeParts);
        List<Point> freeCells = getFreeCells(occupied);
        if (freeCells.isEmpty()) {
            return null;
        }
        Point randomCell = getRandomCell(freeCells);
        Apple apple = new Apple(randomCell, Color.RED);
        observable.addObserver(apple);
        return apple;
    }


    private static Set<Point> getOccupiedCells(List<Snake.SnakePart> snakeParts) {
        Set<Point> occupied = new HashSet<>();
        for (Snake.SnakePart part : snakeParts) {
            occupied.add(part.getPoint());
        }
        return occupied;
    }

    private static List<Point> getFreeCells(Set<Point> occupied) {
        List<Point> freeCells = new ArrayList<>();
        for (int x = 0; x < Game.WIDTH; x++) {
            for (int y = 0; y < Game.HEIGHT; y++) {
                Point cell = new Point(x, y);
                if (!occupied.contains(cell)) {
                    freeCells.add(cell);
                }
            }
        }
        return freeCells;
    }

    private static Point getRandomCell(List<Point> freeCells) {
        int randomIndex = (int) (Math.random() * freeCells.size());
        return freeCells.get(randomIndex);
    }

}
