package util;

import entity.User;

import java.util.function.Consumer;

/**
 * @author liushengbin
 * @date 2022/2/21
 */
public class ConsumerTest {

    private static void consumerTest(Consumer<User> user) {
        User user1 = new User();

        user1.setName("我先更改");
        System.out.println(user1);
        //消费方法
        user.accept(user1);
        System.out.println(user1);


    }
    /**
     *
     * @param name
     * @param user
     */
    private static void getUser(String name, User user) {

        user.setName(name);

    }
    public static void main(String[] args) {

        consumerTest(user -> getUser("name", user));

    }

}
