package me.corey.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * https://blog.csdn.net/claram/article/details/53410175
 */
public class RemoveTarget {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(15);
        list.add("beijing");
        list.add("shanghai");
        list.add("shanghai");
        list.add("guangzhou");
        list.add("shenzhen");
        list.add("hangzhou");

        remove31(list, "shanghai");

    }

    private static void print(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void remove11(List<String> list, String target) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String item = list.get(i);
            if (target.equals(item)) {
                list.remove(item);
            }
        }
        print(list);
    }

    public static void remove12(List<String> list, String target) {
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            if (target.equals(item)) {
                list.remove(item);
            }
        }
        print(list);
    }

    public static void remove13(List<String> list, String target) {
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            String item = list.get(i);
            if (target.equals(item)) {
                list.remove(item);
            }
        }
        print(list);
    }

    public static void remove14(List<String> list, String target) {
        for (int i = list.size() - 1; i >= 0; i--) {
            String item = list.get(i);
            if (target.equals(item)) {
                list.remove(item);
            }
        }
        print(list);
    }

    public static void remove21(List<String> list, String target) {
        for (String item : list) {
            if (target.equals(item)) {
                list.remove(item);
            }
        }
        print(list);
    }

    public static void remove22(List<String> list, String target) {
        final CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>(list);
        for (String item : cowList) {
            if (item.equals(target)) {
                cowList.remove(item);
            }
        }
        print(cowList);
    }

    public static void remove31(List<String> list, String target) {
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String item = iter.next();
            if (item.equals(target)) {
                list.remove(item);
            }
        }
        print(list);
    }

    public static void remove32(List<String> list, String target) {
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String item = iter.next();
            if (item.equals(target)) {
                iter.remove();
            }
        }
        print(list);
    }
}
