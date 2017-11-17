package com.corey.pattern.observe;

import java.util.Observable;

public class SuperStar extends Observable {

    public void sayHi(String message) {
        setChanged();
        notifyObservers(message);
    }

    public void sayHi() {
        setChanged();
        notifyObservers();
    }
}
