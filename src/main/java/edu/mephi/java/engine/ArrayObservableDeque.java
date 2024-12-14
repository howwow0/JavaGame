package edu.mephi.java.engine;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ArrayObservableDeque<E extends Drawable> {
    private final ArrayDeque<E> deque;
    private final Observable _observable;
    public ArrayObservableDeque(Observable observable) {
        this.deque = new ArrayDeque<>();
        _observable = observable;
    }

    public void addFirst(E e) {
        _observable.addObserver(e);
        deque.addFirst(e);
        _observable.notifyObservers();
    }

    public boolean add(E e) {
        _observable.addObserver(e);
        _observable.notifyObservers();
        return deque.add(e);
    }

    public void addLast(E e) {
        _observable.addObserver(e);
        deque.addLast(e);
        _observable.notifyObservers();
    }

    public E getLast() {
        return deque.getLast();
    }

    public E getFirst() {
        return deque.getFirst();
    }

    public void removeFirst() {
       _observable.removeObserver(deque.removeFirst());
    }

    public List<E> getArray(){
        return new ArrayList<>(deque);
    }
}
