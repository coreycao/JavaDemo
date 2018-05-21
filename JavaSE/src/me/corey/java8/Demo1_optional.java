package me.corey.java8;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Demo1_optional {

    User user;

    public static void main(String[] args) {

    }

    void test() {
        // optional 有三种构造方法
        Optional<User> optionalUser1 = Optional.empty();
        Optional<User> optionalUser2 = Optional.of(new User());
        Optional<User> optionalUser3 = Optional.ofNullable(user);

        //存在即返回, 无则提供默认值
        optionalUser1.orElse(null);  //而不是 return user.isPresent() ? user.get() : null;
        optionalUser1.orElse(new User());

        //存在即返回, 无则由函数来产生
        optionalUser1.orElseGet(
                this::fetchUserFromDB
        );

        //存在才对它做点什么
        optionalUser1.ifPresent(System.out::println);

        //而不要下边那样
        if (optionalUser1.isPresent()) {
            System.out.println(optionalUser1.get());
        }

        // map的使用
        optionalUser1.map(u -> u.getOrders()).orElse(Collections.emptyList());

        //上面避免了我们类似 Java 8 之前的做法
        if (optionalUser1.isPresent()) {
            optionalUser1.get().getOrders();
        } else {
            Collections.emptyList();
        }

        // map  是可能无限级联的, 比如再深一层, 获得用户名的大写形式
        optionalUser1.map(u -> u.getUsername())
                .map(name -> name.toUpperCase())
                .orElse(null);

    }

    private User fetchUserFromDB() {
        return new User();
    }

    static class User {
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<String> getOrders() {
            return orders;
        }

        public void setOrders(List<String> orders) {
            this.orders = orders;
        }

        private String username;
        private int age;
        private List<String> orders;
    }
}
