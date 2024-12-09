package edu.mephi.java.engine;

public interface Observable {
    void addObserver(Drawable observer);
    void removeObserver(Drawable observer);
    void notifyObservers();
}
