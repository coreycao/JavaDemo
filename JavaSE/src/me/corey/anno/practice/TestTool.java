package me.corey.anno.practice;

import java.lang.reflect.Method;

/**
 * Ref https://blog.csdn.net/briblue/article/details/73824058
 * 注解 @TestErr 的 APT
 */
public class TestTool {

    public static void main(String[] args) {
        Caculate caculate = new Caculate();

        Class clazz = caculate.getClass();

        Method[] methods = clazz.getMethods();

        StringBuilder log = new StringBuilder();

        int errNum = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(TestErr.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(caculate);
                } catch (Exception e) {
                    errNum++;
                    log.append(method.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    //记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }

        log.append(clazz.getSimpleName());
        log.append(" has  ");
        log.append(errNum);
        log.append(" error.");

        // 生成测试报告
        System.out.println(log.toString());
    }
}
