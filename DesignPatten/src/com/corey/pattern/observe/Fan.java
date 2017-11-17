package com.corey.pattern.observe;

import java.util.Observable;
import java.util.Observer;

public class Fan implements Observer {

    private String name;

    public Fan(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (null == arg) {
            System.out.println(name + ":love you too.");
        } else {
            System.out.println(arg.toString() + ":love you too.");
        }
    }
}
