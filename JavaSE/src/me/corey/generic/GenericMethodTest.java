package me.corey.generic;

public class GenericMethodTest {

    private static <V> void printArray(V[] array) {
        for (V v : array) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // 必须是封装类型
        Integer[] intArray = {1, 2, 3, 4, 5};

        Character[] charArray = {'a', 'b', 'c', 'd', 'e'};

        printArray(intArray);

        printArray(charArray);

    }
}
