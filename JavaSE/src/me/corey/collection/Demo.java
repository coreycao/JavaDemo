package me.corey.collection;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<Object,Object> map = new HashMap<>();
        map.put(null,null);
        System.out.println(map.get(null));
    }
}
