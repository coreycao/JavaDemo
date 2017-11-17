package com.corey.pattern;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Base {
    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());

/*        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("my");
        list.add("name");
        list.add("is");
        list.add("corey");

        String item = null;
        for (String s : list) {
            if (s.equals("my")) {
                item = s;
            }
        }
        if (item != null) {
            list.remove(item);
        }
//        printList(list);
        DecimalFormat mFormat = new DecimalFormat("###########0");
        String s = "89";

        System.out.println(mFormat.format(Float.valueOf(s)));*/
    }

    private static void printList(List<String> list) {
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
