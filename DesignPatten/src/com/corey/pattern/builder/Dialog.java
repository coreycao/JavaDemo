package com.corey.pattern.builder;

public class Dialog {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPositiveButton() {
        return positiveButton;
    }

    public void setPositiveButton(String positiveButton) {
        this.positiveButton = positiveButton;
    }

    public String getNegativeButton() {
        return negativeButton;
    }

    public void setNegativeButton(String negativeButton) {
        this.negativeButton = negativeButton;
    }

    public void show() {
        System.out.println(getTitle() + ":" + getContent());
    }

    private String title;
    private String content;
    private String positiveButton;
    private String negativeButton;

    public static class Builder {
        private Dialog dialog = new Dialog();

        public Dialog create() {
            return dialog;
        }

        public Dialog show() {
            System.out.println(dialog.getTitle() + ":" + dialog.getContent());
            return dialog;
        }

        public Builder setTitle(String title) {
            dialog.setTitle(title);
            return this;
        }

        public Builder setContent(String content) {
            dialog.setContent(content);
            return this;
        }

        public Builder setNegative(String text) {
            dialog.setNegativeButton(text);
            return this;
        }

        public Builder setPositive(String text) {
            dialog.setPositiveButton(text);
            return this;
        }
    }
}
