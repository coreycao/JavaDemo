package me.corey.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcardTest {

    // 类型通配符的使用

    private static void getDataFromList(List<?> list) {
        System.out.println(list.get(0));
    }

    // 类型通配符也能够通过 extends进行类型限制
    private static void getNumberFromList(List<? extends Number> list) {
        System.out.println(list.get(0));
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("stringList");

        List<Integer> integerList = new ArrayList<>();
        integerList.add(12345);

        List<Float> floatList = new ArrayList<>();
        floatList.add(1.1f);

        getDataFromList(stringList);

        getDataFromList(integerList);

        getDataFromList(floatList);

        // 编译报错
        // getNumberFromList(stringList);

        getNumberFromList(integerList);

        getNumberFromList(floatList);
    }


}
