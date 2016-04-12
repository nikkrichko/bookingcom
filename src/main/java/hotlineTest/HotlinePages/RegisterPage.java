package hotlineTest.HotlinePages;

import Common.utils.Log4Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private User user;
    private WebDriver webDriver;

    private WebElement EMAIL_FIELD;
    private WebElement USER_NAME_FIELD;
    private WebElement PASSWORD_FIELD;
    private WebElement CONFIRM_PASWORD_FIELD;
    private WebElement REGISTER_BUTTON;
    private WebElement ERROR_PROFF;

    public RegisterPage(User user, WebDriver webDriver) {
        this.user = user;
        this.webDriver = webDriver;
        initElements();
    }

    public void register() {
        Log4Test.info("feel register form");
        EMAIL_FIELD.sendKeys(user.getUserEmail());
        USER_NAME_FIELD.sendKeys(user.getUserName());
        PASSWORD_FIELD.sendKeys(user.getPassword());
        CONFIRM_PASWORD_FIELD.sendKeys(user.getPassword());
        Log4Test.info("and press register button");
        REGISTER_BUTTON.submit();
    }

    private void initElements() {
        EMAIL_FIELD = webDriver.findElement(By.name("email"));
        USER_NAME_FIELD = webDriver.findElement(By.name("nick"));
        PASSWORD_FIELD = webDriver.findElement(By.name("password"));
        CONFIRM_PASWORD_FIELD = webDriver.findElement(By.name("password2"));
        REGISTER_BUTTON = webDriver.findElement(By.className("line-form-button")).findElement(By.className("blue-button"));

    }

    public WebElement getProof() {
        return ERROR_PROFF = webDriver.findElement(By.name("email"));
    }


}
