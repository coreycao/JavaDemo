package me.corey.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

public class Basic {
    public static void main(String[] args) {
//        System.out.println(Date.class.getName());
//        System.out.println(Date.class.getSimpleName());
//
//        try {
//            System.out.println(Class.forName("java.util.Date").getSimpleName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Date date = Date.class.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        Class clazz;
        try {
            clazz = Class.forName("java.util.Date");
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                StringBuilder sb = new StringBuilder();
                sb.append(Modifier.toString(constructor.getModifiers()));
                sb.append(" ");
                sb.append(constructor.getName());
                sb.append("(");

                Class[] paramTypes = constructor.getParameterTypes();
                for (int i = 0; i < paramTypes.length; i++) {
                    sb.append(paramTypes[i].getName());
                    sb.append(",");
                }
                if (paramTypes.length > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }

                sb.append(");");
                System.out.println(sb.toString());
            }
            System.out.println();

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                StringBuilder sb = new StringBuilder();
                sb.append(Modifier.toString(method.getModifiers()));
                sb.append(" ");
                sb.append(method.getReturnType().getName());
                sb.append(" ");
                sb.append(method.getName());
                sb.append("(");
                Class[] paramType = method.getParameterTypes();
                for (int i = 0; i < paramType.length; i++) {
                    sb.append(paramType[i].getName());
                    sb.append(",");
                }
                if (paramType.length > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(");");
                System.out.println(sb.toString());
            }
            System.out.println();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
