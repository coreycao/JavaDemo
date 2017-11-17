package com.corey.pattern.observe;

public class Phone {

    private User user;

    public Phone(User user) {
        this.user = user;
    }

    public void notifyNewMessage() {
        user.confirm();
    }
}
