package com.corey.pattern.observe;

public class Test {
    public static void main(String[] args) {
        User user = new UserImpl();
        Phone phone = new Phone(user);
        phone.notifyNewMessage();
    }

    private static void sayHi() {
        SuperStar superStar = new SuperStar();
        superStar.addObserver(new Fan("Jack"));
        superStar.addObserver(new Fan("Rose"));
        superStar.sayHi();
    }

    private static void sayHi(String message) {
        SuperStar superStar = new SuperStar();
        superStar.addObserver(new Fan("Jack"));
        superStar.addObserver(new Fan("Rose"));
        superStar.sayHi(message);
    }
}
