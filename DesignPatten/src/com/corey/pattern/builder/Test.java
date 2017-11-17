package com.corey.pattern.builder;

public class Test {
    public static void main(String[] args) {

        Dialog.Builder builder = new Dialog.Builder();
        Dialog dialog = builder.setTitle("hi")
                .setContent("hello world")
                .create();
        dialog.show();
    }
}
