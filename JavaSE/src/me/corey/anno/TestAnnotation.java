package me.corey.anno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TypeAnnotation(empno = 200, name = "sanyang")
public class TestAnnotation {

    @FieldAnnotation(10)
    int mField;

    @MethodAnnotation
    void mMethod() {

    }

    // 利用反射提取注解信息
    public static void main(String[] args) {
        boolean hasAnnotation = TestAnnotation.class.isAnnotationPresent(TypeAnnotation.class);

        if (hasAnnotation) {
            TypeAnnotation typeAnnotation = TestAnnotation.class.getAnnotation(TypeAnnotation.class);
            System.out.println(typeAnnotation.empno());
            System.out.println(typeAnnotation.name());
        }

        Field field = null;
        try {
            field = TestAnnotation.class.getDeclaredField("mField");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        FieldAnnotation fieldAnnotation =
                field.getAnnotation(FieldAnnotation.class);
        if (fieldAnnotation != null) {
            System.out.println(fieldAnnotation.value());
        }

        Method mMethod = null;
        try {
            mMethod = TestAnnotation.class.getDeclaredMethod("mMethod");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Annotation[] annotations = mMethod.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
        }
    }
}
