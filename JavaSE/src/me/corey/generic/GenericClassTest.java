package me.corey.generic;

public class GenericClassTest {

    static class Box<T> {
        private T t;

        public Box(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    static class NumberBox<N extends Number> {
        private N n;

        public N getN() {
            return n;
        }

        public void setN(N n) {
            this.n = n;
        }
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>("this is a string box;");

        Box<Integer> intBox = new Box<>(12345);

        // 编译报错
//        NumberBox<String> stringNumberBox;

        NumberBox<Double> doubleNumberBox;

        NumberBox<Float> floatNumberBox;

    }
}
