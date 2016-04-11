package hotlineTest.HotlinePages;

import homeworks.utils.Log4Test;

public class User {
    private StringGenerator generator;
    private String userName;
    private String userEmail;
    private String password;

    public User() {
        generator = new StringGenerator();
        Log4Test.info("generate new User");
        this.userName = generator.generator(8);
        this.userEmail = generator.generator(8) + "@ya.ru";
        this.password = generator.generator(8);
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }
}
