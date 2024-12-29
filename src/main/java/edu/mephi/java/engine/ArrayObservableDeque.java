package edu.mephi.java.engine;

import edu.mephi.java.engine.observable.Observable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
//Коллекция элементы которой автоматически рисуются нашим движком
public class ArrayObservableDeque<E extends Drawable> {
    private final ArrayDeque<E> deque;
    private final Observable _observable;
    public ArrayObservableDeque(Observable observable) {
        this.deque = new ArrayDeque<>();
        _observable = observable;
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
    public void clear()
    {
        for(E e : deque)
        {
            _observable.removeObserver(e);
        }
        deque.clear();
    }

    public E getLast() {
        return deque.getLast();
    }

    public void removeFirst() {
       _observable.removeObserver(deque.removeFirst());
    }

    public List<E> getArray(){
        return new ArrayList<>(deque);
    }
}
