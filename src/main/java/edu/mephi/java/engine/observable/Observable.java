package edu.mephi.java.engine.observable;

import edu.mephi.java.engine.Drawable;

public interface Observable {
    void addObserver(Drawable observer);
    void removeObserver(Drawable observer);
    void notifyObservers();
    void clearObservers();
}
